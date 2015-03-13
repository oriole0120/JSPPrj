package my.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

import com.newlecture.jspprj.dao.NoticeDao;

public class DaoLogHandler implements InvocationHandler {

	private NoticeDao noticeDao;
	
	public DaoLogHandler(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		// �տ��� ó���� ������ �ִٸ� ���
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		log.info("�Լ� ȣ�� ����!!");
		sw.start();
		
		Object result = method.invoke(noticeDao, args); // �־���, ���ڴ�ȣ��
		
		// �ڿ��� ó���� ������ �ִٸ� ���
		sw.stop();
		log.info("ȣ�� ��!!");
		log.info("[ȣ�� �޼ҵ�] : " + method.getName());
		log.info("[�ҿ� �ð�] : " + sw.getTotalTimeMillis());
		
		return result;
	}

}
