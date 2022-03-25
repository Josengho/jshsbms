<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지 게시판</h1>
	<table class="table table-bordered table-hover">
	  <tr>
	    <th>번호</th>
	    <th width="60%">제목</th>
	    <th>글쓴이</th>
	    <th>작성 날짜</th>
	  </tr>
	  <c:forEach items="${noticeList}" var="noticeList" varStatus="num">
		  <tr>
		    <td>${num.count}</td>
		    <td><a href="${contextPath}/admin/notice/selectNoticeOne.do?noticeId=${noticeList.noticeId}"><c:out value="${noticeList.noticeTitle}" /></a></td>
		    <td><c:out value="관리자" /></td>
		    <td><fmt:formatDate value="${noticeList.writeTime }" pattern="yyyy-MM-dd"/></td>
		  </tr>
	  </c:forEach>
	</table>
	<button type="button" onclick="location.href='${contextPath}/admin/notice/addNoticeForm.do'">추가하기</button>
</body>
</html>