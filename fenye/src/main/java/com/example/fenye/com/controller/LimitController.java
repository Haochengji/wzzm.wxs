package com.example.fenye.com.controller;
import com.example.fenye.com.service.LimitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.Coupons;
import pojo.Dishes;
import pojo.Menu;

@RestController
@RequestMapping("/a")
@Api(value = "api/Limit")
public class LimitController {
    @Autowired
    @Qualifier("lsi")
    private LimitService ls;

    //查菜品
    @ApiOperation(value = "查询菜品", httpMethod = "GET", response = Menu.class, notes = "菜品集合")
    @RequestMapping("/limit")
    @ApiImplicitParams({@ApiImplicitParam(name = "index", value = "页码"), @ApiImplicitParam(name = "pagesize", value = "每页显示量")})
    public String dsf( Integer index, Integer pagesize) {
        return ls.getPageByIndex(index, pagesize);
    }

    @ApiOperation(value = "查询菜品根据菜品种类 ", httpMethod = "GET", response = Menu.class, notes = "菜品集合")
    @RequestMapping("/dmenu")
    @ApiImplicitParams({@ApiImplicitParam(name = "mdishes", value = "种类"), @ApiImplicitParam(name = "index", value = "页码"), @ApiImplicitParam(name = "pagesize", value = "每页显示量")})
    public String dsfd(Integer mdishes, Integer index, Integer pagesize) {
        return ls.getmenu(mdishes, index, pagesize);
    }

    //查菜品种类
    @ApiOperation(value = "菜品种类 ", httpMethod = "GET", response = Dishes.class, notes = "菜品种类集合")
    @RequestMapping("/dshesinfo")
    @ApiImplicitParams({@ApiImplicitParam(name = "index", value = "页码"), @ApiImplicitParam(name = "pagesize", value = "每页显示量")})
    public String df(Integer index, Integer pagesize) {
        System.out.println(1);
        System.out.println(index);
        System.out.println(pagesize);
        return ls.getDishesIndex(index, pagesize);
    }

    //查订单
    @ApiOperation(value = "订单查询 ", httpMethod = "GET", response = OrderUtils.class, notes = "订单集合")
    @RequestMapping("/orderinfo")
    @ApiImplicitParams({@ApiImplicitParam(name = "index", value = "页码"), @ApiImplicitParam(name = "pagesize", value = "每页显示量")})
    public String dssf(Integer index, Integer pagesize) {
        return ls.getOrderIndex(index, pagesize);
    }

    @ApiOperation(value = "店铺优惠券 ", httpMethod = "GET", response = Coupons.class, notes = "店铺优惠券集合")
    @RequestMapping("/cou")
    @ApiImplicitParams({@ApiImplicitParam(name = "index", value = "页码"), @ApiImplicitParam(name = "pagesize", value = "每页显示量")})
    public String f(Integer index, Integer pagesize) {
        return ls.getCouponsIndex(index, pagesize);
    }



    @ApiOperation(value = "用户优惠券", httpMethod = "GET", response = Coupons.class, notes = "用户优惠券集合")
    @RequestMapping("/caufy")
    @ApiImplicitParams({@ApiImplicitParam(name = "cauuid", value = "用户id"), @ApiImplicitParam(name = "index", value = "页码"), @ApiImplicitParam(name = "pagesize", value = "每页显示量")})
    public String bf(Integer cauuid, Integer index, Integer pagesize) {

        return ls.getCaU(cauuid, index, pagesize);
    }


    @ApiOperation(value = "菜品信息", httpMethod = "GET", response = Menu.class, notes = "菜品信息对象")
    @RequestMapping("/gf")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "菜品ID")})
    public String gf(Integer id) {
        return ls.getMenuInfo(id);
    }
}
