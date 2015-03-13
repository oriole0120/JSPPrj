package com.newlecture.jspprj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.dao.jdbc.JdbcNoticeDao;
import com.newlecture.jspprj.model.Notice;

public class NoticeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int npage = 1;
		String field = "TITLE";
		String query = "";

		String _page = request.getParameter("p");
		String _field = request.getParameter("f");
		String _query = request.getParameter("q");

		if(_page != null && !_page.equals(""))
			npage = Integer.parseInt(_page);

		if(_field != null && !_field.equals(""))
			field = _field;

		if(_query != null && !_query.equals(""))
			query = _query;

		NoticeDao noticeDao = new JdbcNoticeDao();
		/* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class); */

		List<Notice> list = noticeDao.getNotices(npage, query, field);

		ModelAndView mv = new ModelAndView("notice.jsp");
		
		mv.addObject("list", list);
		mv.addObject("total", noticeDao.getSize("", "TITLE"));
		
		return mv;
	}

}
