package com.algochimbita.aopexample.aop;

import org.aspectj.lang.JoinPoint;

public class ResponseInterceptorAspect {
    public void auditResponses(JoinPoint joinPoint, Object returningValue) throws Throwable {
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("printing from interceptor");
        System.out.println(returningValue.getClass().toGenericString());
        System.out.println("end  interceptor");
    }
}
