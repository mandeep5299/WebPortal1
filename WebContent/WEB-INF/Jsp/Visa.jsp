<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visa Entry</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
</head>
<body>
<form action="visa.htm" method="post">
	<jsp:include page="/WEB-INF/Includes/Header.jsp" />


	<jsp:include page="/WEB-INF/Includes/Tab.jsp" />
	<div id="contentwrap">
		<div id="content">
			<div id="content">
				<div id="table">
				<table summary="Submitted table designs">
					<thead style="size: 20px;">
						<tr>

							<th>VISA DETAILS</th>
							<th></th>
						</tr>
						<tr>
							<td><label style="size: 20px;"> VISA ID</label></td>
							<td><input type="TEXT" NAME="visaId" /></td>

						</tr>
						<tr class="odd">
							<td><label style="size: 20px;"> VISA TYPE </label></td>
							<td><input type="TEXT" NAME="visaType" /></td>

						</tr>
						<tr>
							<td><label style="size: 20px;">VALID FROM </label></td>
							<td><input type="TEXT" NAME="validFrom" /></td>

						</tr>
						<tr class="odd">
							<td><label style="size: 20px;">VALID TO </label></td>
							<td><input type="TEXT" NAME="validTo" /></td>

						</tr>
						<tr>
							<td><label style="size: 20px;">COUNTRY </label></td>
							<td><input type="TEXT" NAME="country" /></td>
						</tr>
					</thead>

				</table>
			</div>
				<br><input type="submit" value="ADD">
							
			</div>
			</div>
		</div>
</form>
</body>
</html>