package com.trendingtwig.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	@Pointcut("execution (* com.trendingtwig.*.*.*(..))")
	public void allTheMethodsInLayers() {
	}

	@Before(value = "allTheMethodsInLayers()")
	public void doSomething(JoinPoint joinPoint) {
		System.out.println(
				">> " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	@After(value = "allTheMethodsInLayers()")
	public void doAnotherThing(JoinPoint joinPoint) {
		System.out.println(
				"<< " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}
}
