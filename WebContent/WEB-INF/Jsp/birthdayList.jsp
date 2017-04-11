<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page buffer="8kb" autoFlush="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Birthday List</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
<script type="text/javascript">
function sendData()
{
var mailName = document.getElementById("empName");
var sendmail = mailName.options[mailName.selectedIndex].value;
document.birthday.sendMailValue.value=sendmail;
alert(document.birthday.sendMailValue.value);
document.birthday.submit();
}

</script>
</head>
<body>
<form name="birthday" action="birthList.htm" method="post" >
<input type="hidden" value="" name="sendMailValue">
<input type="hidden" value="" name="field1">
	<jsp:include page="../Includes/Header.jsp" />
	<jsp:include page="../Includes/Tab.jsp" />
	<c:set var="errors" value="${errors}"/>  
	<c:choose>
	<c:when test="${fn:length( errors)>0}">
	
	<c:out value="${errors}"></c:out>
	</c:when>
	<c:otherwise>
	
	<div id="contentwrap">
		<div id="content">
			<div id="content">
				<div id="table">
					<table summary="Submitted table designs">
						<thead>
							<tr><th scope="col">NAME</th>
								<th scope="col">DOB</th>
								<th scope="col">MAIL ID</th>
								<th scope="col">SEND MAIL</th> 
							</tr>
						</thead>
						<tbody>
							<tr>
							
					         
								
								
								        <td>
								        <select id="empName" >
								        	<c:forEach items="${birthdaylist}" var="birthdaylists">
								        <option selected="selected" value="${birthdaylists.name}"><c:out value="${birthdaylists.name}"/></option>
								        	</c:forEach>
								        <c:set var="fieldvalue" value="0"></c:set>
								        	</select>
								        </td>
								        <td>


								         <select>
								        	<c:forEach items="${birthdaylist}" var="birthdaylists">
								        <option selected="selected" value="${birthdaylists.birthDayDate}"><c:out value="${birthdaylists.birthDayDate}"/></option>
								        	</c:forEach>
								        	</select>
								       </td>
								        <td>
								        
								      <select>
								        	<c:forEach items="${birthdaylist}" var="birthdaylists">
								        <option selected="selected" value="${birthdaylists.appleMailID}"><c:out value="${birthdaylists.appleMailID}"/></option>
								        	</c:forEach>
								        	</select>
								        </td>
								        	<td> <button type="button" name="sendmail"  onClick="sendData();">Send Mail</button></td>						   
								       
								
								   </tr>		
										<!--  <td>${birthday.name}</td>
										<td id="birth">${birthday.birthDayDate}</td>
										<td><a href="mailto:${birthday.appleMailID}?Subject=HAPPY%20BIRTHDAY%20!!!&body=Wish%20You%20A%20Very%20Happy%20Birthday%20Dear%20${birthday.name}">${birthday.appleMailID}</a></td>-->
																	
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	</c:otherwise>
	</c:choose>
	</form>
</body>
</html>
