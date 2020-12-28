<%@page import="com.onlinebookstore.pojo.Cart"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartList</title>
</head>
<body>
 
<center>
<jsp:include page="header.jsp"></jsp:include>
<form action="MyCartServlet" method="post">
<table border="1">
<tr>
<th>Cart id</th>
<th>Book name </th>
<th>Book price</th>
<th>Book quantity</th>
<th>Action</th>
</tr>

<%-- <%
List<Cart>myCart=(List<Cart>)session.getAttribute("userCart");
if(myCart!=null && myCart.size()>0)
{
	for(int i=0;i<myCart.size();i++)
	{
		Cart c=(Cart)myCart.get(i);
	

%> --%>
<c:forEach var="f" items="${userCart}">
<tr>
<%-- <td><%=c.getCartId() %></td>
<td><%=c.getBookName()%></td>
 --%>
 <td>${f.cartId}</td>
 <td>${f.bookName}</td>
 
<td><input type="text" readonly name="price" value="${f.prize}" ></td>
<td><input type="number" min="1" name="bookQuantity" value="${f.bookQuantity}" ></td>
<td><a href="MyCartServlet?action=delete&cartId=${f.cartId}">Delete</a></td>

</tr>
</c:forEach>
<%-- <%}} %> --%>
</table>
<%-- <%
if(!myCart.isEmpty()){%>



<%}%> --%>
<c:if test="${!userCart.isEmpty()}">
<input type="submit" value="placeorder">
</c:if>
</form>
<jsp:include page="footer.jsp" ></jsp:include>
</center>
</body>
</html>