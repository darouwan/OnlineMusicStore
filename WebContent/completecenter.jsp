<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.model.*,java.math.BigDecimal;"%>
    
    <%
    MyCartDao mcd =(MyCartDao) request.getSession().getAttribute("mycart");
    if(mcd ==null){
    	System.out.print("cart is empty");
    	mcd = new MyCartDao();
    }else{
        System.out.print("cart is fine");
    }

    UserBean ub = mcd.getUser();
    ArrayList<AlbumBean> albumList = mcd.getAlbumCart();
    ArrayList<SongBean> songList = mcd.getSongCart();
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complete</title>

<style type="text/css">
<!--
.STYLE1 {
	color: #0000FF;
	font-size: 24px;
	font-weight: bold;
}
.STYLE3 {
	font-size: 18px;
	font-weight: bold;
	font-style: italic;
	color: #0000FF;
}
.STYLE4 {font-weight: bold; font-size: 24px; color: #FFFFFF; }
.STYLE5 {
	color: #0000FF;
	font-weight: bold;
}
.STYLE6 {color: #0000FF}
.STYLE2 {font-size: 16px}
.STYLE16 {color: #FFFFFF; font-weight: bold; font-size: 18px; }
.STYLE12 {color: #FFFFFF; font-size: 18; font-weight: bold; }
.STYLE14 {
	color: #0000CC;
	font-size: 24px;
	font-weight: bold;
}
-->
</style>


<script type="text/javascript">

	function confirm(){
		
		window.open("Confirm","_self");
	}

</script>


</head>
<body>
<table width="100%" border="0">
  <tr>
    <td width="78%" class="STYLE3">Album</td>
    <td width="22%" rowspan="4" class="STYLE2"><table width="100%" border="0">
      <tr>
        <td><span class="STYLE14">Totol Price:$ <%=mcd.getAllPrice() %> </span></td>
      </tr>
      <tr>
        <td><label>
          <input onclick="confirm()" type="submit" name="Submit" value="Complete Purchase" />
        </label></td>
      </tr>
      <tr bgcolor="#0066CC">
        <td><table width="100%" border="0">
          <tr>
            <td><span class="STYLE12">Name:<%=ub.getName() %></span></span></td>
          </tr>
          <tr>
            <td><span class="STYLE12">Phone Number:<%=ub.getPhoneNumber() %> </span></td>
          </tr>
          <tr>
            <td><span class="STYLE12">Adress:<%=ub.getAddress() %></span></td>
          </tr>
          <tr>
            <td><span class="STYLE12">Country:<%=ub.getCountry() %></span></td>
          </tr>
          <tr>
            <td><span class="STYLE12">Email:<%=ub.getEmail() %></span></td>
          </tr>
          <tr>
            <td><span class="STYLE12">Postcode:<%=ub.getPostcode() %></span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0">
        <tr bgcolor="#FF6600">
          <td width="49%" ><span class="STYLE16">Title</span></td>
          <td width="25%"><span class="STYLE16">Artist</span></td>
          <td width="15%"><span class="STYLE16">Price</span></td>
        </tr>
        <%
        for(int i = 0;i<albumList.size();i++){
        	AlbumBean ab = albumList.get(i);
        	%>
        	
        <tr>
          <td><%=ab.getTitle() %></td>
          <td><%=ab.getAlbumArtist() %></td>
          <td>$<%=ab.getPrice() %></td>
        </tr>
        	
        	<% 
        }
        %>
        
        
        
 <!--        <tr>
          <td><a href="http://localhost:8080/OnlineMusicStore/showDetail?title=Recovery">Recovery</a></td>
          <td>Eminem</td>
          <td>$9.99</td>
        </tr> -->
    </table></td>
  </tr>
  <tr>
    <td class="STYLE3">Song</td>
  </tr>
  <tr >
    <td><table width="100%" height="100%" border="0">
        <tr bgcolor="#FF6600">
          <td width="27%"><span class="STYLE16"><strong>Title</strong></span></td>
          <td width="22%"><span class="STYLE16"><strong>Album</strong></span></td>
          <td width="25%"><span class="STYLE16"><strong>Artist</strong></span></td>
          <td width="15%"><span class="STYLE16"><strong>Price</strong></span></td>
        </tr>
         <%
        for(int i = 0;i<songList.size();i++){
        	SongBean sb = songList.get(i);
        	%>
        	
        <tr>
          <td><%=sb.getTitle() %></td>
          <td><%=sb.getAlbumTitle() %></td>
          <td><%=sb.getArtist() %></td>
          <td>$<%=sb.getPrice() %></td>
        </tr>
        	
        	<% 
        }
        %>
        
        
<!--         <tr>
          <td>Love Story</td>
          <td>Fearless</td>
          <td>Taylor Swift</td>
          <td>$0.99</td>
        </tr> -->

        
    </table></td>
  </tr>
</table>


</body>
</html>