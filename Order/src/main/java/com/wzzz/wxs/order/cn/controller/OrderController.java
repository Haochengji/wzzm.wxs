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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
@Api(value = "订单管理")
public class OrderController {
    @Autowired
    private OrderAndMenuService orderAndMenuService;
    @ResponseBody
    @RequestMapping("/addorder")
    @ApiOperation(value = "增加订单 ", httpMethod = "POST", response = String.class, notes = "点餐成功或失败")
    @ApiImplicitParams({@ApiImplicitParam(name = "ordeUtils",value="订单集合")})
    public String aa(@RequestBody List<OrdeUtil> ordeUtils){
        return orderAndMenuService.insertoam(ordeUtils);
    }
}
