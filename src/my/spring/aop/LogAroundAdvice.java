package my.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		// 앞에서 처리할 내용이 있다면 요기
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		log.info("함수 호출 시작!!");
		sw.start();
		
		Object result = method.proceed(); // 주업무, 왕자님호출
		
		// 뒤에서 처리할 내용이 있다면 요기
		sw.stop();
		log.info("호출 끝!!");
		log.info("[호출 메소드] : " + method.getMethod().getName());
		log.info("[소요 시간] : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
}
