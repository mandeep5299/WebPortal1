<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page buffer="8kb" autoFlush="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Visa Report</title>
<link rel="stylesheet" type="text/css" href="../CSS/style.css" />
</head>
<body>
	<jsp:include page="../Includes/Header.jsp" />


	<jsp:include page="../Includes/Tab.jsp" />
	<div id="contentwrap">
		<div id="content">
			<div id="content">
				<div id="itsthetable">
					<table summary="Submitted table designs">
						<thead>
							<tr>
								<th scope="col">S.NO</th>
								<th scope="col">EMPLOYEE ID</th>
								<th scope="col">NAME</th>
								<th scope="col">BUSINESS UNIT</th>
								<th scope="col">STATUS</th>
								<th scope="col">CONTACT NUMBER</th>
								<th scope="col">AIM MAIL ID</th>
								<th scope="col">WIPRO MAIL ID</th>
								<th scope="col">AIM CHAT ID</th>
								<th scope="col">APPLE MAIL ID</th>
								<th scope="col">VISA ID</th>
								<th scope="col">VISA TYPE</th>
								<th scope="col">VALID FROM</th>
								<th scope="col">VALID TO</th>
								<th scope="col">COUNTRY</th>
								<th scope="col">  </th>
								
							</tr>
						</thead>

						<tbody>
						<c:forEach items="${reportev}" var="reportev">
							<tr>
						<td>${reportev.EmployeeID}</td>
						<td>${reportev.Name}</td>
						<td>${reportev.BusinessUnit}</td>
						<td>${reportev.Status}</td>
						<td>${reportev.ContactNo}</td>
						<td>${reportev.AIMMailID}</td>
						<td>${reportev.WiproMailID}</td>
						<td>${reportev.AIMChatID}</td>
						<td>${reportev.AppleMailID}</td>
						<td>${reportev.visaId}</td>
						<td>${reportev.visaType}</td>
						<td>${reportev.validFrom}</td>
						<td>${reportev.validTo}</td>
				
						<td><a href ="#"></a> <img src="Images/Delete24.gif" alt=""><a href="#"><img
         src="Images/Edit.png" alt="" /></a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>