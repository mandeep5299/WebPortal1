<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Finder</title>
<link rel="stylesheet" type="text/css" href="../CSS/style.css" />
</head>
<body>
<form action="finder.htm" method="post" >
	<jsp:include page="../Includes/Header.jsp" />
	<jsp:include page="../Includes/Tab.jsp" />
		<table summary="Submitted table designs" align="center">
							<tr>
								<th align="center" class="odd" colspan="5"><h2>FINDER</h2></th>
							</tr>
							<tr>
								<td>Query:</td><td><input type="TEXT" NAME="query" id="query"/></td>
	 						    <td>Keyword:</td>
								<td><input type="TEXT" NAME="keyword" id="keyword"/></td> 
							</tr>
							<tr>
								<td align="center" class="odd" colspan="5"><input type="submit" value="Find" /></td>								
							</tr>
					</table>
				
		
	
</form>

</body>
</html>