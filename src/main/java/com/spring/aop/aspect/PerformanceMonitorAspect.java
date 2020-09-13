package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceMonitorAspect {
 
    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }
 

    @Pointcut("execution(public * (@org.springframework.stereotype.Service com.spring.aop..*).*(..))")
    public void serviceAnnotation() {
    }
 

    @Pointcut("execution(public * (@org.springframework.stereotype.Repository com.spring.aop..*).*(..))")
    public void repositoryAnnotation() {
    }
 
    @Pointcut("serviceAnnotation() || repositoryAnnotation()")
    public void performanceMonitor() {
    }
 
    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.spring.aop.aspect.PerformanceMonitorAspect.performanceMonitor()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }
}
