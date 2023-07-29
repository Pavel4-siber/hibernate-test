package com.example.hibernatetest.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author Zhurenkov Pavel 29.07.2023
 */
@Aspect
@Component
public class ProfilingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilingAspect.class);
    private static long start;
    private static long end;

    @Pointcut("execution(* com.example.hibernatetest.controller.UserController.findAll())")
    public void anyFindUserMethod(){}

    @Before("anyFindUserMethod()")
    public void beforeAnyFindUserMethod() {
        LOGGER.info("===========BEFORE===============");
        start = System.nanoTime();
    }

    @After("anyFindUserMethod()")
    public void afterAnyFindUserMethod(){
        LOGGER.info("=========== AFTER===============");
        long end = System.nanoTime();
        LocalTime time = LocalTime.ofNanoOfDay(end - start);
        LOGGER.info("Execute time: " + time);
    }
}
