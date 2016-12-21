package com.spring.rest.aspects;

import org.apache.log4j.Logger;
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

	@Pointcut("within(com.spring.rest.controller.UserController.*)")
	public void getAllAdvicesStart() {
		System.out.println("Start of method");
		logger.info("Start of method.");
	}

	/*@After("execution(public * com.spring.rest.controller.UserController.*)")
	public void getAllAdvicesEnd() {
		System.out.println("END of method");
		logger.info("End of method.");
	}*/
}
