<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Allocate Asset</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css" />

<script src="jQuery/datetimepicker_css.js"></script>

<link rel="stylesheet" type="text/css" href="CSS/anytime.css" />
<script src="jQuery/jquery.js"></script>
<script src="jQuery/anytime.js"></script>
<script src="jQuery/anytimetz.js"></script>

<script language="javascript">

	function fnAllocateAsset() {

		if (document.frmAllocateAsset.empId.value == "" || document.frmAllocateAsset.empId.value == 0) {
			alert("Enter Employee Id Type");
			document.frmAllocateAsset.empId.focus();
			return false;
		}
		else if (document.frmAllocateAsset.empName.value == "") {
			alert("Enter the Employee Name");
			document.frmAllocateAsset.empName.focus();
			return false;
		}
		else if (document.frmAllocateAsset.empEmail.value == "") {
			alert("Enter the Employee Email");
			document.frmAllocateAsset.empEmail.focus();
			return false;
		}
		else if (document.frmAllocateAsset.empProximityCardNo.value == "" || document.frmAllocateAsset.empProximityCardNo.value == 0) {
			alert("Enter the Employee Proximity Card No");
			document.frmAllocateAsset.empProximityCardNo.focus();
			return false;
		}
		
		
		
	}
</script>

</head>
<body>
<form name="frmAllocateAsset" id="frmAllocateAsset" action="AllocateAsset.htm" method="post" onsubmit="return fnAllocateAsset();">
<jsp:include page="/WEB-INF/Includes/Header.jsp" /> 


 <jsp:include page="/WEB-INF/Includes/Tab.jsp" />
	<div id="contentwrap">
		<div id="content">
			<div id="table">
			
			<table>
				<tr>
					<th colspan="4">ALLOCATE ASSET</th>
				</tr>
				<tr class="odd">
					<td ><label style="size: 20px;">ALLOCATED TO:</label><input type="TEXT" NAME="allocatedTo" id="allocatedTo" /></td>
					<td ><label style="size: 20px;">EMPLOYEE ID:</label><input type="TEXT" NAME="employeeId" id="employeeId" /></td>
					<td ><label style="size: 20px;">ALLOCATED BY:</label><input type="TEXT" NAME="allocatedBy" id="allocatedBy" /></td>
					<td ><label style="size: 20px;">ALLOCATED DATE:</label><input type="TEXT" NAME="allocatedDate" id="allocatedDate" readonly="readonly" onclick="javascript:NewCssCal('allocatedDate')"/></td>
				</tr>
				
				<tr>
					<td><label style="size: 20px;">CPU:</label>
								<select name="cpuId" id="cpuId">
											<option value="">SELECT</option>
									 <c:forEach items="${freeCPUList}" var="count">
											<option value="${count}"><c:out value="${count}"/></option> 
									  </c:forEach>
								</select></td>
											
							<td><label style="size: 20px;">MONITOR:</label>
							
								<select name="monitorId" id="monitorId">
											<option value="">SELECT</option>
										<c:forEach items="${freeMonitorList}" var="count">
											<option value="${count}"><c:out value="${count}"/></option> 
									  </c:forEach>
								</select></td>
								<td><label style="size: 20px;">KEYBOARD:</label>
								<select name="keyboardId" id="keyboardId">
											<option value="">SELECT</option>
										<c:forEach items="${freeKeyboardList}" var="count">
											<option value="${count}"><c:out value="${count}"/></option> 
									  </c:forEach> 
								</select></td>
							
							<td><label style="size: 20px;">MOUSE:</label><select name="mouseId" id="mouseId">
											<option value="">SELECT</option>
										<c:forEach items="${freeMouseList}" var="count">
											<option value="${count}"><c:out value="${count}"/></option> 
									  </c:forEach>
								</select></td>
						
					
				</tr>
				<tr class="odd">
					<td colspan="2"><label style="size: 20px;">CREATED DATE:</label><input type="TEXT" NAME="createdDate" id="createdDate" readonly="readonly" onclick="javascript:NewCssCal('createdDate')"/></td>
					<td colspan="2"><label style="size: 20px;">UPDATED DATE:</label><input type="TEXT" NAME="updatedDate" id="updatedDate" readonly="readonly" onclick="javascript:NewCssCal('updatedDate')"/></td>
					
				</tr>
				<tr>	
								<td colspan="4">
										<input type="submit" value="ADD">
									 <input type="Reset" size="30" value="RESET"></td>
						</tr>
			</table>
							
			</div>
		</div>
	</div>
	</form>
	</body>
</html>