package com.lk.ijse.spring.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.lk.ijse.spring"})
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
