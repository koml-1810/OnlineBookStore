<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<%-- <%
String success=(String)session.getAttribute("success");
out.print(success);
%> --%>
${success}
<%response.sendRedirect("BookServlet"); %>


</body>
</html> 