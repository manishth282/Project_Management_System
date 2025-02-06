package com.Project.test.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APPConfig {
    @Bean
    public ModelMapper getModel(){
        return new ModelMapper();
    }
}
