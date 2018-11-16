package com.wzm.entran.entran.cn.service;

public interface Login {
    /**
     * 登录 如用户不存在则添加新用户 并生成5位长度用户名
     * @param code 登录凭证
     * @return 用户名 用户ID 的json字符串
     */
    String login(String code);
}
