package com.xianshuiyu.webshop.demos.web;

import com.xianshuiyu.webshop.demos.web.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class configWebConfig implements WebMvcConfigurer
{
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry)//拦截器配置
    {
        Integer code;
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("").excludePathPatterns("/login");
    }
}
