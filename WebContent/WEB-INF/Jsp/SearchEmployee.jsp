<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employee</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
</head>
<script>
</script>
<body><center>
	<form action="SearchEmployee.htm" method="post">
		<jsp:include page="/WEB-INF/Includes/Header.jsp" />


		<jsp:include page="/WEB-INF/Includes/Tab.jsp" />
		<div id="contentwrap">
			<div id="content">

				<div id="addtable">
					<table summary="Submitted table designs">
						<thead style="size: 20px;">
							<tr>
							<th>SEARCH EMPLOYEE</th><th></th>
							</tr>
							<tr>
								<td><label style="size: 20px;"> NAME </label></td>
								<td><input type="TEXT" NAME="employeeName" /></td>
							</tr>
							<tr class="odd">
								<td><label style="size: 20px;"> ID </label></td>
								<td><input type="TEXT" NAME="employeeId" /></td>

							</tr>
							<tr>
								<td><label style="size: 20px;">BUSINESS UNIT </label></td>
								<td><input type="TEXT" NAME="businessUnit" /></td>

							</tr>
							<tr>
								<td><label style="size: 20px;"> CONTACT NUMBER </label></td>
								<td><input type="TEXT" NAME="contactNumber" /></td>

							</tr>
							<tr class="odd">
								<td><label style="size: 20px;"> AIM MAIL ID </label></td>
								<td><input type="TEXT" NAME="aimId" /></td>

							</tr>
							<tr>
								<td><label style="size: 20px;">WIPRO MAIL ID </label></td>
								<td><input type="TEXT" NAME="wiproId" /></td>

							</tr>
							<tr>
								<td><label style="size: 20px;">APPLE MAIL ID </label></td>
								<td><input type="TEXT" NAME="appleId" /></td>

							</tr>
							</thead>

					</table>

					<br>
					<center><input type="submit" value="SEARCH EMPLOYEE" name="SUBMIT" ></center>

				</div>


			</div>
		</div>
	</form></center>
</body>
</html>