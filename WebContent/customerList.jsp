<%@page import="com.onlinebookstore.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
<jsp:include page="header.jsp" ></jsp:include>
<table border=1>
<tr>
<th>Customer Id</th>
<th>Customer name</th>
<th>Mobile Number</th>
<th>Address</th>
<th>Email Id</th>
<th>Password</th>
<th colspan="2">Action</th>
</tr>
<%-- <%
List<Customer>customerList=(List<Customer>)session.getAttribute("customer");
if(customerList!=null && customerList.size()> 0)
{
	for(int i=0;i<customerList.size();i++)
	{
		Customer customer=(Customer)customerList.get(i);
				
	

%> --%>
<c:forEach var="f" items="${customer}">
<tr>
<%-- <td><%=customer.getCustomerId() %></td>
<td><%=customer.getCustomerName() %></td>
<td><%=customer.getMobNo() %></td>
<td><%=customer.getAddress() %></td>
<td><%=customer.getEmailID() %></td>
<td><%=customer.getPassword() %></td>
 --%>

<td>${f.customerId}</td>
<td>${f.customerName}</td>
<td>${f.mobNo}</td>
<td>${f.address}</td>
<td>${f.emailID}</td>
<td>${f.password}</td>
<td><a href="CustomerServlet?action=delete&id=${f.customerId}">Delete</a></td>
<td><a href="CustomerServlet?action=edit&id=${f.customerId}">Edit</a></td>
</tr>
</c:forEach>
<%-- <%}} %> --%>





</table>
<jsp:include page="footer.jsp"></jsp:include>
</center>
</body>
</html>