package com.example.testBoard.testStudy.class5.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class TimeTraceAop {

	@Around("execution(* com.example.testBoard..*(..))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("start : " + joinPoint.toString());
		try {
			return joinPoint.proceed();
		} finally {
			long finish = System.currentTimeMillis();
			long timeMs = finish - start;
			System.out.println("end : " + joinPoint.toString());
			System.out.println("ms : " + timeMs);
		}
	}
}
