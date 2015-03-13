package com.newlecture.jspprj;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionContextListener implements HttpSessionListener, ServletRequestListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("세션 생성 : " + event.getSession().getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("세션 종료 : " + event.getSession().getId());

	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("요청 종료 Remote IP="
				+event.getServletRequest().getRemoteAddr());
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("요청 초기화 Remote IP="
				+event.getServletRequest().getRemoteAddr());
	}

}
