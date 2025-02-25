package com.luv2code.sprintboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "coming from Cricket coach";
    }
}
