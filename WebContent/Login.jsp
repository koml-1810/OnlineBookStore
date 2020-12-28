<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function validate()
{
	var emailid=document.getElementById("emailid").value;
	
	var password=document.getElementById("password").value;
	if(emailid=="")
	{
	document.getElementById("Eemailid").innerHTML="please enter email Id";
     return false;
     }
else
	{
	document.getElementById("Eemailid").innerHTML="";
	}
	if(password=="")
		{
		document.getElementById("epassword").innerHTML="please enter password";
	     return false;
	     }
	else
		{
		document.getElementById("epassword").innerHTML="";
		}
return true;
}
</script>


</head>
<body>

<center>
<jsp:include page="header.jsp" ></jsp:include>
<form onsubmit="return validate()" action="LoginServlet" method="post" >
<h1><u><b>Login</b></u></h1>
<table  border="1">

<tr>
<th><input type="text" ></th>
<th><select  name="type">
<option value="admin">Admin</option>
<option value="customer">Customer</option>
</select></th>
</tr>
<tr>
<th>Email Id</th>
<th><input id="emailid" type="text" name="emailid"></th>
<td> <span id="Eemailid" style="color:red" ></span></td>
</tr>
<tr>
<th>Password</th>
<th><input id="password" type="text" name="password"></th>
<td> <span id="epassword" style="color:red" ></span></td> 
</tr>

<tr>

<th><input type="reset"  value="Cancel" name="" ></th>

<th><input type="submit" value="Login" name="action"></th>
</tr>
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</center>

</body>
</html>