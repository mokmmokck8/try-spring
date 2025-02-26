package com.luv2code.sprintboot.demo.mycoolapp.rest;

import com.luv2code.sprintboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;
    private Coach mySwimCoach;

    // field injection (not recommended)
//    @Autowired
//    private Coach myCoach;

    // define a constructor for dependency injection (constructor injection, most recommended)
    // bean id is same name as the class, only the first character is lowercase
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach theAnotherCoach, @Qualifier("aquatic") Coach swimCoach) {
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
        mySwimCoach = swimCoach;
    }

    // setter injection
//    @Autowired
//    public void settingMyLikeCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/swimCoach")
    public String swimCoachDailyWorkout() {
        return mySwimCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public Boolean check() {
        return myCoach == anotherCoach;
    }
}
