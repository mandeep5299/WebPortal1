<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../CSS/style.css" type="text/css" />

</head>
<body>
<div id="dvtopcontainer">
    <!-- top container starts here-->
    <div id="dvlogocontainer">
      <!-- logo container starts here-->
	  <h1>Wipro Apple Web Portal</h1>
      
      <!-- logo container ends here-->
    </div>
    <div id="dvnavicontainer">
      <!-- navogation div starts here-->
     
<%
      
      System.out.println(" $$$$$$$$$$$$   "+request.getContextPath());
      
      %>
      
      <ul id="css3menu11" class="topmenu">
	<li class="topmenu"><a href="login.htm" style="height:24px;line-height:104px;"><img src="Images/256base-home.png" alt="" /></a></li>
	<li class="topmenu"><a href="Logout.jsp" style="height:24px;line-height:104px;"><img src="Images/256base-buy.png" alt=""/></a></li>
	<li class="topmenu"><a href="Finder.htm" style="height:24px;line-height:104px;"><img src="Images/find.png" alt=""/></a></li>
	
</ul>
    </div>
     <font style="color: red ;font-style: Courier New"><marquee>
Please ensure that your desk,board and workplace are clean. A Client Visit has been scheduled for tomorrow.
Also please ensure that you are dressed in formals. </marquee></font>
 </div>
</body>
</html>