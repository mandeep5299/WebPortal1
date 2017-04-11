<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.wipro.portal.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asset Entry</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />

<script language="javascript">

	function fnAssetDetails() {

		if (document.frmAssetDetails.assetType.value == "" || document.frmAssetDetails.assetType.value == "SELECT" ) {
			alert("Enter Asset Type");
			document.frmAssetDetails.assetname.focus();
			return false;
		}

			
		else if (document.frmAssetDetails.macSerialNo.value == "") {
			alert("Enter the Mac Serial No");
			document.frmAssetDetails.macSerialNo.focus();
			return false;
		}
		else if (document.frmAssetDetails.assetId.value == "") {
			alert("Enter the Asset Id");
			document.frmAssetDetails.assetId.focus();
			return false;
		}
		else if (document.frmAssetDetails.Brand.value == "") {
			alert("Enter the Brand");
			document.frmAssetDetails.Brand.focus();
			return false;
		}
	}
</script>
</head>
<body onload="document.getElementById('assetname').focus();">

<form name="frmAssetDetails" id="frmAssetDetails" action="assetEntry.htm" method="post" onsubmit="return fnAssetDetails();">
	
	<%
					Object errorObj = request.getAttribute("errors");
					if (errorObj != null) {
						Map<String, String> errors = (Map) errorObj;
						for (String error : errors.keySet()) {
							out.write("<tr><td>" + ErrorCodes.getMessage(error)
									+ "</td></tr>");
						}
					}
				%>

	<jsp:include page="/WEB-INF/Includes/Header.jsp" />


	<jsp:include page="/WEB-INF/Includes/Tab.jsp" />
	<div id="contentwrap">
		<div id="content">
			<div id="content">
				<div id="table">
				            
				            
					<table summary="Submitted table designs">
						<thead style="size: 20px;">
							<tr>
								<th colspan=2>ADD NEW ASSETS</th>
							</tr>
							
							<tr  class="odd">
								<td><label style="size: 20px;"> ASSET: </label></td>
								<td><select name="assetType">
									<option value="SELECT">-Select-</option>
									<option value="CPU">CPU</option>
									<option value="MONITOR">MONITOR</option>
									<option value="KEYBOARD">KEYBOARD</option>
									<option value="MOUSE">MOUSE</option>
									</select></td>
								
						
							</tr>
							<tr >
								<td><label style="size: 20px;">MAC SERIAL NO: </label></td>
								<td><input type="TEXT" NAME="macSerialNo" id="macSerialNo" /></td>
										
							</tr>
							<tr class="odd">
								<td><label style="size: 20px;">ASSET ID: </label></td>
								<td><input type="TEXT" NAME="assetId" /></td>
								
							
							</tr>
							
							<tr  >
								<td><label style="size: 20px;">BRAND: </label></td>
								<td><input type="TEXT" NAME="Brand" /></td>
								
							
							</tr>
							<tr class="odd">	
								
								<td colspan=2>
									<input type="submit" value="SUBMIT"> 
								</td>
							</tr>
						</thead>

					</table>
					</div>
					</div>
					</div>
				
			
	</div>
	</form>	
</body>
</html>