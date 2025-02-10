package com.decipline.self.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution (* com.decipline.self.service.ActivityService.getAllReadingActivities(..)) ")
    public void log(){
        System.out.println("logged value");
    }
}

