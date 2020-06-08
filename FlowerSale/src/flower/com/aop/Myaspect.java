package flower.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspect {
	
	//ǰ��֪ͨ
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("ǰ��֪ͨ��");
		System.out.println("����" +  joinPoint.getTarget());
		System.out.println("���õķ����ǣ�" + joinPoint.getSignature().getName());
	}
	//����֪ͨ
	public void myAfterReturning(JoinPoint joinPoint){
		System.out.println("����֪ͨ��");
		System.out.println("����" + joinPoint.getTarget());
		System.out.println("���÷�����---" + joinPoint.getSignature().getName() + "-----����");
	}
	//����֪ͨ
	public Object myAround(ProceedingJoinPoint peoceedingJoinPoint) throws Throwable{
		System.out.println("���ƿ�ʼ��");
		Object obj = peoceedingJoinPoint.proceed() ;
		System.out.println("���ƽ�����");
		return obj ;
	}
	
	//�쳣֪ͨ
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("�����쳣֪ͨ��" + e.getMessage());
	}
	//����֪ͨ
	public void myAfter(){
		System.out.println("���֪ͨ��");
	}
	
}
