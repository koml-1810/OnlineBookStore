<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add book</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function validate()
{
	var bname=document.getElementById("bookname").value;
	var bprize=document.getElementById("bookprize").value;
	var bauthor=document.getElementById("bookauthor").value;
	var bquantity=document.getElementById("bookquantity").value;
	var bdesc=document.getElementById("bookdesc").value;
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


<jsp:include page="header.jsp"></jsp:include>

<form  onsubmit="return validate()" action="BookServlet" method="post" enctype="multipart/form-data">
<h1><u><b>Add Book Details</b></u></h1>
<table  border="1">
<tr>
<th>Enter Book Name</th>
<th><input id="bookname" type="text" name="bookname"></th>
<td> <span id="ebookname" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Book Prize</th>
<th><input id="bookprize" type="text" name="bookprize"></th>
<td><span id="ebookprize" style="color:red"></span></td>
</tr>
<tr>
<th>Enter Book Author</th>
<th><input id="bookauthor" type="text" name="bookauthor"></th>
<td><span id="ebookauthor" style="color:red"></span></td>
</tr>
<tr>
<th>Enter Book Publisher</th>
<th>
<select name="publisher">
<option value="Techmax">Techmax</option>
<option value="Nirali">Nirali</option>
<option value="Arihant">Arihant</option>
<option value="Red Turtle">Red Turtle</option>
<option value="Penguins Books Limited">Penguins Books Limited</option>
</select>
</th>
</tr>
<tr>
<th>Enter Book Category</th>
<th>
<select name="category">
<option value="Comedy">Comedy</option>
<option value="Motivational">Motivational</option>
<option value="Devotional">Devotional</option>
<option value="Educational">Educational</option>
<option value="Fiction">Fiction</option>
<option value="Non-Fiction">Non-Fiction</option>
<option value="Poetry">Poetry</option>
<option value="Religious">Religious</option>
</select>
</th>
</tr>
<tr>
<th>Enter Book Quantity</th>

<th><input id="bookquantity" type="text" name="bookquantity"></th>
<td><span id="ebookquantity" style="color:red"></span></td>

</th>
</tr>
<tr>
<th>Enter Book Description</th>
<th><input id="bookdesc" type="text" name="bookdesc"></th>
<td><span id="ebookdesc" style="color:red"></span></td>
</tr>
<tr>
<th>Book Image</th>
<th><input type="file" size=500 name="bookImage"></th>

</tr>
<tr>

<th><input type="reset"  value="Clear" name="" ></th>

<th><input type="submit" value="Add" name="action"></th>
</tr>
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</center>

</body>
</html>