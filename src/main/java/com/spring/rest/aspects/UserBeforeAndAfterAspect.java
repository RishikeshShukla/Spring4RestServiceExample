package com.spring.rest.aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * This aspect is used to log the entry and exit of any method execution in controller 
 */
@Component
@Aspect
public class UserBeforeAndAfterAspect {

	private static Logger logger = Logger.getLogger(UserBeforeAndAfterAspect.class);

	@Pointcut("execution(* com.spring.rest.controller.UserController.*(..))")
	public void startPoint() {
	}
	
	@Pointcut("execution(* com.spring.rest.controller.UserController.*(..))")
	public void endPoint() {
	}

	// @Before("execution(* com.spring.rest.controller.UserController.*(..))")
	
	@Before(value = "startPoint()", argNames = "joinPoint")
	public void beforeCall(JoinPoint joinPoint) {
		//statement to log method name & parameter
		logger.info("Starting method name :" + joinPoint.getSignature().toShortString() + " | Args => "
				+ Arrays.asList(joinPoint.getArgs()));
		
		

		// logger.info("Start of method.");
	}

	//@After("execution(* com.spring.rest.controller.UserController.*(..))")
	
	@After(value = "endPoint()" , argNames = "joinPoint")
	public void afterCall(JoinPoint joinPoint ) {
		logger.info("Ending method name :" + joinPoint.getSignature().toShortString());
	}
}
