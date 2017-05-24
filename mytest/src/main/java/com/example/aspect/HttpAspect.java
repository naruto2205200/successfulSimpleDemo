package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP切面
 * Created by naruto on 2017/5/18.
 */
@Aspect
@Component
public class HttpAspect {
    @Before("execution(public * com.example.controller.*.*(..))")
    public void log(){
        System.out.println("AOP方法前调用");
    }


}
