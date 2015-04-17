<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New shop registration form</title>
</head>
<body>

	<%@include file="common/header.jsp" %>


	<div id="shopForm" style="width: 400px; margin: 0px auto;">
		<h2>Shop registration form</h2>
		<form action="shops" method="post">
			<table>
				<tr>
					<td>Shop name:</td><td><input type="text" name="shopName"></td>
				</tr>
				<tr>
					<td>Shop address:</td><td><input type="text" name="shopAddress"></td>
				</tr>
				<tr>
					<td></td><td><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>