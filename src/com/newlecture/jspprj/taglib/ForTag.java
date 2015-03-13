package com.newlecture.jspprj.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForTag extends TagSupport {
	
	private String var=null;
	private int index=0;
	private int count = 5;
	private List items = null;
		
	public String getVar() {		
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
		
	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	@Override
	public int doStartTag() throws JspException {
		
		pageContext.setAttribute("i", index);
		
		if(var != null)
			pageContext.setAttribute(var, index);
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		pageContext.removeAttribute("i");
		
		if(var != null)
			pageContext.removeAttribute(var);
		
		return EVAL_PAGE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		index++;
		
		if(var != null)
			pageContext.setAttribute(var, index);
		
		if(index<count)
			return EVAL_BODY_AGAIN;
		
		return SKIP_BODY;
	}
}