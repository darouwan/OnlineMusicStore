<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>

<style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	color: #009900;
	font-weight: bold;
}
.STYLE2 {font-size: 16px; }
.STYLE3 {font-size: 24px}
.STYLE4 {
	color: #FF0000;
	font-size: 24px;
	font-weight: bold;
}


-->




</style>
<%
String email =(String) request.getAttribute("email");
%>

</head>
<body>
<table width="100%" border="0">
  <tr>
    <td height="92" valign="middle"><p class="STYLE1">Congratulations! </p>
      <p class="STYLE1"><span class="STYLE3">The confirmation letter has been sent to <%=email %></span> <img src="img/checkmark.png" width="34" height="33" /></p></td>
  </tr>
  <tr>
    <td><p class="STYLE1">&nbsp;</p>
    <p class="STYLE2">Don't recieve it? Click <a href="Confirm">here</a> to resend </p></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>