package com.myapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
@EnableEncryptableProperties
public class Application extends SpringBootServletInitializer {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(Application.class);  
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

