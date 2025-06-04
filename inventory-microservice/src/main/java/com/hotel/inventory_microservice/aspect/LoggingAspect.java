package com.hotel.inventory_microservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.hotel.inventory_microservice.controller..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        logger.info("Controller method invoked: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.hotel.inventory_microservice.controller..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method Returned: " + joinPoint.getSignature().getName() + " | Response: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.hotel.inventory_microservice.controller..*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.error("Exception in: " + joinPoint.getSignature().getName(), ex);
    }
}
