package com.handeware.algorithms.config;

import com.handeware.algorithms.service.AlgorithmServiceImpl;
import com.handeware.algorithms.service.AlgorithmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AlgorithmsConfig implements WebMvcConfigurer {

    @Bean
    @Autowired
    public AlgorithmsService algorithmsServiceImpl() {
        return new AlgorithmServiceImpl();
    }

}
