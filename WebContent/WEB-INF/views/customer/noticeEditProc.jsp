<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Notice notice = new Notice();
	notice.setCode(code);
	notice.setTitle(title);	
	notice.setContent(content);
	

	NoticeDao noticeDao = new JdbcNoticeDao();
	noticeDao.update(notice);

	// 목록 페이지로 이동 

	String url = String.format("noticeDetail.jsp?c=%s", notice.getCode());
	response.sendRedirect(url);
	
%>