package com.newlecture.jspprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/joinus/*")
public class JoinusController {
	
	@RequestMapping("login.htm")
	public String login()
	{
		return "/WEB-INF/views/joinus/login.jsp";
	}
}
