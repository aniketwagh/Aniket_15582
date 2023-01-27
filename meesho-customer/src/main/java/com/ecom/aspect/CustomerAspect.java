package com.ecom.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.ecom.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.ecom.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.ecom.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method: " + method);
		// display the arguments to the method
		// get the arguments
		Object[] args = joinPoint.getArgs();
		// loop thru and display args
		for (Object tempArg : args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint joinPoint, Object theResult) {
		// display method we are returning from
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + method);
		// display data returned
		myLogger.info("=====>> result: " + theResult);
	}
}
