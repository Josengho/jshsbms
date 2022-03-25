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
	<h1>공지글 수정</h1>
	<section id="container">
		<form name="updateNoticeForm" role="form" method="post" action="${contextPath}/admin/notice/updateNoticeForm.do">
		<input type="hidden" name="noticeId" value="${noticeDto.noticeId}" readonly="readonly"/>
			<table class="table table-bordered table-hover">
				<tr>
					<td>
			            <label for="noticeTitle"></label><input type="text" class="form-control" name="noticeTitle"  id="noticeTitle" value="${noticeDto.noticeTitle}"/>
			        </td>
				</tr>
				<tr>
			        <td>
			        	<label for="noticeContent"></label><textarea style="resize:none" rows="30" cols="110" id="noticeContent" name="noticeContent"><c:out value="${noticeDto.noticeContent }"/></textarea>
			        </td>
				</tr>
				<tr>
			        <td>
			        	<button type="submit" class="update_btn">저장</button>
			        </td>
		    	</tr>
			</table>
		</form>
	</section>
</body>
</html>