<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.wipro.portal.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Entry</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />

<script language ="javascript">
	var counter = 0;
	var MaxButton=3;

	function checkfilesExtention(f)
	{	
		 f = f.elements;
     	 var i=0;
       	 var flag = true;
		 var extCounter = 0;
		 var wrongExtenstionIndex;
		 var fieName = "";
		 var strLength = 0;
		
		 while (i < MaxButton) {
			 alert("DJ" + i);

		  fieName = f['file'+i].value.toLowerCase();
		  strLength = fieName.length;
		  if(strLength != 0){
			  if(/.*\.(pdf)|(doc)|(xls)|(docx)|(xlsx)|(ppt)|(pptx)$/.test(f['file'+i].value.toLowerCase())){
					 flag = true;		
				 }else{
					 wrongExtenstionIndex = i;
					 flag = false;
					 break;
			 	}
		  	}else{
				 flag = true;
			}
		  i++;
		 }
		 alert("FLAG : "+flag);
		 if(flag){
				alert ("PASSED");
		 		return true;
		 }else{
				f['file'+wrongExtenstionIndex].focus();
				 alert ("FAILED");
			 	return false;
	 	 }
	}
	
	function fnTrainingDetails() {

		if (document.frmTrainingDetails.employeeID.value == "") {
			alert("Enter the Employee Id");
			document.frmTrainingDetails.employeeID.focus();
			return false;
		}
		else if (document.frmTrainingDetails.trainingname.value == "") {
			alert("Enter Training Name");
			document.frmTrainingDetails.trainingname.focus();
			return false;
		}

		else if (document.frmTrainingDetails.trainingdescription.value == "") {
			alert("Enter the Training Description");
			document.frmTrainingDetails.trainingdescription.focus();
			return false;
		}
		else if (document.frmTrainingDetails.prerequistics.value == "") {
			alert("Enter the Training Pre Requistics");
			document.frmTrainingDetails.prerequistics.focus();
			return false;
		}
		else if (document.frmTrainingDetails.date.value == "") {
			alert("Enter Training Date");
			document.frmTrainingDetails.date.focus();
			return false;
		}
		else if (document.frmTrainingDetails.time.value == "") {
			alert("Enter Training Time");
			document.frmTrainingDetails.time.focus();
			return false;
		}
		else if (document.frmTrainingDetails.venue.value == "") {
			alert("Enter Training Venue");
			document.frmTrainingDetails.venue.focus();
			return false;
		}
		else if (document.frmTrainingDetails.contactperson.value == "") {
			alert("Enter Contact Person");
			document.frmTrainingDetails.contactperson.focus();
			return false;
		}
	}
</script>
</head>
<body onload="document.getElementById('employeeID').focus();">

	<form  action="uploadtest.htm" method="post" onsubmit="return checkfilesExtention(this);" enctype="multipart/form-data" >

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

		<jsp:include page="../Includes/Header.jsp" />



		<jsp:include page="../Includes/Tab.jsp" />
		<div id="contentwrap">
			<div id="content">
				<div id="content">
					<div id="table">
						<table summary="Submitted table designs">
							<thead style="size: 20px;">
								<tr>


									<th>TRAINING ENTRY</th>
									<th></th>
								</tr>
								<tr class="odd">
									<td><label style="size: 20px;"> EMPLOYEE ID </label>
									</td>
									<td><input type="TEXT" NAME="employeeId" />
									</td>

								</tr>
								<tr>
									<td><label style="size: 20px;"> TRAINING NAME </label>
									</td>
									<td><input type="TEXT" NAME="trainingname" />
									</td>

								</tr>
								<tr class="odd">
									<td><label style="size: 20px;"> TRAINING
											DESCRIPTION </label>
									</td>
									<td><textarea rows="4" cols="40"
											NAME="trainingdescription"></textarea>
									</td>

								</tr>
								<tr>
									<td><label style="size: 20px;">PREREQUISITES </label>
									</td>
									<td><textarea rows="4" cols="40" NAME="prerequistics"></textarea>
									</td>

								</tr>
								<tr class="odd">
									<td><label style="size: 20px;">DATE </label>
									</td>
									<td><input type="TEXT" NAME="date" />
									</td>

								</tr>

								<tr>
									<td><label style="size: 20px;">TIME </label>
									</td>
									<td><input type="TEXT" NAME="time" />
									</td>

								</tr>


								<tr class="odd">
									<td><label style="size: 20px;">VENUE </label>
									</td>
									<td><textarea rows="4" cols="40" NAME="venue"></textarea>
									</td>

								</tr>

								<tr>
									<td><label style="size: 20px;">CONTACT PERSON </label>
									</td>
									<td><input type="TEXT" NAME="contactperson" />
									</td>

								</tr>
								<tr class="odd">
									<td><label style="size: 20px;">ADD ATTACHMENTS : </label>
									</td>
									<td><input name="files[0]" type="file" size="60"/><br>
										<input name="files[1]" type="file" size="60"/><br>
										<input name="files[2]" type="file" size="60"/><br></td>
								</tr>
							</thead>


						</table>

					</div>
				</div>
			</div>
			<br/>
			<center><input id="extentionCheck" type="submit" value="SUBMIT" onclick="fnTrainingDetails()"></center>			
		</div>
	</form>
</body>