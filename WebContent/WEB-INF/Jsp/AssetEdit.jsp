<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asset Edit</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
</head>
	<script language="javascript">
		function fnAssetEdit() {
			document.assetedit.action.value="editSave";
 		 if(document.assetedit.assetType.value==""){
				alert("Enter assetType");
				document.assetedit.assetType.focus();
				return false;	
		}
 		else if(document.assetedit.macSerialNo.value==""){
				alert("Enter macSerialNo");
				document.assetedit.macSerialNo.focus();
				return false;
		}
		else if(document.assetedit.assetId.value==""){
				 alert("Enter assetId");
				 document.assetedit.assetId.focus();
				 return false;	
 		}
		 else if(document.assetedit.assetBrand.value==""){
				 alert("Enter assetBrand");
				 document.assetedit.assetBrand.focus();
				 return false;	
	    }
		else {
				alert("SUCCESSFULLY MODIFIED");
				return true;
		}	
	}
		</script>
<body>
	<form name="assetedit" action="assetEdit.htm" method="post">
	<jsp:include page="../Includes/Header.jsp" />
	<jsp:include page="../Includes/Tab.jsp" />
		<table	align="center">
			<tr>
				<td>ASSET TYPE <input type="text" name="macSerialNo" id="macSerialNo" value="${asset.assetType}" /><br /> </td>
				<td>MAC SERIAL NO. <input type="text" name="macSerialNo" id="macSerialNo" value="${asset.macSerialNo}" /><br /></td>
				<td>ASSET ID <input type="text" name="assetId" id="assetId" value="${asset.assetId}" readonly="readonly" /><br /></td>
				<td>ASSET BRAND <input type="text" name="assetBrand" id="assetBrand" value="${asset.assetBrand}" /><br /></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="Update"	onclick="return fnAssetEdit();"></td>
			</tr>
		</table>
		
	<input type="hidden" name="action" id="action"/>
		
	</form>
</body>
</html>