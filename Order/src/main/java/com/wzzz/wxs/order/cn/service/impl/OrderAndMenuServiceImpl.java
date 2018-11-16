package com.wzzz.wxs.order.cn.service.impl;

import com.wzzz.wxs.order.cn.dao.UserDao;
import com.wzzz.wxs.order.cn.service.OrderAndMenuService;
import com.wzzz.wxs.order.cn.util.OpenIdBycode;
import com.wzzz.wxs.order.cn.util.OrdeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class OrderAndMenuServiceImpl implements OrderAndMenuService {
    @Autowired
  private   RedisTemplate redisTemplate;
    @Autowired
    private OpenIdBycode openIdBycode;
    @Autowired
    private UserDao userDao;
    @Override
    @Autowired
    public OrdeUtil seloam(OrdeUtil ordeUtil) {
        if (ordeUtil != null){
            User user = new User();
            String openid = openIdBycode.getOpenid(ordeUtil.getCode());
            user.setUpwd(openid);
            List<User> users = userDao.allUser(user);
            Integer uid = users.get(0).getUid();
            ordeUtil.setUid(uid);
        }
        return ordeUtil;
    }

    @Override
    public String insertoam(List<OrdeUtil> ordeUtils) {
        OrdeUtil ordeUtil = new OrdeUtil();
        ordeUtil.setCode(ordeUtils.get(0).getCode());
        OrdeUtil seloam = seloam(ordeUtil);
        Integer ii = 1;
        String aa ;
        ValueOperations<String, Map<Integer,List<OrdeUtil>>> operations = redisTemplate.opsForValue();
        String a = "用户id" + seloam.getUid();
        if (operations.get(a) == null){
            Map<Integer,List<OrdeUtil>> map = new HashMap<Integer,List<OrdeUtil>>();
            map.put(ii,ordeUtils);
            operations.set(a,map);
            redisTemplate.expire("a", 1, TimeUnit.DAYS);
            aa ="点餐成功";
        }else {
            Map<Integer, List<OrdeUtil>> map = operations.get(a);
            Set<Integer> keys = map.keySet();
            Object[] objs = keys.toArray();
            int[] ints = new int[objs.length];
            for (int x = 0; x < objs.length; x++) {
                ints[x] = Integer.parseInt(objs[x].toString());
            }
            Arrays.sort(ints);
            int bigInt = ints[ints.length - 1];
            map.put(bigInt + 1, ordeUtils);
            operations.set(a,map);
            aa = "点餐成功";
            redisTemplate.expire("a", 1, TimeUnit.DAYS);
        }
        return aa;
    }
}
