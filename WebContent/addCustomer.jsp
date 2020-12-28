<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addCustomer</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function validate()
{
	var cname=document.getElementById("customername").value;
	var cmob=document.getElementById("customerMobno").value;
	var caddress=document.getElementById("customerAddress").value;
	var cemailid=document.getElementById("customerEmailid").value;
	var cpassword=document.getElementById("customerPassword").value;
	if(cname=="")
		{
		document.getElementById("ecustomername").innerHTML="please enter customer name";
	     return false;
	     }
	else
		{
		document.getElementById("ecustomername").innerHTML="";
		}
	
	if(cmob=="")
		{
		document.getElementById("ecustomerMobno").innerHTML="please enter customer Mob no";
	     return false;
	     }
	else
		{
		document.getElementById("ecustomerMobno").innerHTML="";
		}
	if(caddress=="")
	{
	document.getElementById("ecustomerAddress").innerHTML="please enter customer address";
     return false;
     }
else
	{
	document.getElementById("ecustomerAddress").innerHTML="";
	}
	if(cemailid=="")
	{
	document.getElementById("ecustomerEmailid").innerHTML="please enter customer Email Id";
     return false;
     }
else
	{
	document.getElementById("ecustomerEmailid").innerHTML="";
	}
	if(cpassword=="")
	{
	document.getElementById("ecustomerPassword").innerHTML="please enter customer password";
     return false;
     }
else
	{
	document.getElementById("ecustomerPassword").innerHTML="";
	}
	return true;
}

</script>
</head>
<body>

<center>
<jsp:include page="header.jsp" ></jsp:include>
<form onsubmit="return validate()" action="CustomerServlet" method="post" >
<h1><u><b>Add Customer Details</b></u></h1>
<table  border="1">
<tr>
<th>Enter Customer Name</th>
<th><input id="customername" type="text" name="customername"></th>
<td> <span id="ecustomername" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Mobile Number</th>
<th><input id="customerMobno" type="text" name="customerMobno"></th>
<td> <span id="ecustomerMobno" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter address</th>
<th><textarea id="customerAddress" name="address" values="City"></textarea></th>
<td> <span id="ecustomerAddress" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Email Id</th>
<th><input id="customerEmailid" type="text" name="customerEmailid"></th>
<td> <span id="ecustomerEmailid" style="color:red" ></span></td>
</tr>
<tr>
<th>Enter Password</th>
<th><input id="customerPassword" type="password" name="customerPassword"></th>
<td> <span id="ecustomerPassword" style="color:red" ></span></td>
</tr>
<tr>

<th><input type="reset"  value="Clear" name="" ></th>

<th><input type="submit" value="Add" name="action"></th>
</tr>
</table>
</form>
<jsp:include page="footer.jsp" ></jsp:include>
</center>

</body>
</html>