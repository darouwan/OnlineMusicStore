<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<SCRIPT   LANGUAGE="JavaScript">  

function validate(){
	var name=document.getElementById("textfieldName").value;
	var phone=document.getElementById("textfieldPhone").value;
	var address=document.getElementById("textfieldAddress").value;
	var country=document.getElementById("textfieldCountry").value;
	var email=document.getElementById("textfieldEmail").value;
	var postcode=document.getElementById("textfieldPostcode").value;
	if(name==""||phone==""||address==""||country==""||email==""||postcode==""){
		alert("You must input all information");
		return false;
		
	}else{
		return true;
	}
}

</SCRIPT>

</head>
<body>
<form action="Checkout" method="post" onsubmit="return validate()" >
<table width="100%" border="0">
  <tr>
    <td width="19%">&nbsp;</td>
    <td width="49%"><table width="100%" border="0">
      <tr>
        <td width="29%" align="right">Name:</td>
        <td width="71%"><input name="textfieldName" type="text" id="textfieldName" /></td>
      </tr>
      <tr>
        <td align="right">Phone:</td>
        <td><input name="textfieldPhone" type="text" id="textfieldPhone" /></td>
      </tr>
      <tr>
        <td align="right">Address:</td>
        <td><input name="textfieldAddress" type="text" id="textfieldAddress" /></td>
      </tr>
      <tr>
        <td align="right">Country:</td>
        <td><input name="textfieldCountry" type="text" id="textfieldCountry" /></td>
      </tr>
      <tr>
        <td align="right">Email:</td>
        <td><input name="textfieldEmail" type="text" id="textfieldEmail" /></td>
      </tr>
      <tr>
        <td align="right">Postcode:</td>
        <td><input name="textfieldPostcode" type="text" id="textfieldPostcode" /></td>
      </tr>
    </table></td>
    <td width="32%"><label>
      <span class="STYLE4">
      <input  type="submit"  name="Submit" value="Continue"  />
      <br />
      <br />
      <br />  
      <input type="reset" name="Submit2" value="  Clear " />
    </span></label></td>
  </tr>
</table>
	</form>
</body>
</html>