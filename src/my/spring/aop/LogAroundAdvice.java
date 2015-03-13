package my.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		// �տ��� ó���� ������ �ִٸ� ���
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		log.info("�Լ� ȣ�� ����!!");
		sw.start();
		
		Object result = method.proceed(); // �־���, ���ڴ�ȣ��
		
		// �ڿ��� ó���� ������ �ִٸ� ���
		sw.stop();
		log.info("ȣ�� ��!!");
		log.info("[ȣ�� �޼ҵ�] : " + method.getMethod().getName());
		log.info("[�ҿ� �ð�] : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
}
