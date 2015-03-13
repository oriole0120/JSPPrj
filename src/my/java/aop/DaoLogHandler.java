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
		
		// 앞에서 처리할 내용이 있다면 요기
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		log.info("함수 호출 시작!!");
		sw.start();
		
		Object result = method.invoke(noticeDao, args); // 주업무, 왕자님호출
		
		// 뒤에서 처리할 내용이 있다면 요기
		sw.stop();
		log.info("호출 끝!!");
		log.info("[호출 메소드] : " + method.getName());
		log.info("[소요 시간] : " + sw.getTotalTimeMillis());
		
		return result;
	}

}
