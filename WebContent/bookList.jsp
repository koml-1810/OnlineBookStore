<%@page import="com.onlinebookstore.pojo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%-- <%String admin=(String)session.getAttribute("adminId");
String customer=(String)session.getAttribute("customerId");
%> --%>

<jsp:include page="header.jsp" ></jsp:include>
<table border=1>
<tr>
<th>Book Id</th>
<th>Book Name</th>
<th>Price</th>
<th>Author</th>
<th>Publisher</th>
<th>Category</th>
<th>Book Description</th>
<th>Book Quantity</th>
<th colspan="2">Action</th>
</tr>
<%-- <%
List<Book22263>bookList=(List<Book22263>)session.getAttribute("book");
 if(bookList!=null && bookList.size()>0)
 {
	 for(int i=0;i<bookList.size();i++)
	 {
		 Book22263 book=(Book22263)bookList.get(i);
		 
%> --%>
 <c:forEach var="f" items="${book}">
<tr>
<%-- <td><%=book.getBookId() %></td>
<td><%=book.getBookName() %></td>
<td><%=book.getPrize() %></td>
<td><%=book.getAuthorName() %></td>
<td><%=book.getPublisher() %></td>

<td><%=book.getCategory() %></td>
<td><%=book.getBookDesc() %></td>
<td><%=book.getQuantity() %></td>
 --%>

<td>${f.bookId} </td>
<td>${f.bookName} </td>
<td>${f.prize} </td>
<td>${f.authorName} </td>
<td>${f.publisher} </td>

<td>${f.category} </td>
<td>${f.bookDesc} </td>
<td>${f.quantity} </td>
<%-- <% if(admin!=null && customer==null){%> --%>
<c:if test="${adminId!=null && customerId==null}">
<td><a href="BookServlet?action=delete&id=${f.bookId}">Delete</a></td>
<td><a href="BookServlet?action=edit&id=${f.bookId}">Edit</a></td>
</c:if>
<%-- <%} 
 else if(admin==null && customer!=null){%> --%>
 <c:if test="${adminId!=null && customerId==null}">
<td><a href="BookServlet?action=addtocart&id=${f.bookId}">Add to Cart</a></td>
</c:if>
</tr>


<%-- <%}}}%> --%>
</c:forEach>
</table>




<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>