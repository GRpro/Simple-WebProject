<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
   /* Begin Navigation Bar Styling */
   #nav {
  border: 1px solid black;
  width: 100%;
  float: left;
  margin: 0 0 3em 0;
  padding: 0;
  list-style: none;
  background-color: black;
}
   #nav li {
      float: left; }
   #nav li a {
      display: block;
      padding: 8px 15px;
      text-decoration: none;
      font-weight: bold;
      color: #069;
      border-right: 1px solid #ccc; }
   #nav li a:hover {
      color: #c00;
      background-color: white; }
   /* End navigation bar styling. */
   
   /* This is just styling for this specific page. */
   	body {
  	background-color: white;
  	font: small/1.3 Arial, Helvetica, sans-serif;
	}
   #wrap {
      width: 750px;
      margin: 0 auto;
      background-color: #fff; }
   #content {
      padding: 0 50px 50px; }
</style>

	<ul id="nav">
      <li><a href="${pageContext.request.contextPath}/shops">Shops</a></li>
      <li><a href="${pageContext.request.contextPath}/add_shop.jsp">New shop</a></li>
   </ul>   