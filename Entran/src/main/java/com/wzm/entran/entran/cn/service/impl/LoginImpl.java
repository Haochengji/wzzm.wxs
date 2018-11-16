package com.wzm.entran.entran.cn.service.impl;

import com.alibaba.fastjson.JSON;
import com.wzm.entran.entran.cn.service.Login;
import com.wzm.entran.entran.cn.dao.UserDao;
import com.wzm.entran.entran.cn.util.OpenIdBycode;
import com.wzm.entran.entran.cn.util.RandomStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;

@Service
public class LoginImpl implements Login {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OpenIdBycode openIdBycode;

    @Override
    public String login(String code){
        System.out.println(code);
        if("".equals(code) || code == null){
            return "请提交code";
        }else if(code.length() < 5 ){
            return "code不正确";
        }
        String openid = openIdBycode.getOpenid(code);
        if(openid == null){
            return "code过期或无效";
        }
        User user = new User();
        user.setUpwd(openid);
        user.setUtype(1);
        List<User> users = userDao.allUser(user);
        if(users.size() > 0){
            User user1 = users.get(0);
            user1.setUpwd(null);
            user1.setUphone(null);
            return JSON.toJSONString(user1);
        }else{
            User user1 = new User();
            user1.setUpwd(openid);
            user1.setUtype(1);
            user1.setUname(RandomStr.getRandomString(5));
            int count = userDao.addUser(user1);
            if(count < 0){
                return "登录失败，请重试";
            }
            user1.setUpwd(openid);
            user1 = userDao.allUser(user1).get(0);
            user1.setUpwd(null);
            return JSON.toJSONString(user1);
        }
    }
}
