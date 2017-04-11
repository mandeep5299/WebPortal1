<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asset Allocated List</title>
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
						<tr  ><th class="odd" colspan="5"><h2>ALLOCATED ASSET</h2></th></tr>
							<tr>
							    <th scope="col">S.NO</th>
								<th scope="col">ASSET ID</th>
								<th scope="col">ASSET NAME</th>
								<th scope="col">BRAND</th>
								<th scope="col">IP</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<th scope="row" id="r100">01</th>	
								<td><a href="DeallocateAsset.jsp">APP-0001</a></td>								
								<td>Keyboard</td>
								<td>Apple</td>
								<td> </td>
							</tr>
							<tr class="odd">
								<th scope="row" id="r100">02</th>
								<td><a href="#">APP-0002</a></td>								
								<td>Mouse</td>
								<td>Wipro</td>
								<td>  </td>
							</tr>
							<tr>
								<th scope="row" id="r100">04</th>
								<td><a href="#">APP-0004</a></td>								
								<td>Desktop</td>
								<td>Apple</td>
								<td>10.173.182.118  </td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>