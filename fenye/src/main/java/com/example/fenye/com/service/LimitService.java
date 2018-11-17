package com.example.fenye.com.service;



public interface LimitService {
    /**
     * 菜品信息分页展示
     *
     * @param index    页码
     * @param pagesize 每页显示量
     * @return 菜品信息集合的json字符串
     */
    String getPageByIndex(int index, int pagesize);

    /**
     * 菜品种类分页显示
     *
     * @param index    页码
     * @param pagesize 每页显示量
     * @return 菜品种类集合的json字符串
     */
    String getDishesIndex(int index, int pagesize);

    /**
     * 分页展示订单
     *
     * @param index
     * @param pagesize
     * @return
     */
    String getOrderIndex(int index, int pagesize);

    /**
     * 分页展示优惠券
     *
     * @param index
     * @param pagesize
     * @return
     */
    String getCouponsIndex(int index, int pagesize);


    /**
     * 根据菜品种类查菜单
     *
     * @param mdishes
     * @param index
     * @param pagesize
     * @return
     */
    String getmenu(int mdishes, int index, int pagesize);

    /**
     * 该用户的优惠券
     *
     * @param cauuid
     * @param index
     * @param pagesize
     * @return
     */
    String getCaU(int cauuid, int index, int pagesize);

    /**
     * 根据菜品ID展示菜品信息
     *
     * @param id 菜品id
     * @return 菜品集合
     */
    String getMenuInfo(int id);

}
