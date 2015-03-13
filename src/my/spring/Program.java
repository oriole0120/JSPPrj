package my.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.dao.jdbc.JdbcNoticeDao;
import com.newlecture.jspprj.dao.mybatis.MyBatisMain;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*NoticeDao noticeDao  = new JdbcNoticeDao();
		NoticeView view = new NoticeView();
		view.setNoticeDao(noticeDao);*/
		
		MyBatisMain.start();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("my/spring/spring-context.xml");
 		
		/*NoticeView view = (NoticeView) context.getBean("view");
		view.print();*/
		ExamManager mng = (ExamManager) context.getBean("mng");
		mng.print();
	}
}






