package com.example.fenye.com.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.fenye.com.dao.*;
import com.example.fenye.com.service.LimitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pojo.*;

import java.util.List;

@Service
@Repository("lsi")
public class LimitServiceImpl implements LimitService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    @Qualifier("cdd")
    private CouponsanddusersDao cdd;
    public CouponsanddusersDao getCdd() {
        return cdd;
    }

    public void setCdd(CouponsanddusersDao cdd) {
        this.cdd = cdd;
    }


    @Autowired
    @Qualifier("md")
    private MenuDao md;

    public MenuDao getMd() {
        return md;
    }

    public void setMd(MenuDao md) {
        this.md = md;
    }

    @Autowired
    @Qualifier("dd")
    private DishesDao dd;

    public DishesDao getDd() {
        return dd;
    }

    public void setDd(DishesDao dd) {
        this.dd = dd;
    }

    @Autowired
    @Qualifier("od")
    private OrderDao od;

    public OrderDao getOd() {
        return od;
    }

    public void setOd(OrderDao od) {
        this.od = od;
    }

    @Autowired
    @Qualifier("cd")
    private CouponsDao cd;

    public CouponsDao getCd() {
        return cd;
    }

    public void setCd(CouponsDao cd) {
        this.cd = cd;
    }


    /**
     * 插件显示菜品分页
     *
     * @param index    页码
     * @param pagesize 显示条数
     * @return菜品集合的json字符串
     */
    public String getPageByIndex(int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        List<Menu> allMenu = md.getAllMenu(null);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(allMenu);

        return JSON.toJSONString(pageInfo.getList());
    }


    /**
     * 插件显示菜品分页
     * * @param mdishes 种类
     *
     * @param index    页码
     * @param pagesize 显示条数
     * @return菜品集合的json字符串
     */
    @Override
    public String getmenu(int mdishes, int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        Menu menu = new Menu();
        menu.setMdishes(mdishes);
        List<Menu> all = md.getAllMenuByDishes(menu);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(all);
        return JSON.toJSONString(pageInfo.getList());
    }

    /**
     * 分页显示用户的优惠券
     *
     * @param cauuid 用户ID
     * @return
     */
    @Override
    public String getCaU(int cauuid, int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        Couponsandusers csd = new Couponsandusers();
        csd.setCauuid(cauuid);

        List<Couponsandusers> couponsandusersList = cdd.selCouponsanddusersDao(csd);

        PageInfo<Couponsandusers> pageInfo = new PageInfo<Couponsandusers>(couponsandusersList);

        return JSON.toJSONString(pageInfo.getList());
    }

    @Override
    public String getMenuInfo(int id) {
        return JSON.toJSONString(md.getMenuInfo(id));
    }


    /**
     * 插件显示菜品种类分页
     *
     * @param index    页码
     * @param pagesize 显示条数
     * @return 菜品种类集合的json字符串
     */
    public String getDishesIndex(int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        List<Dishes> allDishes = dd.getAllDishes(null);
        PageInfo<Dishes> pageInfo = new PageInfo<Dishes>(allDishes);
        return JSON.toJSONString(pageInfo.getList());
    }

    /**
     * 插件显示订单分页
     *
     * @param index    页码
     * @param pagesize 显示条数
     * @return 菜品种类集合的json字符串
     */
    public String getOrderIndex(int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        List<Order> allOrder = od.getOrdersByOrder(null);
        PageInfo<Order> pageInfo = new PageInfo<Order>(allOrder);
        return JSON.toJSONString(pageInfo.getList());
    }

    /**
     * 优惠券
     *
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getCouponsIndex(int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        List<Coupons> couponsList = cd.getAllCoupons(null);
        PageInfo<Coupons> pageInfo = new PageInfo<Coupons>(couponsList);
        return JSON.toJSONString(pageInfo.getList());
    }
}
