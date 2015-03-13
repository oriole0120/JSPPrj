package com.newlecture.jspprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.model.Notice;

public class MyBNoticeDao implements NoticeDao {

	@Override
	public Notice getNotice(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice prevNotice(String curCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice nextNotice(String curCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getNotices(int page, String query, String field) {
		SqlSessionFactory factory = MyBatisMain.getSqlSessionFactory();//
		SqlSession sqlSession = factory.openSession(true);
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getNotices(page, query, field);
	}

	@Override
	public List<Notice> getNotices(int page, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getNotices(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSize(String query, String field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSize(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String lastCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
