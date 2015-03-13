package my.java.aop;

import java.lang.reflect.Proxy;
import java.util.List;

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.dao.jdbc.JdbcNoticeDao;
import com.newlecture.jspprj.model.Notice;

public class Program {

	public static void main(String[] args) {
		NoticeDao noticeDao = new JdbcNoticeDao();
		
		NoticeDao noticeProxy = (NoticeDao) Proxy.newProxyInstance(
									noticeDao.getClass().getClassLoader(), 
									noticeDao.getClass().getInterfaces(), 
									new DaoLogHandler(noticeDao));
		
		List<Notice> list = noticeProxy.getNotices(1, "", "TITLE");
				
		for(Notice n : list)
			System.out.printf("title : %s\n", n.getTitle());
		
		int size = noticeProxy.getSize("", "TITLE");
		System.out.println(size);
	}
}





