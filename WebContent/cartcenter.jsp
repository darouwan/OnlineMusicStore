<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.model.*,java.math.BigDecimal;"%>
    <%
    MyCartDao mcd =(MyCartDao) request.getSession().getAttribute("mycart");
    if(mcd == null){
    	mcd = new MyCartDao();
    }
    ArrayList<AlbumBean> albumList = mcd.getAlbumCart();
    ArrayList<SongBean> songList = mcd.getSongCart();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
<!--
.STYLE1 {
	font-size: 24px;
	font-weight: bold;
	font-style: italic;
	color: #FFFFFF;
}
.STYLE2 {font-weight: bold; font-size: 16px;}
.STYLE4 {font-weight: bold; font-size: 24px; color: #FFFFFF; }
.STYLE12 {color: #FFFFFF}
.STYLE16 {color: #FFFFFF; font-weight: bold; font-size: 18px; }
-->
</style>

<script type="text/javascript">

	function delAll(){
		
		window.open("cart?type=delAll","_self");
	}
	
/*  	function delSong(songTitle){
		window.open("cart?type=delSong&songTitle="+songTitle,"_self");
		
	}
	
	function delAlbum(albumTitle){
		
		window.open("cart?type=delAlbum&albumTitle="+albumTitle,"_self");
	} 
 */
 	function checkout(){
	 window.open("checkout.jsp","_self");
 }
	function merge(){
		window.open("cart?type=merge","_self");
	}

</script>



</head>
<body>
<table width="100%" border="0" align="right">
  <tr>
    <td colspan="2" bgcolor="#FF6600"><span class="STYLE1">You have ordered the following goods: </span></td>
  </tr>
  <tr>
    <td colspan="2" class="STYLE2">Album</td>
  </tr>
  <tr>
    <td colspan="2"><table width="100%" border="0">
      <tr bgcolor="#FF6600">
        <td width="49%"><span class="STYLE12">Title</span></td>
        <td width="25%"><span class="STYLE12">Artist</span></td>
        <td width="15%"><span class="STYLE12">Price</span></td>
        <td width="11%"><span class="STYLE12"></span></td>
      </tr>
      
      <%
      for(int i=0;i<albumList.size();i++){
    	  
    	  AlbumBean ab = albumList.get(i);
    	  %>
    	<tr>
	        <td><a href="ShowAlbum?title=<%=ab.getTitle() %>"><%=ab.getTitle() %></a></td>
	        <td><%=ab.getAlbumArtist() %></td>
	        <td>$<%=ab.getPrice() %></td>
	        <td><a href="cart?type=delAlbum&albumTitle=<%=ab.getTitle() %>">Remove</a></td>
     	 </tr>
    	  
    	  <%
      }
      
      %>
<!--       <tr>
        <td><a href="http://localhost:8080/OnlineMusicStore/showDetail?title=Recovery">Recovery</a></td>
        <td>Eminem</td>
        <td>$9.99</td>
        <td>Remove</td>
      </tr> -->
      
      
    </table></td>
  </tr>
  <tr>
    <td colspan="2" class="STYLE2">Song</td>
  </tr>
  <tr>
    <td colspan="2"><table width="100%" border="0">
      <tr bgcolor="#FF6600">
        <td width="27%"><span class="STYLE12"><strong>Title</strong></span></td>
        <td width="22%"><span class="STYLE12"><strong>Album</strong></span></td>
        <td width="25%"><span class="STYLE12"><strong>Artist</strong></span></td>
        <td width="15%"><span class="STYLE12"><strong>Price</strong></span></td>
        <td width="11%"><span class="STYLE12"></span></td>
      </tr>
      <%
      for(int i=0;i<songList.size();i++){
    	  SongBean sb = songList.get(i);
    	  
    	  %>
    	  
    	<tr>
        <td><%=sb.getTitle() %></td>
        <td><a href="ShowAlbum?title=<%=sb.getAlbumTitle() %>"><%=sb.getAlbumTitle() %></a></td>
        <td><%=sb.getArtist() %></td>
        <td>$<%=sb.getPrice() %></td>
        <td><a href="cart?type=delSong&songTitle=<%=sb.getTitle() %>">Remove</a></td>
      </tr>
    	  <%
    	  
    	  
      }
      
      %>
      
<!--       <tr>
        <td>Love Story</td>
        <td>Fearless</td>
        <td>Taylor Swift</td>
        <td>$0.99</td>
        <td>Remove</td>
      </tr> -->
      
      
      
    </table></td>
  </tr>
  <tr>

    <td colspan="2" align="right" bgcolor="#0066CC"><span class="STYLE4">Total Price:$<%=mcd.getAllPrice() %> </span></td>
  </tr>
  <tr>
    <td><label>
      <input onclick="delAll();" type="button" name="clear" value="Clear All" />
    </label><label>
      <input onclick="merge();" type="button" name="merge" value="Merge" title="Merge duplicate songs and albums"/>
    </label></td>
    
    <td align="right">
      <label>
      <input onclick="checkout()" type="submit" name="Submit2" value="Check out" />
      </label>    </td>
  </tr>
</table>
</body>
</html>