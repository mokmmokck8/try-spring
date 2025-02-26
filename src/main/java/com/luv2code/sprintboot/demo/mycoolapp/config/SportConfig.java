package com.luv2code.sprintboot.demo.mycoolapp.config;

import com.luv2code.sprintboot.demo.mycoolapp.common.Coach;
import com.luv2code.sprintboot.demo.mycoolapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic") // aquatic is the bean id of this bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
