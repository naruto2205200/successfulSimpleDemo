package com.example.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by naruto on 2017/5/29.
 */
public class MobileResultUtils {
    public static Map<String,String> getMobileResult(String param){
        Map<String, String> map = new HashMap<String, String>();
        map.put("code", param);
        switch (param){
            case "-1":
                map.put("message","没有该用户账户");
                break;
            case "-2":
                map.put("message","接口密钥不正确,不是账户登陆密码");
                break;
            case "-21":
                map.put("message","MD5接口密钥加密不正确");
                break;
            case "-3":
                map.put("message","短信数量不足");
                break;
            case "-11":
                map.put("message","该用户被禁用");
                break;
            case "-14":
                map.put("message","短信内容出现非法字符");
                break;
            case "-4":
                map.put("message","手机号格式不正确");
                break;
            case "-41":
                map.put("message","手机号码为空");
                break;
            case "-42":
                map.put("message","短信内容为空");
                break;
            case "-51":
                map.put("message","短信签名格式不正确");
                break;
            case "-6":
                map.put("message","IP限制");
                break;
            default:
                map.put("message","发送成功！");
                break;
        }
        return map;
    }
}
