package com.example.interceptor;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by naruto on 2017/5/24.
 */
public class LoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("登录拦截");
        //验证是否登录
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie :cookies){
                if(cookie.getName().equals("login")&&cookie.getValue().equals("login")){
                    return true;
                }
            }
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
