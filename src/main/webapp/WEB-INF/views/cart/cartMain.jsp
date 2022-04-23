<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set value="${cartMap.cartList}" var="cartlist"/>
<c:set value="${cartMap.goodsList}" var="goodsList"/>
<c:set value="${cartMap.imageFileList}" var="imageFileList"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$().ready(function(){
		$("#delete").click(function() {
			var goodsId = $('#goodsId').val();
			console.log(goodsId);
			$.ajax({ 
				url: "${contextPath}/cart/deleteCartGoods.do",
				data: {id:goodsId},
				type: "POST",
				success : function(data) { 
					alert(data);
				}
			});
		});
	});
</script>
</head>
<body>

<div class="container">
		<form id="form" method="post" action="${contextPath}/order/orderEachGoods.do" onSubmit="bt_order_each_goods('${goodsList}')">
		<div class="row qnas" style="text-align: center;">
			<h1 class="page-header">장바구니</h1>
			<table class="table table-hover" style=" margin: auto; border-bottom: 1px solid #D5D5D5;">
				<thead>
					<tr>
						<th style="text-align: center;">상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>상품정보</th>
						<th>상품제거</th>
					</tr>
				</thead>
				<tbody>
					<c:choose><c:when test="${goodsList != null}">
					<c:forEach items="${goodsList}" var="vo" varStatus="status">
						<tr style="text-align: center;">
							<td><input type="hidden" name="goodsId" id="goodsId" value="${vo.goodsId}"/>${vo.goodsTitle}</td>
							<td><fmt:formatNumber type="number" value="${vo.goodsPrice}"/>&nbsp;원</td>
							<td>
								<select id="orderGoodsQty">
									<c:forEach var="count" begin="1" end="5">
									<option>${count}</option>
									</c:forEach>
								</select>
							</td>
							<td></td>
							<td><button id="delete" class="btn-delete"  type="button">삭제</button></td>
						</tr>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="5"><h3>장바구니에 내역이 없습니다.</h3></td></tr>
					</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		
		<div class="row" style="text-align: center; margin: 80px 0;">

			<input type="submit" value="주문하기">
			<button class="btn btn-default">쇼핑을 계속하기</button>
		</div>
		</form>

	</div>
</body>
</html>
<input type="hidden" name="isLogOn" id="isLogOn" value="${isLogOn}"/>