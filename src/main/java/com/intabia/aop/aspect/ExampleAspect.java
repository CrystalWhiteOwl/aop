package com.intabia.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExampleAspect {

    @Pointcut("@annotation(com.intabia.aop.annotation.LogExecutionTime)")
    public void logExecutionTimePointcut() {} // NOSONAR: pointcut

    @Around("logExecutionTimePointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }

    @Pointcut("execution(public void *.method2())")
    public void method2Pointcut() {} // NOSONAR: pointcut

    @Before("method2Pointcut()")
    public void logBefore() {
        log.info("This should appear before public void method2()");
    }

    @After("method2Pointcut() && logExecutionTimePointcut()")
    public void logAfter() {
        log.info("This should appear after public void method2()");
    }
}
