package com.newlecture.jspprj.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.model.Notice;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	private NoticeDao noticeDao;
	
	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@RequestMapping("notice.htm")
	public String notice(String p, String f, String q, Model model){
		
		int npage = 1;
		String field = "TITLE";
		String query = "";

		/*String _page = request.getParameter("p");
		String _field = request.getParameter("f");
		String _query = request.getParameter("q");*/

		if(p != null && !p.equals(""))
			npage = Integer.parseInt(p);

		if(f != null && !f.equals(""))
			field = f;

		if(q != null && !q.equals(""))
			query = q;

		//NoticeDao noticeDao = new JdbcNoticeDao();
		/* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class); */

		List<Notice> list = noticeDao.getNotices(npage, query, field);
		
		/*ModelAndView mv = new ModelAndView("notice.jsp");
		
		mv.addObject("list", list);
		mv.addObject("total", noticeDao.getSize("", "TITLE"));*/
		model.addAttribute("list", list);
		model.addAttribute("total", noticeDao.getSize("", "TITLE"));
		
		return "customer.notice";
		/*return "/WEB-INF/views/customer/notice.jsp";*/
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String c, Model model){		

		//NoticeDao noticeDao = new JdbcNoticeDao();		
		Notice n = noticeDao.getNotice(c);

		model.addAttribute("n", n);
		
		return "customer.noticeDetail";
		/*return "/WEB-INF/views/customer/noticeDetail.jsp";*/
	}
	
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String c)
	{
		//NoticeDao noticeDao = new JdbcNoticeDao();
		noticeDao.delete(c);
		
		return "redirect:notice.htm"; //redirect
	}
	
	// 입력 폼을 제공하는 GET / 입력된 값을 처리하는 POST
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.GET) // GET/POST
	public String noticeEdit(String c, Model model)
	{
		// detail.htm 과 같은 로직을 넣으면 됨.
		
		//NoticeDao noticeDao = new JdbcNoticeDao();		
		Notice n = noticeDao.getNotice(c);

		model.addAttribute("n", n);
		
		return "customer.noticeEdit";
		/*return "/WEB-INF/views/customer/noticeEdit.jsp";*/
	}
	
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.POST)
	public String noticeEdit(Notice n)
	{
		// editProc 로직을 넣으면 됨.
		return "redirect:noticeDetail.htm";
	}
	
	@RequestMapping(value="noticeReg.htm", method=RequestMethod.GET) // GET/POST
	public String noticeReg()
	{
		return "customer.noticeReg";
		/*return "/WEB-INF/views/customer/noticeReg.jsp";*/
	}
	
	@RequestMapping(value="noticeReg.htm", method=RequestMethod.POST)
	public String noticeReg(Notice n, Principal principal, HttpServletRequest request)
	{
		System.out.println(n.getFile().getOriginalFilename());
		
		//n.getFile().getBytes();
		//n.getFile().getInputStream();
				
		String path = "content/customer/upload";
		path = request.getServletContext().getRealPath(path);
		
		String fname = n.getFile().getOriginalFilename();
		String fpath = path + "\\" + fname;
		
		FileOutputStream fos;
		try {
			
			fos = new FileOutputStream(fpath);
			fos.write(n.getFile().getBytes());		
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*UserDetails user = (UserDetails) SecurityContextHolder
									.getContext()
									.getAuthentication()
									.getPrincipal();
		
		String uid = user.getUsername();*/
		
		
		//noticeDao.setSrc(fname);
		n.setWriter(principal.getName());
		noticeDao.insert(n);
		
		// 파일 데이터
		// 문자열 데이터
		return "redirect:notice.htm";
	}
}

// Spring MVC 컨트롤러 작성
// File Upload 방법




