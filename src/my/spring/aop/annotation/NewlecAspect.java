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
		log.info("함수 호출 시작!!");
		sw.start();
		
		Object result = joinPoint.proceed(); // 주업무, 왕자님호출
		
		// 뒤에서 처리할 내용이 있다면 요기
		sw.stop();
		log.info("호출 끝!!");
		log.info("[호출 메소드] : " + joinPoint.getSignature().getName());
		log.info("[arguments] : " + Arrays.toString(joinPoint.getArgs()));
		log.info("[소요 시간] : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
	@Before("execution(* com.newlecture.jspprj.dao.NoticeDao.getSize(..))")
	public void authBefore(JoinPoint joinPoint) {
		Log log = LogFactory.getLog(this.getClass());
		log.info("[호출 메소드] : " + joinPoint.getSignature().getName());
		log.info("[arguments] : " + Arrays.toString(joinPoint.getArgs()));
		log.info("[Method 인증] 처리함");
	}
}





