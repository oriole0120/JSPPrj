package com.newlecture.jspprj;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener, ServletContextAttributeListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.out.println("���ø����̼� �ʱ�ȭ��");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.out.println("���ø����̼� �����");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("���ø����̼� �Ӽ� "+event.getName()+"�� �� "+event.getValue()+"���� �߰���");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("���ø����̼� �Ӽ� "+event.getName()+"�� ���ŵ�");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("���ø����̼� �Ӽ� "+event.getName()+"�� �����");
	}

}
