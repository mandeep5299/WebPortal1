<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.wipro.portal.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Asset Report</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
<body onload="document.getElementById('assetname').focus();">

<form action="SearchAsset.htm" method="post" >
	
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
									
									<th scope="col">ASSET ID</th>
									<th scope="col">NAME</th>
									<th scope="col">BRAND NAME</th>
									<th scope="col">IP ADDRESS</th>									
								</tr>
							</thead><br>
							<tbody>
								<c:forEach items="${asset}" var="asset">
									<tr>
										<td>${asset.assetid}</td>
										<td>${asset.assetname}</td>
										<td>${asset.brand}</td>
										<td>${asset.ip}</td>
															
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