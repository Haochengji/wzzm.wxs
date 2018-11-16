package com.wzzz.wxs.order.cn.service;

import com.wzzz.wxs.order.cn.util.OrdeUtil;

import java.util.List;


public interface OrderAndMenuService {
    /**
     * 根据订单id查找订单信息详情
     * @param ordeUtil 订单id
     * @return  订单信息详情集合
     */
    OrdeUtil seloam(OrdeUtil ordeUtil);

    /**
     * 增加一条订单详情信息
     * @param ordeUtils 订单详情信息对象
     * @return 受影响行数
     */
   String insertoam(List<OrdeUtil> ordeUtils);
}
