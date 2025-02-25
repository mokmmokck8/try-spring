package com.luv2code.sprintboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "coming from Tennis Coach";
    }
}
