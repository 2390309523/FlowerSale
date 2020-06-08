package flower.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspect {
	
	//前置通知
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知：");
		System.out.println("对象：" +  joinPoint.getTarget());
		System.out.println("调用的方法是：" + joinPoint.getSignature().getName());
	}
	//后置通知
	public void myAfterReturning(JoinPoint joinPoint){
		System.out.println("后置通知：");
		System.out.println("对象：" + joinPoint.getTarget());
		System.out.println("调用方法：---" + joinPoint.getSignature().getName() + "-----结束");
	}
	//环绕通知
	public Object myAround(ProceedingJoinPoint peoceedingJoinPoint) throws Throwable{
		System.out.println("环绕开始：");
		Object obj = peoceedingJoinPoint.proceed() ;
		System.out.println("环绕结束：");
		return obj ;
	}
	
	//异常通知
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("存在异常通知：" + e.getMessage());
	}
	//最终通知
	public void myAfter(){
		System.out.println("最后通知：");
	}
	
}
