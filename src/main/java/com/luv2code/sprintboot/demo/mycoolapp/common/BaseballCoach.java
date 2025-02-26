package com.luv2code.sprintboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "coming from Baseball coach";
    }
}
