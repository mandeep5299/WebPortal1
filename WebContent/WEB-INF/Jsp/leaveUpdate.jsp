<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*,java.text.*"%>

<html>
<head>
<title>Leave Update</title>
<link rel="stylesheet" type="text/css" href="CSS/LeaveUpdate.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script>
	function goTo() {
		document.frm.submit();

	}

	function checkVal(obj) {
		alert("   >>>>>   " + obj.checked);
		document.getElementById(frm.fDay).selected = false;
	}
</script>
</head>
<%!public int nullIntconv(String inv) {
		int conv = 0;

		try {
			conv = Integer.parseInt(inv);
		} catch (Exception e) {
		}
		return conv;
	}%>
<%
	int iYear = nullIntconv(request.getParameter("iYear"));
	int iMonth = nullIntconv(request.getParameter("iMonth"));

	Calendar ca = new GregorianCalendar();
	int iTDay = ca.get(Calendar.DATE);
	int iTYear = ca.get(Calendar.YEAR);
	int iTMonth = ca.get(Calendar.MONTH);

	if (iYear == 0) {
		iYear = iTYear;
		iMonth = iTMonth;
	}

	GregorianCalendar cal = new GregorianCalendar(iYear, iMonth, 1);

	int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	int weekStartDay = cal.get(Calendar.DAY_OF_WEEK);

	cal = new GregorianCalendar(iYear, iMonth, days);
	int iTotalweeks = cal.get(Calendar.WEEK_OF_MONTH);
%>
<body>
	<form name="frm" method="post" action="leaveUpdate.htm">
		<jsp:include page="/WEB-INF/Includes/Header.jsp" />
		<jsp:include page="/WEB-INF/Includes/Tab.jsp" />

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="16%" align="right">Year</td>
							<td width="7%"><select name="iYear" onchange="goTo()">
									<%
										// start year and end year in combo box to change year in calendar
										for (int iy = iTYear - 70; iy <= iTYear + 70; iy++) {
											if (iy == iYear) {
									%>
									<option value="<%=iy%>" selected="selected"><%=iy%></option>
									<%
										} else {
									%>
									<option value="<%=iy%>"><%=iy%></option>
									<%
										}
										}
									%>
							</select></td>
							<td width="53%" align="center">
								<h3><%=new SimpleDateFormat("MMMM").format(new Date(2008,
					iMonth, 01))%>
									<%=iYear%></h3>
							</td>
							<td width="14%" align="left">Month</td>
							<td width="10%"><select name="iMonth" onchange="goTo()">
									<%
										// print month in combo box to change month in calendar
										for (int im = 0; im <= 11; im++) {
											if (im == iMonth) {
									%>
									<option value="<%=im%>" selected="selected"><%=new SimpleDateFormat("MMMM").format(new Date(
							2008, im, 01))%></option>
									<%
										} else {
									%>
									<option value="<%=im%>"><%=new SimpleDateFormat("MMMM").format(new Date(
							2008, im, 01))%></option>
									<%
										}
										}
									%>
							</select></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<div id="contentwrapleave">
						
							<div id="contentleave">
								<div id="tableleave">
									<table align="center" border="1" cellpadding="3"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>Sunday</th>
												<th>Monday</th>
												<th>Tuesday</th>
												<th>Wednesday</th>
												<th>Thursday</th>
												<th>Friday</th>
												<th>Saturday</th>
											</tr>
										</thead>
										<tbody class="intro">
											<%
												int cnt = 1;
												for (int i = 1; i <= iTotalweeks; i++) {
											%>
											<tr class="row">
												<%
													for (int j = 1; j <= 7; j++) {
															if (cnt < weekStartDay || (cnt - weekStartDay + 1) > days) {
												%>
												<td class="col" align="center" height="35">&nbsp;</td>
												<%
													} else {
												%>
												<td align="center" height="50"
													id="day_<%=(cnt - weekStartDay + 1)%>" height="100%"><span>
														<%=(cnt - weekStartDay + 1)%> <br> <br> <br>
												</span> <INPUT TYPE=CHECKBOX name="fullDay" id="fullDay"
													value="<%=(cnt - weekStartDay + 1)%>"> Full Day
													Leave <br> &nbsp;<INPUT TYPE=CHECKBOX name="halfDay"
														id="halfDay" value="<%=(cnt - weekStartDay + 1)%>">
													Half Day Leave <br> <br></td>
												<%
													}
															cnt++;
														}
												%>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					
				</td>
			</tr>
		</table>
		<BR>
		<CENTER>
			<INPUT TYPE=SUBMIT NAME="SUBMIT" VALUE="LEAVE UPDATE">
		</CENTER>

	</form>
</body>
</html>
