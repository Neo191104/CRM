package com.hwua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMVCExtConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("pages/main");
                registry.addViewController("/index.html").setViewName("pages/main");
                registry.addViewController("/pages/main.html").setViewName("pages/main");
                registry.addViewController("/pages/user-list.html").setViewName("pages/user-list");
                registry.addViewController("/pages/user-list1.html").setViewName("pages/user-list1");
                registry.addViewController("/pages/role-list.html").setViewName("pages/role-list");
                registry.addViewController("/pages/permission-list.html").setViewName("pages/permission-list");
                registry.addViewController("/pages/syslog-list.html").setViewName("pages/syslog-list");
                registry.addViewController("/pages/product-list1.html").setViewName("pages/product-list1");
                registry.addViewController("/pages/orders-page-list.html").setViewName("pages/orders-page-list");
                registry.addViewController("/pages/user-add.html").setViewName("pages/user-add");
                registry.addViewController("/pages/user-show1.html").setViewName("pages/user-show1");
                registry.addViewController("/pages/user-role-add.html").setViewName("pages/user-role-add");
                registry.addViewController("/pages/role-add.html").setViewName("pages/role-add");
                registry.addViewController("/pages/user-role-add.html").setViewName("pages/user-role-add");
                registry.addViewController("/pages/role-show.html").setViewName("pages/role-show");
                registry.addViewController("/pages/role-permission-add.html").setViewName("pages/role-permission-add");
                registry.addViewController("/pages/permission-add.html").setViewName("pages/permission-add");
                registry.addViewController("/pages/permission-show.html").setViewName("pages/permission-show");
                registry.addViewController("/pages/product-add.html").setViewName("pages/product-add");
                registry.addViewController("/pages/orders-page-list.html").setViewName("pages/orders-page-list");
                registry.addViewController("/pages/orders-show.html").setViewName("pages/orders-show");
            }
          /*  @Override
            public void addInterceptors(InterceptorRegistry registry) {
                *//*注册自定义的拦截器，对所有的请求的进行拦截，排除登录相关页面的请求*//*
                registry.addInterceptor(new ValidateUserInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/login.html","/user/login");
            }
*/
        };
    }
}
