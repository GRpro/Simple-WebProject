<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.project.entities.Item" %>

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
		<h2 style="text-align: center;">List of items</h2>
		
		<!-- Print divs with java forEach loop example-->
		
		<% for(Item item : (List<Item>)request.getAttribute("items")) { %>
			<div class="itemItem">
				<div style="margin: 0 auto; background: black; color: white; text-align: center;">
					<p><%= item.getName() %></p>
				</div>
				<p><%= item.getPrice() %></p>
				<p>
				<a href="${pageContext.request.contextPath}/delete/item?itemId=<%= item.getId() %>">Delete item</a>
				</p>
			</div>
		<% } %>
		
		
		
		<!-- Print divs with simple java for loop example-->
		<%--
		<% List<Item> list = (List<Item>)request.getAttribute("items");
			for(int i = 0; i < list.size(); i++) { %>
			<div class="itemItem">
				<div style="margin: 0 auto; background: black; color: white; text-align: center;">
					<p><%= list.get(i).getName() %></p>
				</div>
				<p><%= list.get(i).getPrice() %></p>
				<p>
				<a href="${pageContext.request.contextPath}/delete/item?itemId=<%= list.get(i).getId() %>">Delete item</a>
				</p>
			</div>
		<% } %>
		--%>
		
		
		<!-- Print divs with Iterator example-->
		<%--
		<% Iterator<Item> it = ((List<Item>)request.getAttribute("items")).iterator();
			while(it.hasNext()) { Item item = it.next();%>
			<div class="itemItem">
				<div style="margin: 0 auto; background: black; color: white; text-align: center;">
					<p><%= item.getName() %></p>
				</div>
				<p><%= item.getPrice() %></p>
				<p>
				<a href="${pageContext.request.contextPath}/delete/item?itemId=<%= item.getId() %>">Delete item</a>
				</p>
			</div>
		<% } %>
		--%>
		
		
		<!-- Print divs with Tag lib forEach example-->
		<!-- 
		<c:forEach var="item" items="${items}">
			<div class="itemItem">
				<div style="margin: 0 auto; background: black; color: white; text-align: center;">
					<p>${item.name}</p>
				</div>
				<p>${item.price}</p>
				<p>
				<a href="${pageContext.request.contextPath}/delete/item?itemId=${item.id}">Delete item</a>
				</p>
			</div>
		</c:forEach>
		 -->
		 
		 
	</div>
</body>
</html>