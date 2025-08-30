package com.hitesh.Spring_Boot_Rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    public static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution (* com.hitesh.Spring_Boot_Rest.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long Start = System.currentTimeMillis();

        Object obj = jp.proceed();
        long End = System.currentTimeMillis();
        LOGGER.info("Time Taken by method : " + jp.getSignature().getName() + " : " + (End - Start)+ "ms" );
        return obj ;

    }

}
