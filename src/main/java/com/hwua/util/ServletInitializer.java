package com.hwua.util;

import com.hwua.SpringbootCrmApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(SpringbootCrmApplication.class);
    }
}