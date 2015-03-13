<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="new" uri="http://www.newlecture.com/jsp/tags/control" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
                        
                        <%--while(rs.next()) {--%>
                        
                        <c:forEach var="n" items="${list}">
                            <tr class="board-row">
                                <td class="board-cell num">${n.code}</td>
                                <td class="board-cell title"><a href="noticeDetail.htm?c=${n.code}">${n.title}</a></td>
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
                
                <security:authorize ifAnyGranted="ROLE_USER">
	                <div>
	                	<security:authentication property="name"/>님 환영합니다!! <br />
	                	${pageContext.request.userPrincipal.name}님 환영합니다!! <br />
	                	<security:authentication property="authorities" var="authorities"/>님 환영합니다!! <br />	                	
	                	<div>
	                		<c:forEach var="auth" items="${authorities}">
	                			${auth.authority},
	                		</c:forEach>
	                	</div>
	                </div>
	                <div>
	                	<a href="noticeReg.htm">글쓰기</a>
	                </div>
                </security:authorize>

                <div id="pager-container" class="space-top text-center">
                    <div class="pager">
                        <h3 class="hidden">페이저</h3>
                        <p class="pager-item"><img src="../images/btn-prev.png" alt="이전" /></p>
                        <ui:pager total="${total}" />
                        <p class="pager-item"><img src="../images/btn-next.png" alt="다음" /></p>
                    </div>
                </div>
            </main>