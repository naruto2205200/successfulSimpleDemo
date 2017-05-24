package com.example.controller;

import com.example.common.ReturnResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by naruto on 2017/5/20.
 */
@Controller
public class LoginController {

    /**
     * 返回登录页面
     * @param returnUrl
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value="returnUrl",required = false) String returnUrl){
        ModelAndView model = new ModelAndView("login");
        model.addObject("returnUrl",returnUrl);
        return model;
    }

    /**
     * 登录校验
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/toLogin")
    @ResponseBody
    public ReturnResult toLogin(HttpServletResponse response, String username, String password){
        //校验登录
        //1.登录失败，则返回错误信息
        //2、登录成功则保存用户信息，继续往下执行
        //doLogin(response);//保存cookie
        return ReturnResult.ok();
    }

    public void doLogin(HttpServletResponse response){
        Cookie cookie = new Cookie("login","login");
        cookie.setDomain(".xxx.com");//.跨域共享cookie
        cookie.setPath("/");//可在同一应用服务器内共享方法
        response.addCookie(cookie);
    }
}
