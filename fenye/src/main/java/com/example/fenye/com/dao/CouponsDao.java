package com.example.fenye.com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Coupons;

import java.util.List;
@Repository("cd")
@Mapper
public interface CouponsDao {
    /**
     * 查询优惠券信息
     *
     * @param coupons
     * @return
     */
    List<Coupons> getAllCoupons(Coupons coupons);

    /**
     * 修改用户优惠券状态
     *
     * @param cou 优惠券对象
     * @return 受影响心数
     */
    int updatacoupons(Coupons cou);

    /**
     * 新增一个优惠券
     *
     * @param cou 优惠券对象
     * @return 受影响心数
     */
    int insertcoupons(Coupons cou);


}
