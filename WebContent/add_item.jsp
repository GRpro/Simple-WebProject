<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New item registration form</title>
</head>
<body>

	<%@include file="common/header.jsp" %>


	<div id="itemForm" style="width: 400px; margin: 0px auto;">
		<h2>Item registration form</h2>
		<form action="shop/items" method="post">
			<table>
				<tr>
					<td>Item name:</td><td><input type="text" name="itemName"></td>
				</tr>
				<tr>
					<td>Item price:</td><td><input type="text" name="itemPrice"></td>
				</tr>
				<tr>
					<td></td><td><input type="submit" value="Register"></td>
				</tr>
			</table>
			<input type="hidden" name="shopId" value="${shopId}">
		</form>
	</div>
</body>
</html>