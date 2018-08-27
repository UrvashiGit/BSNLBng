package com.sterlite.bsnl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sterlite.bsnl.interceptor.LoginInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class ConfigApplication extends WebMvcConfigurerAdapter{
	
	@Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/image/**","/css/**","/vendor/**","/js/**");
    }
}
