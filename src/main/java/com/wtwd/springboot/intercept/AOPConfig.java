package com.wtwd.springboot.intercept;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author MR.ZHANG
 * @create 2018-08-03 14:48
 */
@Configuration
@Aspect
public class AOPConfig {
    @Around("@within(org.springframework.stereotype.Controller) ")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{
        try {
            Object[] args = pjp.getArgs();
            System.out.println(Arrays.asList(args));
            Object proceed = pjp.proceed();
            System.out.println("return : " + proceed);
            return proceed;
        } catch (Throwable throwable) {
            throw(throwable);
        }
    }
}
