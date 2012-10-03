<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE4 {font-size: 18px}
.STYLE5 {color: #FFFFFF; font-weight: bold; font-size: 18px; }
-->
</style>
</head>
<body>
	<form id="form1" name="form1" method="get" action="Search">
		<table width="100%" border="0">
			<tr bordercolor="#CC66CC" bgcolor="0066CC">

				<td width="17%" align="right"><label><span class="STYLE5">Search</span> <select name="attribute">
							<option value="0">Artist</option>
							<option value="1">Genre</option>
							<option value="2">Year</option>
							<option	value="3">Title</option>
					</select> </label></td>
				<td width="60%" align="left"><label> <input
						name="searchcontent" type="text" maxlength="20" /> </label> <label> <select
						name="type">
							<option value="0">Album</option>
							<option value="1">Song</option>
					</select> </label> <label></label> <label> <input type="submit"
						name="Submit" value="Go" /> </label></td>
				<td width="23%"><a href="cart?type=showCart"><img src="img/shopppingcart.png" width="36" height="24" border="0" /><span class="STYLE5">Cart</span></a></td>
			</tr>
		</table>
	</form>
</body>
</html>