<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="new" uri="http://www.newlecture.com/jsp/tags/control" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="/content/css/bind.css" rel="stylesheet" type="text/css" />
    <link href="/content/css/notice.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="modernizr.js"></script>
</head>

<body>
    <!-- 헤더부분 -->
	<%-- <jsp:include page="../inc/header.jsp"></jsp:include> --%>
	<tiles:insertAttribute name="header"/>

	<!-- visual 부분 -->
	<%-- <jsp:include page="inc/visual.jsp"></jsp:include> --%>
	<tiles:insertAttribute name="visual"/>

    <div id="body">
        <div class="content-wrapper clearfix">
        
            <!-- aside 부분 -->
			<%-- <jsp:include page="inc/aside.jsp"></jsp:include> --%>
			<tiles:insertAttribute name="aside"/>
            
            <!-- main 부분 -->
            <tiles:insertAttribute name="main"/>
            
            
        </div>
    </div>
			
	<!-- footer 부분 -->
	<tiles:insertAttribute name="footer"/>
    
</body>
</html>
