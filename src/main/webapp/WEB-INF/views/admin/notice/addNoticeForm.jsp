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
	<h1>공지글 작성</h1>
	<form action="${contextPath}/admin/notice/addNoticeForm.do" method="post">
		<table class="table table-bordered table-hover">
			<tr>
				<td>
		            <input type="text" class="form-control" name="noticeTitle"  id="noticeTitle" placeholder="제목" />
		        </td>
			</tr>
			<tr>
		        <td>
		        	<textarea style="resize:none" rows="30" cols="110" placeholder="글내용" id="noticeContent" name="noticeContent" ></textarea>
		        </td>
			</tr>
			<tr>
		        <td>
		        	<input type="submit" value="공지 추가하기" class="btn btn-primary btn-block">
		        </td>
	    	</tr>
		</table>
	</form>
</body>
</html>