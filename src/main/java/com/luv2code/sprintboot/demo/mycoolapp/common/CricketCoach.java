package com.luv2code.sprintboot.demo.mycoolapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // prototype scope
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "coming from Cricket coach";
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In post construct: " + getClass().getSimpleName());
    }

    // Prototype bean may not run pre destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In pre destroy: " + getClass().getSimpleName());
    }
}
