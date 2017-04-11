<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Entry</title>
<script type="text/javascript" src="jQuery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="jQuery/jquery.validate.min.js"></script>
<script type="text/javascript" src="jQuery/jquery-calander.js"></script>

<link rel="stylesheet" type="text/css" href="CSS/style.css">
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.css">
<link rel="stylesheet" type="text/css" href="CSS/Calander.css">

<script>

   $(document).ready(function() {

        $("#register-form").validate({
           rules: {
               		employeeName: "required",
                    employeeId: {
                    	required: true,
                    	number : true
                    },
              		businessUnit: "required",
              		status: "required",
              		contactNumber: {	
              			required: true,
              			number : true
              		},
              		aimId:{
              			required : true,
              			email : true
              		},
              		wiproId:{
              			required : true,
              			email : true
              		},
              		aimChatId:{
              			required : true,
	              			email : true
              		},
	              	appleId:{
	              		required : true,
	              		email : true
	              	}
	               },
	    messages: {
	               	employeeName: "Please enter name",
	               	employeeId: {
	               		required:"Please enter Emplyee Id",
	               		number:jQuery.format("Enter only digits")
	               	},
	              	businessUnit: "Please enter business Unit",
	               	status: "Please enter status",
	               	contactNumber:{
	               		required:"Please enter contact Number",
	               		number:jQuery.format("Enter only digits")
	               	},
	                aimId:{
	              		required:"Please enter Aim Id",
	               		email:jQuery.format("Not a valid Aim Id")
	               	},
	                wiproId: {
	              		required:"Please enter Wipro Id",
	               		email:jQuery.format("Not a valid Wipro Id")
	               	},
	                aimChatId:{
	                	required:"Please enter Aim Chat Id",
	                   	email:jQuery.format("Not a valid Aim Chat Id")
	              	},
	                appleId: {
	                   	required:"Please enter Apple Id",
                    	email:jQuery.format("Not a valid Apple Id")
	               	}
	                },
	                submitHandler: function(form) {
	                    form.submit();
	                }
	            });
	            $( "#datepicker" ).datepicker();

		    });

	
</script>
</head>

<body onload="document.getElementById('employeeName').focus();">
	<jsp:include page="/WEB-INF/Includes/Header.jsp" />
  <jsp:include page="/WEB-INF/Includes/Tab.jsp" />
  	
	<center><form  action="employeeEntry.htm" method="post"  id="register-form" novalidate="novalidate">
	<h3>Employee Registration</h3>
		<div id="form-content">
		        <fieldset>
		          <div class="fieldgroup">
               		 <label for="employeeName">Name</label>
               		 <input type="text" name="employeeName">
           		 </div>
           		   <div class="fieldgroup">
               		 <label for="employeeId">ID</label>
               		 <input type="text" name="employeeId">
           		 </div>
           		   <div class="fieldgroup">
               		 <label for="businessUnit">Business Unit</label>
               		 <input type="text" name="businessUnit">
           		 </div>
           		   <div class="fieldgroup">
               		 <label for="status">Status</label>
               		 <input type="text" name="status">
           		 </div>
           		   <div class="fieldgroup">
               		 <label for="contactNumber">Contact Number</label>
               		 <input type="text" name="contactNumber">
           		 </div>
           		   <div class="fieldgroup">
               		 <label for="aimId">Aim Mail Id</label>
               		 <input type="text" name="aimId">
           		 </div>
           		   <div class="fieldgroup">
               		 <label for="wiproId">Wipro Mail Id</label>
               		 <input type="text" name="wiproId">
           		 </div>
           		   <div class="fieldgroup">
               		 <label for="aimChatId">Aim Chat Id</label>
               		 <input type="text" name="aimChatId">
           		 </div>
           		   <div class="fieldgroup">
               		 <label for="appleId">Apple Mail Id</label>
               		 <input type="text" name="appleId">
           		 </div>           		  
           		   <div class="fieldgroup">
               		 <label for="date">Date</label>
               		<p><input type="text" id="datepicker" /></p>         		 
               	</div>
               	 	<div class="fieldgroup">
               	    <input type="submit" value="Register" class="submit">
           		 </div>
           		 
           		 
				</fieldset>

			</div>
	</form></center>
</body>
</html>