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
	<form action="SearchTraining.htm" method="post">
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
								<td><label style="size: 20px;">TRAINING NAME</label></td>
								<td><input type="TEXT" NAME="trainingname" /></td>
							</tr>
							<tr class="odd">
								<td><label style="size: 20px;">EMPLOYEE ID</label></td>
								<td><input type="TEXT" NAME="employeeId" /></td>

							</tr>
							<tr>
								<td><label style="size: 20px;">DATE</label></td>
								<td><input type="TEXT" NAME="date" /></td>

							</tr>
							<tr>
								<td><label style="size: 20px;">VENUE</label></td>
								<td><input type="TEXT" NAME="venue" /></td>

							</tr>
							<tr>
								<td><label style="size: 20px;">TIME</label></td>
								<td><input type="TEXT" NAME="time" /></td>

							</tr>
							</thead>

					</table>

					<br>
					<center><input type="submit" value="SEARCH TRAINING" name="SUBMIT" ></center>

				</div>


			</div>
		</div>
	</form></center>
</body>
</html>