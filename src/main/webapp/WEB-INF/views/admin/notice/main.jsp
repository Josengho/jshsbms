<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=2>
	  <tr>
	    <th>번호</th>
	    <th>제목</th>
	    <th>글쓴이</th>
	    <th>작성 날짜</th>
	    <th>조회수</th>
	  </tr>
	  <c:forEach items="${noticeList}" var="noticeList" varStatus="num">
		  <tr>
<<<<<<< HEAD
		    <td>${num.count}</td>
		    <td><a href="${contextPath}/admin/notice/selectNoticeOne.do?noticeId=${noticeList.noticeId}"><c:out value="${noticeList.noticeTitle}" /></a></td>
		    <td><c:out value="관리자" /></td>
		    <td><fmt:formatDate value="${noticeList.writeTime }" pattern="yyyy-MM-dd"/></td>
=======
		    <td><c:out value="${noticeList.noticeId}" /></td>
		    <td><c:out value="${noticeList.noticeTitle}" /></td>
		    <td><c:out value="${noticeList.noticeWriter}" /></td>
		    <td><fmt:formatDate value="${noticeList.SYSDATE }" pattern="yyyy-MM-dd"/></td>
		    <td><c:out value="${noticeList.noticeId}" /></td>
>>>>>>> parent of ce65827 (insertNotice)
		  </tr>
	  </c:forEach>

	</table>
</body>
</html>