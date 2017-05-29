package com.example.util;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.HttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by naruto on 2017/5/29.
 */
public class SendMobileMsg {

    public String sendMobileMessage() throws IOException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", "naruto2205200") // 注册的用户名
                ,new NameValuePair("Key", "d5bd1ac3898fea7cb549") //注册成功后,登录网站使用的密钥
                ,new NameValuePair("smsMob","13661378695")// 手机号码
                ,new NameValuePair("smsText","发送成功！！！")};//设置短信内容
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("utf8"));
        System.out.println(result);
        post.releaseConnection();
        return result;
    }
}
