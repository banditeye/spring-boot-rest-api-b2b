package com.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
           

        return new Docket(DocumentationType.SWAGGER_2)
               
                .select()
                .paths(regex("/api.*"))
               
                .build();
    }

}