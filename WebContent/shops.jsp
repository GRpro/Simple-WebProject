<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of shops</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">

</head>
<body>

	<%@include file="common/header.jsp" %>
	
	<div class="container">
		<h2 style="text-align: center;">List of shops</h2>
		<c:forEach var="shop" items="${shops}">
			<div class="shopItem">
				<div style="margin: 0 auto; background: black; color: white; text-align: center;">
					<p>${shop.name}</p>
				</div>
				
				<p>${shop.address}</p>
				<p>
				<a href="shop/items?shopId=${shop.id}">See items</a>    
				<a href="add_item?shopId=${shop.id}">Add item</a>   
				<a href="delete/shop?shopId=${shop.id}">Delete shop</a>   
				</p> 

			</div>
		</c:forEach>
		
	</div>
</body>
</html>