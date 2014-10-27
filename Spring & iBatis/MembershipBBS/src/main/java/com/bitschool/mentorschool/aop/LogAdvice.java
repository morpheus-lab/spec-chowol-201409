package com.bitschool.mentorschool.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	public void printLog() {
		logger.info("----------------------");
		logger.info("----------------------");
		logger.info("----------------------");
		logger.info("----------------------");
	}
	
	public Object printTime(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object target = pjp.getTarget();
		
		Object result = pjp.proceed();	// 대상이 실행
		
		long end = System.currentTimeMillis();
		
		logger.info(target + "time: " + (end - start));
		
		return result;
	}
	
}
