<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, th, td {
	    border: 1px solid black;
	    vertical-align : top;
	    border-left: none;
		border-right: none;
	}
	table {
	    border-collapse: collapse;
	}
</style>
</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "${contextPath}/admin/notice/updateNotice.do");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function (){
				
					var chk = confirm("정말 삭제하시겠습니까?");
					if (chk) {
						formObj.attr("action", "${contextPath}/admin/notice/deleteNoticeForm.do");
						formObj.attr("method", "post");
						formObj.submit();
					} else {
						location.href = "${contextPath}/admin/notice/main.do";
					}
				
			})
		})
	</script>
<body>
	<h1><c:out value="${noticeDto.noticeTitle}" /></h1>
	<div style="float:left;">관리자</div>
	<div style="float:right;"><fmt:formatDate value="${noticeDto.writeTime }" pattern="yyyy-MM-dd"/></div>
	<br>
	<section id="container">
		<form name="readForm" role="form" method="post">
			<input type="hidden" id="noticeId" name="noticeId" value="${noticeDto.noticeId}" />
		</form>
		<table border="1">
			<tr>
				<td width="800" height="500"><c:out value="${noticeDto.noticeContent}" /></td>	
			</tr>
		</table>
		<button type="submit" class="update_btn">수정</button>
		<button type="submit" class="delete_btn">삭제</button>
	</section>
</body>
</html>