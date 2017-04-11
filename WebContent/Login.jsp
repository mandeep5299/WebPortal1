<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
<script language="javascript">


function fnLogin()
{
	
	 if(document.loginform.uname.value=="")
		 {
		 alert("Enter Username");
		 document.loginform.uname.focus();
		 return false;
		 }	

	  else if(document.loginform.password.value=="")
	 	{
		 alert("Enter Password");
	 	document.loginform.password.focus();
	 	return false;		 
		 }
	 
	 }
	 </script>
</head>
<body style="background-color: #E8E8E8">
  <form name="loginform" id="loginform" action="login.htm" method="post" onsubmit="return fnLogin();">

<jsp:include page="/WEB-INF/Includes/LoginHeader.jsp" />

	<div id="contentwrapli">
		<div id="contentli">

			<ui> <a href="assetEntry.htm"><span> <i><b>EMPLOYEE
							LIST</b></i></span></a></ui>
			<br> <br>
			<ui> <a href="training.htm"><span><i> <b>TRAINING
							LIST</b></i></span></a></ui>
			<br> <br>
			<ui> <a href="bestpractices.htm"><span> <i><b>BEST
							PRACTICES</b></i></span></a></ui>
		</div>
	</div>
	<div id="contentwrapl">
		<div id="contentl">
			<div id="addtable">
				<table summary="Submitted table designs">
					<thead style="size: 20px;">
						<tr>
							<th>ADMIN LOGIN</th>
							<th></th>
						</tr>
						<tr>
							<td><label style="size: 20px;"> ADMIN ID </label></td>
							<td><input type="text" NAME="uname" /></td>
						</tr>
						<tr class="odd">
							<td><label style="size: 20px;"> PASSWORD</label></td>
							<td><input type="password" NAME="password" /></td>
						</tr>
					</thead>
				</table>
				<br> <br>
			</div>
		</div>
		<input type="submit" value="Login"> <input type="Reset"
			size="30" value="Reset">

	</div>
</form>
</body>
</html>