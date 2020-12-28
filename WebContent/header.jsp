<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<%---<%String admin=(String)session.getAttribute("adminId");
String customer=(String)session.getAttribute("customerId");
--%>
 

<div id="templatemo_menu">
    	<ul>
    	<%--<%if(admin==null && customer==null)
    	{--%>
    	<c:if test="${adminId==null && customerId==null}">
    	<li><a href="Home.jsp" class="current">Home</a></li>
            
                  <li><a href="search.jsp">Search</a></li>
            <li><a href="Login.jsp">Login</a></li> 
            <li><a href="addCustomer.jsp">Register</a></li>
              <li><a href="contactUs.jsp">Contact</a></li> 
            <li><a href="aboutUs.jsp">About us</a></li>
            
            </c:if>
    	<%--<%}  
    	else if(admin!=null && customer==null){--%>
    		
    		<c:if test="${adminId!=null && customerId==null}">
     <li><a href="Home.jsp" class="current">Home</a></li>
             <li><a href="addBook.jsp">Add Book</a></li> 
              <li><a href="search.jsp">Search</a></li>
         
            <li><a href="CustomerServlet">View Customers</a></li>   
            <li><a href="contactUs.jsp">Contact</a></li> 
            <li><a href="aboutUs.jsp">About us</a></li>
            <li><a href="updatePassword.jsp">Change Password</a></li>
              <li><a href="LoginServlet">Logout</a></li>
             
             </c:if>
    	<%--<%}
    	else if(admin==null && customer!=null){--%>
		<c:if test="${adminId==null && customerId!=null}">
    	<li><a href="Home.jsp" class="current">Home</a></li>
    	            
    	            <!-- <li><a href="BookServlet">View Books</a></li>             -->
    	          <li><a href="search.jsp">Search</a></li>   
    	            <li><a href="contactUs.jsp">Contact</a></li> 
    	            <li><a href="aboutUs.jsp">About us</a></li>
    	            <li><a href="MyCartServlet">My Cart</a></li>
    	            <li><a href="LoginServlet">Logout</a></li>
    	         
    	            </c:if>
    	<%--} --%>
   

            
    	</ul>
    </div> <!-- end of menu -->
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over $80
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Suspen disse</li>
                <li>Maece nas metus</li>
                <li>In sed risus ac feli</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->

</body>
</html>