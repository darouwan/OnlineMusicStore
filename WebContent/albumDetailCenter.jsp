<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.model.*"%>

<%
	AlbumBean ab = (AlbumBean) request.getAttribute("albumDetail");
	ArrayList<SongBean> al = ab.getSongsList();
	//ab.setImg();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<!--
.STYLE3 {
	font-size: 16px
}
-->
</style>
</head>
<body>
	<form action="cart?type=addSong" method="post">
		<table width="100%" border="0">
			<tr>
				<td width="22%"><img src=<%=ab.getImg()%> width="280"
					height="280" /></td>
				<td width="78%" valign="top"><p>
						<strong>Title</strong>:<%=ab.getTitle()%></p>
					<p>
						<strong>Artist</strong>:
						<%=ab.getAlbumArtist()%></p>
					<p>
						<strong>Genre</strong>:
						<%=ab.getGenre()%></p>
					<p>
						<strong>Publisher</strong>:
						<%=ab.getPublisher()%></p>
					<p>
						<strong>Year</strong>:<%=ab.getYear()%></p>
					<p>
						<strong>Price</strong>:$<%=ab.getPrice()%></p></td>
			</tr>
			<tr>
				<td colspan="2"><table width="100%" border="0">
						<tr>
							<td width="5%"><strong>No#</strong>
							</td>
							<td width="65%"><strong>Song Title</strong>
							</td>
							<td width="14%"><strong>Artist</strong>
							</td>
							<td width="6%"><strong>Price</strong>
							</td>
							<td width="10%"><strong>Buy it?</strong>
							</td>
						</tr>

						<%
							for (int i = 0; i < al.size(); i++) {
								SongBean sb = al.get(i);
						%>
						<tr>
							<td><%=i + 1%></td>
							<td><%=sb.getTitle()%></td>
							<td><%=sb.getArtist()%></td>
							<td>$<%=sb.getPrice()%></td>
							<td><label> <input type="checkbox"
									name="songcheckbox" value="<%=sb.getTitle()%>" /> Select to
									Buy</label></td>
						</tr>


						<%
							}
						%>



						<!-- 					<tr>
						<td>Fifteen</td>
						<td>Taylor Swift</td>
						<td>0.99</td>
						<td><input type="checkbox" name="checkbox2" value="checkbox" />
							Select to buy</td>
					</tr> -->
					</table></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><label> <input
						type="submit" name="Submit" value="Buy and Go to Cart" /> </label></td>
			</tr>
		</table>
	</form>
</body>
</html>