package com.wzm.entran.entran.cn.controller;

import com.wzm.entran.entran.cn.service.impl.LoginImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

@Controller
@RequestMapping("/Entrance")
@Api(value="登录controller",tags={"用户登录接口"})
public class Entrance {
    @Autowired
    private LoginImpl logins;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value = "登录", httpMethod = "GET", response = User.class, notes = "登录后获取用户ID和username")
    public String login(@ApiParam(name = "code",value = "登录凭证code")String code){
        System.out.println(1);
        return logins.login(code);
    }
}

