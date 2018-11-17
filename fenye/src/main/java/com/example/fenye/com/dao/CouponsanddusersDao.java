package com.example.fenye.com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Couponsandusers;

import java.util.List;
@Repository("cdd")
@Mapper
public interface CouponsanddusersDao {
    /**
     * 查找此用户拥有的优惠券
     *
     * @param cd 优惠券信息对象
     * @return 优惠券信息集合
     */
    List<Couponsandusers> selCouponsanddusersDao(Couponsandusers cd);

    /**
     * 修优惠券状态信息
     *
     * @param cd 优惠券信息对象
     * @return 受影响行数
     */
    int updataCouponsanddusersDao(Couponsandusers cd);

    /**
     * 新增一个优惠券信息
     *
     * @param cd 优惠券关系对象
     * @return 首影响行数
     */
    int insertCouponsanddusersDao(Couponsandusers cd);

}
