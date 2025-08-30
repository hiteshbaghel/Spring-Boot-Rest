package com.hitesh.Spring_Boot_Rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution (* com.hitesh.Spring_Boot_Rest.service.JobService.getJob(..)) && args(postId)")
    public Object ValidateAndUpdate(ProceedingJoinPoint jp , int postId) throws Throwable {

    if(postId < 0 ){
        LOGGER.info("Post id negative, Updating It");
        postId = -postId;
        LOGGER.info("New value" + postId);
    }
        Object obj = jp.proceed(new Object[]{postId});
        return obj;


    }



}
