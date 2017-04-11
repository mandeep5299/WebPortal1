<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page buffer="500kb" autoFlush="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Edit</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />

<script type="text/javascript" src="jQuery/jquery-1.7.1.min.js"></script>
<script src="jQuery/jquery.popUpWindow.js" type="text/javascript"></script>

<script type="text/javascript">
$(function()
		{
			$('.popUp').popupWindow({ 
				height:200, 
				width:500, 
				top:50, 
				left:50,
				centerBrowser:1 
			}); 
		
		});
</script>
</head>
<script language="javascript">
		function fnTrainingEdit() {
			
			document.trainingedit.action.value="editSave";
			alert(document.trainingedit.action.value);
			 if(document.trainingedit.trainingName.value=="")
			{
				alert("Enter Name");
				document.trainingedit.trainingName.focus();
				return false;	
			}
			else if(document.trainingedit.trainingId.value=="")
			{
				alert("Enter ID");
				document.trainingedit.trainingId.focus();
				return false;	
			}
			else if(document.trainingedit.trainingDescription.value=="")
			{
				alert("Enter Description");
				document.trainingedit.trainingDescription.focus();
				return false;	
			}	
			else if(document.trainingedit.prerequistics.value=="")
			{
				alert("Enter prerequistics");
				document.trainingedit.prerequistics.focus();
				return false;	
			}		
			else if(document.trainingedit.date.value=="")
			{
				alert("Enter date");
				document.trainingedit.date.focus();
				return false;	
			}
			else if(document.trainingedit.time.value=="")
			{
				alert("time");
				document.trainingedit.time.focus();
				return false;
			}
			else if(document.trainingedit.venue.value=="")
			{
				alert("Enter venue");
				document.trainingedit.venue.focus();
				return false;	
			}	
			else if(document.trainingedit.contact.value=="")
			{
				alert("Enter contact");
				document.trainingedit.contact.focus();
				return false;	
			}	
			
			else {
				alert("SUCCESSFULLY MODIFIED");
				return true;
			}	
		}
		</script>
<body>
	<form name="trainingedit" action="editTraining.htm" method="post" enctype="multipart/form-data">
		<jsp:include page="../Includes/Header.jsp" />
		<jsp:include page="../Includes/Tab.jsp" />
	<div id="contentwrap">
		<div id="content">
			<div id="content">
				<div id="table">
					<table summary="Submitted table designs" align="center">	
						<thead>
							<tr><th align="center">EDIT DETAILS</th><th></th></tr>
							
							</thead>	
							<tr>
								<tr class="odd">
									<td><label style="size: 20px;"> EMPLOYEE ID </label></td>
									<td><input type="TEXT" NAME="employeeId" value="${training.employeeId}" readonly="readonly"/>
									<input type="hidden" name="trainingId" id="trainingId" value="${training.trainingId}"/></td>
								</tr>
								<tr>
									<td><label style="size: 20px;"> TRAINING NAME </label></td>
									<td><input type="TEXT" NAME="trainingName" value="${training.trainingname}" /></td>

								</tr>
								<tr class="odd">
									<td><label style="size: 20px;"> TRAINING DESCRIPTION </label></td>
									<td><textarea rows="4" cols="40" NAME="trainingDescription" >${training.trainingdescription}</textarea></td>

								</tr>
								<tr>
									<td><label style="size: 20px;">PREREQUISITES </label></td>
									<td><textarea rows="4" cols="40" NAME="prerequistics">${training.prerequistics}</textarea></td>

								</tr>
								<tr class="odd">
									<td><label style="size: 20px;">DATE </label></td>
									<td><input type="TEXT" NAME="date" value="${training.date}" /></td>

								</tr>

								<tr>
									<td><label style="size: 20px;">TIME </label></td>
									<td><input type="TEXT" NAME="time" value="${training.time}"  />	</td>

								</tr>


								<tr class="odd">
									<td><label style="size: 20px;">VENUE </label></td>
									<td><textarea rows="4" cols="40" NAME="venue" >${training.venue}</textarea></td>

								</tr>

								<tr>
									<td><label style="size: 20px;">CONTACT PERSON </label></td>
									<td><input type="TEXT" NAME="contactNumber" value="${training.contactperson}"/></td>

								</tr>
								<tr class="odd">						
									<td><label style="size: 20px;">EDIT ATTACHMENTS : </label></td>
									<td>${training.attachFile1}  <a href="CSS/popUpWindow.jsp" class="popUp">Edit</a><br><br>
										${training.attachFile2}  <a href="#" >Edit</a><br><br>
										${training.attachFile3}  <a href="#" >Edit</a>
									</td>
										
								</tr>
				
						</table>
					<table align="center">
						<tr>
							<td><input type="submit" value="Update"	onclick="return fnTrainingEdit();"></td>
						</tr>
					</table>
						<input type="hidden" name="action" id="action"/>
					
		</div></div></div></div>
	</form>
</body>
</html>