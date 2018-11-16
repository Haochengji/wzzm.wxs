package com.wzzz.wxs.order.cn.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class OpenIdBycode {

    public String getOpenid(String code) {
//        Logger logger = Logger.getLogger()
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
        HttpClient hc = new DefaultHttpClient();
        //小程序登录凭证检验 请求地址
        HttpGet hg = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid=wx029d141ee4db450e&secret=1f08a8645471421667ba98b8fd7ed82c&js_code=" + code + "&grant_type=authorization_code");
        HttpResponse resp = null;
        String openid = "";
        try {
            resp = hc.execute(hg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = resp.getEntity();
            try {
                //请求得到的响应内容 用户唯一标识
                openid = EntityUtils.toString(resEntity, "utf-8");
                System.out.println(openid);
                Openid openid1 = JSON.parseObject(openid, Openid.class);
                openid = openid1.getOpenid();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("请求失败");
        }
        return openid;
    }
}
