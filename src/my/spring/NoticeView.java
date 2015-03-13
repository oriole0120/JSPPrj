package my.spring;

import java.util.List;

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.dao.jdbc.JdbcNoticeDao;
import com.newlecture.jspprj.model.Notice;

public class NoticeView {
	private NoticeDao noticeDao;
	
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public NoticeView() {
		//noticeDao = new JdbcNoticeDao();
	}
	
	public void print(){				
		List<Notice> list = noticeDao.getNotices(1, "", "TITLE");
		for(Notice n : list)
			System.out.printf("title : %s\n", n.getTitle());
	}
}
