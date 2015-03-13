<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

app : 
<%if(application.getAttribute("sum") != null){ %>
<%=application.getAttribute("sum").toString()%>
<%} %><br />
session : 
<%if(session.getAttribute("sum") != null){ %>
<%=session.getAttribute("sum").toString()%>
<%} %><br />
cookie :
<%
Cookie[] cookies = request.getCookies();
String _sum = "";

if (cookies != null)		
	for (Cookie cookie : cookies)
		if("sum".equals(cookie.getName()))
			_sum = cookie.getValue();
%>
<%=_sum %><br />

</body>
</html>