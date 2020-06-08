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
		System.out.println("ǰ��֪ͨ");
		System.out.println("����" + joinPoint.getTarget());
	}
	@Around("mypointcut()")
	public Object myaround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("���ƿ�ʼ");
		Object obj = proceedingJoinPoint.proceed() ;
		System.out.println("���ƽ���");
		return obj ;
		
	}

	@AfterReturning(value="mypointcut()")
	public void myAfter(JoinPoint joinPoint) throws Exception {
		System.out.println("����֪ͨ");
		System.out.println("������" + joinPoint.getTarget());
		System.out.println("������" + joinPoint.getSignature().getName());
	}
	
	
}
