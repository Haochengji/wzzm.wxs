package com.wzzz.wxs.order.cn.controller;

import com.wzzz.wxs.order.cn.service.OrderAndMenuService;
import com.wzzz.wxs.order.cn.util.OrdeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
@Api(value = "api")
public class OrderController {
    @Autowired
    private OrderAndMenuService orderAndMenuService;
    @ResponseBody
    @ApiOperation(value = "获取盈豆数量", notes = "获取盈豆数量", httpMethod = "POST")
    @RequestMapping(value="/addorder", method= RequestMethod.POST)
    public String aa(@RequestBody List<OrdeUtil> ordeUtils){
        return orderAndMenuService.insertoam(ordeUtils);
    }
}
