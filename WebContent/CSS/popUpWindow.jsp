<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit File</title>
<link rel="stylesheet" type="text/css" href="style.css" />

<script type="text/javascript" src="../jQuery/jquery-1.7.1.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#btn').click(function () {
            window.opener.location.reload(true);
            window.close();
        });
    });
</script>

</head>
<body>
	<div id="contentwrap">
		<div id="content">
			<div id="content">
					<div style='width: 450px'>
						<table align="center">
							<tr class="odd">
								<td><label style="size: 20px;">ADD ATTACHMENT : </label>
								</td>
								<td><input name="files[0]" type="file" size="60" />
								</td>
							</tr>
							<tr><td></td><td align="center"><input type='button' id='btn' value='Close' /></td></tr>
							
						</table>
					</div>
				</div>
			</div>
		</div>
</body>
</html>