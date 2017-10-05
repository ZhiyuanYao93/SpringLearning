package com.zhiyuan.finance.banking_copy.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitoringService {
	Logger log = LoggerFactory.getLogger(MonitoringService.class);
	
	@Before("execution(* com..*Service.*(..))")
	public void monitorBeforeCalls(JoinPoint point) {
		log.info("Target:{}",point.getTarget().toString());
		log.info("Before advice invoked {}",point.getSignature().getName());
	}
	
	@After("execution(* com..*Service.*(..))")
	public void monitorAfterCalls(JoinPoint point) {
		log.info("Target:{}",point.getTarget().toString());
		log.info("After advice invoked {}",point.getSignature().getName());
	}
	
	
	@AfterThrowing(pointcut="execution(* com..*Service.*(..))",throwing="npe")
	public void monitorAfterThrowingCalls(JoinPoint point,NullPointerException npe) {
		log.info("Exception:{}", npe.getLocalizedMessage());
		log.info("Method {}",point.getSignature().getName());
	}
}
