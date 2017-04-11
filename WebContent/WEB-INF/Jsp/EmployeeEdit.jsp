<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />

</head>
<script language="javascript">
		function fnEmployeeEdit() {
			document.employeeedit.action.value="editSave";
			 if(document.employeeedit.name.value=="")
			{
				alert("Enter Name");
				document.employeeedit.name.focus();
				return false;	
			}
			else if(document.employeeedit.id.value=="")
			{
				alert("Enter ID");
				document.employeeedit.id.focus();
				return false;	
			}
			else if(document.employeeedit.businessunit.value=="")
			{
				alert("Enter BusissUnit");
				document.employeeedit.businessunit.focus();
				return false;	
			}	
			else if(document.employeeedit.status.value=="")
			{
				alert("Enter Status");
				document.employeeedit.status.focus();
				return false;	
			}		
			else if(document.employeeedit.contact.value=="")
			{
				alert("Enter Contact");
				document.employeeedit.contact.focus();
				return false;	
			}
			else if(isNaN(document.employeeedit.contact.value))
			{
				alert("EmployeeID should be Integer");
				document.employeeedit.contact.focus();
				return false;
			}
			else if(document.employeeedit.aimid.value=="")
			{
				alert("Enter AIMMailID");
				document.employeeedit.aimid.focus();
				return false;	
			}	
			else if(document.employeeedit.wiproid.value=="")
			{
				alert("Enter WiproMailID");
				document.employeeedit.wiproid.focus();
				return false;	
			}	
			else if(document.employeeedit.aimchatid.value=="")
			{
				alert("Enter AIMCharID");
				document.employeeedit.aimchatid.focus();
				return false;	
			}	
			else if(document.employeeedit.appleid.value=="")
			{
				alert("Enter AppleID");
				document.employeeedit.appleid.focus();
				return false;	
			}	
			else {
				alert("SUCCESSFULLY MODIFIED");
				return true;
			}	
		}
		</script>
<body>
	<form name="employeeedit" action="employeeEdit.htm" method="post">
		<jsp:include page="../Includes/Header.jsp" />
		<jsp:include page="../Includes/Tab.jsp" />
		
		<table>
			<tr>				
				<td>ID <input type="text" name="id" value="${employee.employeeID}" readonly="readonly" /><br /></td>
				<td>Name <input type="text" name="name"
					value="${employee.name}" /><br /></td>
				<td>BUSINESS UNIT <input type="text" name="businessunit"
					value="${employee.businessUnit}" /><br /></td>
				<td>STATUS <input type="text" name="status"
					value="${employee.status}" /><br /></td>
				<td>CONTACT NUMBER <input type="text" name="contact"
					value="${employee.contactNo}" /><br /></td>
				<td>AIM MAIL ID <input type="text" name="aimid"
					value="${employee.aimMailID}" /><br /></td>
				<td>WIPRO MAIL ID <input type="text" name="wiproid"
					value="${employee.wiproMailID}" /><br /></td>
				<td>AIM CHAT ID <input type="text" name="aimchatid"
					value="${employee.aimChatID}" /><br /></td>
				<td>APPLE MAIL ID <input type="text" name="appleid"
					value="${employee.appleMailID}" /><br /></td>
			</tr>
		</table>
		
		<br>	<center><input type="submit" value="Update"	onclick="return fnEmployeeEdit();"></center>
		
		
		<input type="hidden" name="action" id="action"/>
	</form>
</body>
</html>