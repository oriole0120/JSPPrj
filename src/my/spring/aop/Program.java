package my.spring.aop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.model.Notice;

public class Program {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("my/spring/aop/spring-context.xml");
 		
		NoticeDao noticeDao = (NoticeDao) context.getBean("noticeDao");
		List<Notice> list = noticeDao.getNotices(1, "", "TITLE");
		
		for(Notice n : list)
			System.out.printf("title : %s\n", n.getTitle());
		
		int size = noticeDao.getSize("", "TITLE");
		System.out.printf("size : %d\n", size);
	}
}
