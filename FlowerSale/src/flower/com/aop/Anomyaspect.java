package flower.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Anomyaspect {

	@Pointcut("execution(* flower.com.biz.impl.*.*(..))")  
	private void mypointcut(){}
	
	@Before("mypointcut()")
	public void mybefore(JoinPoint joinPoint){
		System.out.println("前置通知");
		System.out.println("对象" + joinPoint.getTarget());
	}
	@Around("mypointcut()")
	public Object myaround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("环绕开始");
		Object obj = proceedingJoinPoint.proceed() ;
		System.out.println("环绕结束");
		return obj ;
		
	}

	@AfterReturning(value="mypointcut()")
	public void myAfter(JoinPoint joinPoint) throws Exception {
		System.out.println("后置通知");
		System.out.println("对象是" + joinPoint.getTarget());
		System.out.println("方法是" + joinPoint.getSignature().getName());
	}
	
	
}
