<%@page import="com.onlinebookstore.pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update book</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function validate()
{   
	var bid=document.getElementById("bookid").value;
	var bname=document.getElementById("bookname").value;
	var bprize=document.getElementById("bookprize").value;
	var bauthor=document.getElementById("bookauthor").value;
	var bquantity=document.getElementById("bookquantity").value;
	var bdesc=document.getElementById("bookdesc").value;
	if(bid=="")
	{
	document.getElementById("ebookid").innerHTML="please enter book id";
     return false;
     }
else
	{
	document.getElementById("ebookid").innerHTML="";
	}

	if(bname=="")
		{
		document.getElementById("ebookname").innerHTML="please enter book name";
	     return false;
	     }
	else
		{
		document.getElementById("ebookname").innerHTML="";
		}
	
	if(bprize=="")
		{
		document.getElementById("ebookprize").innerHTML="please enter book prize";
	     return false;
	     }
	else
		{
		document.getElementById("ebookprize").innerHTML="";
		}
	if(bauthor=="")
	{
	document.getElementById("ebookauthor").innerHTML="please enter book author";
     return false;
     }
else
	{
	document.getElementById("ebookauthor").innerHTML="";
	}
	if(bquantity=="")
	{
	document.getElementById("ebookquantity").innerHTML="please enter book quantity";
     return false;
     }
else
	{
	document.getElementById("ebookquantity").innerHTML="";
	}
	if(bdesc=="")
	{
	document.getElementById("ebookdesc").innerHTML="please enter  book Description";
     return false;
     }
else
	{
	document.getElementById("ebookdesc").innerHTML="";
	}
	return true;

	
	}</script>
</head>
<body>


<center>

<jsp:include page="header.jsp" ></jsp:include>
<form onsubmit="return validate()" action="BookServlet" method="post" >
<h1><u><b>Update Book Details</b></u></h1>
<%
	Book book=(Book)session.getAttribute("bookId");
%>
<table  border="2">
<tr>
<th>Enter Book id</th>
<th><input id="bookid" type="text" name="bookid" value="<%=book.getBookId() %>"></th>
<td> <span id="ebookid" style="color:red" ></span></td>
</tr>
<th>Enter Book Name</th>
<th><input id="bookname" type="text" name="bookname" value="<%=book.getBookName() %>"></th>
<td> <span id="ebookname" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Book Prize</th>
<th><input id="bookprize" type="text" name="bookprize"  value="<%=book.getPrize() %>"></th>
<td><span id="ebookprize" style="color:red"></span></td>
</tr>
<tr>
<th>Enter Book Author</th>
<th><input id="bookauthor" type="text" name="bookauthor" value="<%=book.getAuthorName()%>"></th>
<td><span id="ebookauthor" style="color:red"></span></td>
</tr>
<tr>
<th>Enter Book Publisher</th>
<th>
<select name="publisher" value="<%=book.getPublisher() %>"><option value="techmax">Techmax</option>
<option value="nirali">Nirali</option>
<option value="arihant">Arihant</option>
</select>
</th>
</tr>
<tr>
<th>Enter Book Category</th>
<th>
<select name="category" value="<%=book.getCategory()  %>"><option value="">Comedy</option>
<option value="motivational">Motivational</option>
<option value="devotional">Devotional</option>
<option value="educational">Educational</option>
</select>
</th>
</tr>
<tr>
<th>Enter Book Quantity</th>

<th><input id="bookquantity" type="text" name="bookquantity" value="<%=book.getQuantity() %>"></th>
<td><span id="ebookquantity" style="color:red"></span></td>

</th>
</tr>
<tr>
<th>Enter Book Description</th>
<th><input id="bookdesc" type="text" name="bookdesc"  value="<%=book.getBookDesc() %>"></th>
<td><span id="ebookdesc" style="color:red"></span></td>
</tr>
<!-- <tr>
<th>Book Image</th>
<th><input type="file" size=300 name="bookImage"></th>

</tr> -->
<tr>


<th><input type="reset"  value="Clear" name="" ></th>

<th><input type="submit" value="update" name="action"></th>
</tr>
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</center>

</body>
</html>