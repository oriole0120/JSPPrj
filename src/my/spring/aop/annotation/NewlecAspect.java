package my.spring.aop.annotation;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

@Aspect
public class NewlecAspect {
	
	@Around("execution(* com.newlecture.jspprj.dao.NoticeDao.get*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		log.info("�Լ� ȣ�� ����!!");
		sw.start();
		
		Object result = joinPoint.proceed(); // �־���, ���ڴ�ȣ��
		
		// �ڿ��� ó���� ������ �ִٸ� ���
		sw.stop();
		log.info("ȣ�� ��!!");
		log.info("[ȣ�� �޼ҵ�] : " + joinPoint.getSignature().getName());
		log.info("[arguments] : " + Arrays.toString(joinPoint.getArgs()));
		log.info("[�ҿ� �ð�] : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
	@Before("execution(* com.newlecture.jspprj.dao.NoticeDao.getSize(..))")
	public void authBefore(JoinPoint joinPoint) {
		Log log = LogFactory.getLog(this.getClass());
		log.info("[ȣ�� �޼ҵ�] : " + joinPoint.getSignature().getName());
		log.info("[arguments] : " + Arrays.toString(joinPoint.getArgs()));
		log.info("[Method ����] ó����");
	}
}





