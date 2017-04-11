<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page buffer="500kb" autoFlush="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
</head>
<body>
	<form action="EmployeeList.htm" method="post">

		<jsp:include page="../Includes/Header.jsp" />


		<jsp:include page="../Includes/Tab.jsp" />
		<div id="contentwrap">
			<div id="content">
				<div id="content">
					<div id="table">
						<table summary="Submitted table designs" align="center">
							<thead>
								<tr>
									<th scope="col">EMPLOYEE ID</th>
									<th scope="col">NAME</th>
									<th scope="col">BUSINESS UNIT</th>
									<th scope="col">STATUS</th>
									<th scope="col">CONTACT NUMBER</th>
									<th scope="col">AIM MAIL ID</th>
									<th scope="col">WIPRO MAIL ID</th>
									<th scope="col">AIM CHAT ID</th>
									<th scope="col">APPLE MAIL ID</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employee}" var="employee">
									<tr>
										<td>${employee.employeeID}</td>
										<td>${employee.name}</td>
										<td>${employee.businessUnit}</td>
										<td>${employee.status}</td>
										<td>${employee.contactNo}</td>
										<td>${employee.aimMailID}</td>
										<td>${employee.wiproMailID}</td>
										<td>${employee.aimChatID}</td>
										<td>${employee.appleMailID}</td>
											<td><input type="hidden" name="action" id="action"/><a href="employeeDelete.htm?id=${employee.employeeID}" > <img src="Images/Delete24.gif"
											alt="" ></a><a href="employeeEdit.htm?id=${employee.employeeID}&action=openEdit">
											<img src="Images/Edit.png" alt=""/> </a>
											</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>						
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>