<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1"%>
<%@ page buffer="500kb" autoFlush="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asset List</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
</head>
<body>
<form action="assetList.htm" method="post">
	<jsp:include page="/WEB-INF/Includes/Header.jsp" />
	<jsp:include page="/WEB-INF/Includes/Tab.jsp" />
	<div id="contentwrap">
		<div id="content">
			<div id="content">
				<div id="table">
					<table summary="Submitted table designs">
						<thead>
							<tr>
								<th scope="col">ASSET TYPE</th>
								<th scope="col">MAC SERIAL NUMBER </th>
								<th scope="col">ASSET ID</th>
								<th scope="col">ASSET BRAND</th>
								<th scope="col">ASSET STATUS</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${asset}" var="asset">
							<tr>
								<td>${asset.assetType}</td>
								<td>${asset.macSerialNo}</td>
								<td>${asset.assetId}</td>
								<td>${asset.assetBrand}</td>
								<td>${asset.assetStatus}</td>
								<td><a href="assetRelease.htm?id=${asset.assetId}&type=${asset.assetType}">
									<input type="button" value="Release"/>
									</a>
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