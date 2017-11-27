package com.nozama.nozama.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Around("execution(* com.nozama.nozama.controller.*Controller.*(..))")
//    public void controllerLog(ProceedingJoinPoint pjp) throws Throwable {
//        logger.info("    Entering " + pjp.getSignature());
//
//        pjp.proceed();
//
//        logger.info("    Exiting " + pjp.getSignature());
//    }

    @Before("execution(* com.nozama.nozama.*.*.*(..))")
    public void beforeLog(JoinPoint jp){
        logger.info("    Entering " + jp.getTarget().getClass());
    }
    @After("execution(* com.nozama.nozama.*.*.*(..))")
    public void afterLog(JoinPoint jp){
        logger.info("    Exiting " + jp.getTarget().getClass());
    }

    @AfterThrowing(pointcut="execution(* com.nozama.nozama.*.*.*(..))", throwing="ex")
    public void exceptionAspect(JoinPoint jp, Exception ex) {
        logger.error("    Exception: " + jp.getTarget().getClass() + "  Message: " + ex.getMessage());
    }
}
