<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.newlecture.jspprj.dao.mybatis.MyBatisMain"%>
<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="new" uri="http://www.newlecture.com/jsp/tags/control" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%
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

pageContext.setAttribute("list", list);
pageContext.setAttribute("total", noticeDao.getSize("", "TITLE"));
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="css/bind.css" rel="stylesheet" type="text/css" />
    <link href="css/notice.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="modernizr.js"></script>
</head>
<body>
    <!-- 헤더부분 -->
	<jsp:include page="../inc/header.jsp"></jsp:include>

	<!-- visual 부분 -->
	<jsp:include page="inc/visual.jsp"></jsp:include>


    <div id="body">
        <div class="content-wrapper clearfix">            
            <!-- aside 부분 -->
			<jsp:include page="inc/aside.jsp"></jsp:include>
            
            <main id="main">                
                <h2 id="main-title">공지사항</h2>
                            
                <div id="breadcrumb">
                    <h3 class="hidden">현재경로</h3>
                    <ol>
                        <li class="breadcrumb-item">home</li>
                        <li class="breadcrumb-item">고객센터</li>
                        <li class="breadcrumb-item">공지사항</li>
                    </ol>
                </div>
                
                <div id="notice-search-container" class="space-top-l text-right">
                    <div id="search-form">
                        <h3 class="hidden">공지사항 검색 폼</h3>
                        <form action="notice.jsp" method="get">
                            <fieldset>
                                <legend class="hidden">공지사항 검색 필드</legend>
                                <label for="field" class="hidden">검색분류</label>
                                <select class="search-field" name="f">
                                    <option ${param.f == 'TITLE'? 'selected' : ''} value="TITLE">제목</option>
                                    <option ${param.f == 'WRITER'? 'selected' : ''} value="WRITER">작성자</option>
                                    <option ${param.f == 'CONTENT'? 'selected' : ''} value="CONTENT">내용</option>
                                </select>
                                <label for="query" class="hidden">검색어필드</label>
                                <input class="search-input" type="text" name="q"  value="${param.q}"/>
                                <input class="search-button" type="submit" value="검색" />
                            </fieldset>
                        </form>
                    </div>
                </div>

                <div class="board space-top">
                    <h3 class="hidden">공지사항 목록</h3>
                    
                    <table class="board-table">
                        <thead>
                            <tr class="board-row">
                                <th class="board-cell board-cell-hd num">번호</th>
                                <th class="board-cell board-cell-hd title title-hd">제목</th>
                                <th class="board-cell board-cell-hd writer">작성자</th>
                                <th class="board-cell board-cell-hd date">작성일</th>
                                <th class="board-cell board-cell-hd hit">조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                        <%-- <%while(rs.next()) {%> --%>
                        
                        <c:forEach var="n" items="${list}">
                            <tr class="board-row">
                                <td class="board-cell num">${n.code}</td>
                                <td class="board-cell title"><a href="noticeDetail.jsp?c=${n.code}">${n.title}</a></td>
                                <td class="board-cell writer">${n.writer}</td>
                                <td class="board-cell date">${n.regdate}</td>
                                <td class="board-cell hit">${n.hit}</td>
                            </tr>
                         </c:forEach>
                         
                        </tbody>
                    </table>
                </div>

                <div id="indexer-container" class=" space-top text-right">
                    <div id="indexer">
                        <h3 class="hidden">현재 페이지</h3>
                        <p><span class="text-highlight" id="s1">1</span>/2 page</p>
                    </div>
                </div>

                <div id="pager-container" class="space-top text-center">
                    <div class="pager">
                        <h3 class="hidden">페이저</h3>
                        <p class="pager-item"><img src="../images/btn-prev.png" alt="이전" /></p>
                        <ui:pager total="${total}" />
                        <p class="pager-item"><img src="../images/btn-next.png" alt="다음" /></p>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <footer id="footer">
        <div class="content-wrapper clearfix">
            <div id="logo-footer-container">
                <h2 id="logo-footer"><img src="../images/logo-footer.png" alt="회사정보" /></h2>
            </div>
            <div id="company-info-container">
                <div id="company-info">
                    <h3 class="hidden">소유자정보</h3>
                    <dl class="clearfix">
                        <dt class="company-info-item item-title item-newline">주소</dt>
                        <dd class="company-info-item item-data">서울특별시 동대문구</dd>
                        <dt class="company-info-item item-title item-newline">관리자메일</dt>
                        <dd class="company-info-item item-data">admin@newlecture.com</dd>
                        <dt class="company-info-item item-title">전화번호</dt>
                        <dd class="company-info-item item-data">02-111-0000</dd>
                        <dt class="company-info-item item-title item-newline">상호</dt>
                        <dd class="company-info-item item-data">뉴렉처</dd>
                    </dl>
                </div>

                <div id="copyright">
                    <h3 class="hidden">저작권정보</h3>
                    <p>Copyright@newlecture.com 2013-2015 ....</p>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>
