package com.example.interceptor;

import com.example.interceptor.MyInterceptor;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by naruto on 2017/5/20.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    /**
     * 拦截器链
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
