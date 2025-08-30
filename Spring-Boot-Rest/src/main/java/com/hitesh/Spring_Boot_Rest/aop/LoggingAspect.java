package com.hitesh.Spring_Boot_Rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution (* com.hitesh.Spring_Boot_Rest.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution (* com.hitesh.Spring_Boot_Rest.service.JobService.getJob(..)) || execution (* com.hitesh.Spring_Boot_Rest.service.JobService.updateJob(..))")
    public void logMethodExecutedl(JoinPoint jp) {
        LOGGER.info("Method Called Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution (* com.hitesh.Spring_Boot_Rest.service.JobService.getJob(..)) || execution (* com.hitesh.Spring_Boot_Rest.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method has some issue " + jp.getSignature().getName());
    }

    @AfterReturning("execution (* com.hitesh.Spring_Boot_Rest.service.JobService.getJob(..)) || execution (* com.hitesh.Spring_Boot_Rest.service.JobService.updateJob(..))")
    public void logMethodExecutedlSuccess(JoinPoint jp) {
        LOGGER.info("Method Called Executed Successfully " + jp.getSignature().getName());
    }

}
