<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function validate()
{
	var emailid=document.getElementById("emailid").value;
	var oldPassword=document.getElementById("oldpassword").value;
	var newPassword=document.getElementById("newpassword").value;
	var confirmPassword=document.getElementById("confirmpassword").value;
	if(emailid=="")
	{
	document.getElementById("Eemailid").innerHTML="please enter email Id";
     return false;
     }
else
	{
	document.getElementById("Eemailid").innerHTML="";
	}
	if(oldPassword=="")
		{
		document.getElementById("eoldpassword").innerHTML="please enter old password";
	     return false;
	     }
	else
		{
		document.getElementById("eoldpassword").innerHTML="";
		}
	if(newPassword=="")
	{
	document.getElementById("enewpassword").innerHTML="please enter new password";
     return false;
     }
else
	{
	document.getElementById("enewpassword").innerHTML="";
	}
	if(confirmPassword=="")
	{
	document.getElementById("econfirmpassword").innerHTML="please confirm new password";
     return false;
     }
else
	{
	document.getElementById("econfirmpassword").innerHTML="";
	}
return true;
}

</script>
</head>
<body>

<center>
<jsp:include page="header.jsp" ></jsp:include>
     
<h1><b><u>Change Password</u></b></h1>
<form onsubmit="return validate()" action="LoginServlet" method="post">
<table border=1>
<tr>
<th>Enter Email Id</th>
<th><input id="emailid" type="text" name="emailid" value="${adminId}" readonly="readonly"></th>
<td> <span id="Eemailid" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Old Password</th>
<th><input id="oldPassword" type="text" name="password"></th>
<td> <span id="eoldpassword" style="color:red" ></span></td> 
</tr>
<tr>
<th>Enter New Password</th>
<th><input id="newPassword" type="text" name="newPassword"></th>
<td> <span id="enewpassword" style="color:red" ></span></td>
</tr>
<tr>
<th>Confirm Password</th>
<th><input id="confirmpassword" type="text" name="newPassword"></th>
<td> <span id="econfirmpassword" style="color:red" ></span></td> 
</tr>
<tr>
<th><input type="reset"  value="Reset" name="" ></th>
<th><input type="submit" value="Change" name="action"></th>
</tr>
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</center>

</body>
</html>