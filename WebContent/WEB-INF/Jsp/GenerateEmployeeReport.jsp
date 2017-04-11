<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.wipro.portal.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Employee Report</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />

<body onload="document.getElementById('employeeName').focus();">

<form action="SearchEmployee.htm" method="post" >
	
	<jsp:include page="/WEB-INF/Includes/Header.jsp" />

	<jsp:include page="/WEB-INF/Includes/Tab.jsp" />
	<div id="contentwrap">
		<div id="content">
			<div id="content">
				<div id="table">
				            <br>
				    <header><center>SEARCH RESULT</center></header>        
					<table summary="Submitted table designs">
					<thead>
						<thead style="size: 20px;">
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
							</thead><br>
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
									</tr>
								</c:forEach>
							</tbody>
					</table>
					</div>
					</div>
					</div>
						
		<br><center>
		<input type="submit" name="SUBMIT" value="Import As PDF" > 
		<input type="submit" name="SUBMIT" size="30" value="Import As XLS">
		</center>
			
	</div>
	</form>	
</body>
</html>