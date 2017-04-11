<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page buffer="500kb" autoFlush="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training List</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
</head>
<body>
<form action="trainingList.htm" method="post" >

	<jsp:include page="/WEB-INF/Includes/Header.jsp" />
	<jsp:include page="/WEB-INF/Includes/Tab.jsp" />
	<div id="contentwrap">
		<div id="content">
			<div id="content">
				<div id="table">
					<table summary="Submitted table designs" align="center">
						<thead>
							<tr><th scope="col">EMPLOYEE NO</th>
								<th scope="col">TRAINING NAME</th>
								<th scope="col">DATE</th>
								<th scope="col">TIME</th>
								<th scope="col">VENUE</th>
								<th scope="col"></th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${training}" var="training">
						<tr>
							<td>${training.employeeId}</td>
							<td>${training.trainingname}</td>
							<td>${training.date}</td>
							<td>${training.time}</td>
							<td>${training.venue}</td>
							<td><a href="#">Details</a></td>
							<td><input type="hidden" name="action" id="action"/><a href="trainingDelete.htm?id=${training.trainingId}"> <img src="Images/Delete24.gif"	alt="" ></a>
						 	<a href="trainingEdit.htm?id=${training.trainingId}&action=openEdit"><img src="Images/Edit.png" alt=""/> </a>
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