package com.example.controller;

import com.sun.javafx.sg.prism.NGShape;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by naruto on 2017/5/26.
 */
@Controller
public class RegisterController {

    @RequestMapping("/reg")
    public String reg(){
        return "login/register";
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public Map<String,Object> checkUserName(String username){
        Map<String, Object> map = new HashMap<String, Object>();
        if(username.equals("zhangsan")){
            map.put("issuccess", true);
        }else{
            map.put("issuccess", false);
            map.put("msg", "用户名不正确");
        }
        return map;
    }

    @RequestMapping("/checkMobile")
    @ResponseBody
    public Map<String,Object> checkMobile(String mobile){
        Map<String, Object> map = new HashMap<String, Object>();
        if(mobile.equals("12345678901")){
            map.put("issuccess", true);
        }else{
            map.put("issuccess", false);
            map.put("msg", "手机号不正确");
        }
        return map;
    }

    @RequestMapping("/userReg")
    public ModelAndView userReg(String username,String pwd,String mobile){
        ModelAndView model = new ModelAndView();
        //验证用户名和手机号 是否符合正则和后台service返回值的校验

        return model;
    }
}
