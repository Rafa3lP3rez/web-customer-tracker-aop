package es.com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogginAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* es.com.springdemo.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same for service and dao
	@Pointcut("execution(* es.com.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* es.com.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forDAOPackage() || forServicePackage() ||  forControllerPackage()")
	public void forAppFlow() {}
	
	// add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint join) {
		
		// display method we are calling
		String method = join.getSignature().toShortString();
		myLogger.info("===========> in @Before: calling method: " + method);
		
		// get the args
		Object[] args = join.getArgs();
		
		for(Object temp : args) {
			myLogger.info("=============> argument: " + temp);
		}
		
	}
	
	// add @AfterReturning advice
	
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result")
	public void after(JoinPoint join, Object result) {
		
		String method = join.getSignature().toShortString();
		myLogger.info("===========> in @AfterReturning: calling method: " + method);
		
		myLogger.info("==========> result: " + result);
	}
	
}
