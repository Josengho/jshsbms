<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script>
	function searchId(memberName, email1, email2){

			$.ajax({
				type : "post",
				url : "${contextPath}/member/findId.do",
				contentType : "application/json; charset=utf-8",
				data: JSON.stringify({	"memberName" : memberName,
										"email1" : email1,
										"email2" : email2
				}),
				success : function(data) {
					if(data == "" || data == null){
						alert("등록되지 않은 사용자 입니다.");
					} else {
						alert("ID는 " + data + "입니다");
					}
				},
				error:function(){
			        console.log("error");
			    }

			});
	}
	$().ready(function() {
		$("#select_email").change(function(){
			$("#email2").val($("#select_email option:selected").val());
		});
	});
</script>
</head>
<body>
	<h1>아이디 찾기</h1>
	<br>
	<form action="${contextPath}/member/findId.do" method="post">
		<table class="table table-hover">
			<colgroup>
				<col width="20%">
				<col width="60%">
			</colgroup>
			<tr>
				<td align="center"><label for="memberName">이름</label></td>
				<td><input class="form-control" id="memberName" name="memberName" type="text" placeholder="이름을 입력하세요." /></td>
			</tr>
			<tr align="center">
				<td><label for="memberEmail">이메일</label></td>
	        <td>
	        	<input class="form-control"  size="10px"  type="text" id="email1" name="email1" style="display:inline; width:150px; padding:0"> @ 
					<input class="form-control"  size="10px"  type="text" id="email2" name="email2" style="display:inline; width:150px; padding:0">
					<select class="form-control" id="select_email" name="email3" style="display:inline; width:150px; padding:0">
						 <option value="none" selected>직접입력</option>
						 <option value="gmail.com">gmail.com</option>
						 <option value="naver.com">naver.com</option>
						 <option value="daum.net">daum.net</option>
						 <option value="nate.com">nate.com</option>
					</select>
	        </td>
			</tr>
			<tr >
				<td colspan="2" align="right"><input type="button" class="btn btn-primary btn-sm" value="아이디 찾기" onClick="searchId(memberName.value,email1.value,email2.value)" /></td>
			</tr>
		</table>
		<p align="center">
   			<img src="${contextPath }/resources/image/bms_logo1.PNG" width=300>
   		</p>
	</form>
</body>
</html>