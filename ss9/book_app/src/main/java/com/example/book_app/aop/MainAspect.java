package com.example.book_app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MainAspect {
    private long numberOfRequestToServer = 0;

    @Pointcut("within(com.example.book_app.controler.*)")
    public void countNumberOfRequestsToServer() {

    }
    @Before("countNumberOfRequestsToServer()")
    public void beforeCountNumberOfClientsHandler(JoinPoint joinPoint){
        System.out.println("the method used is: " + joinPoint.getSignature().getName());
        this.numberOfRequestToServer++;
        System.out.println("The number of request to service: "+this.numberOfRequestToServer);
    }
}
