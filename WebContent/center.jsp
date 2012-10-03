<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.model.*"%>

<%
	AlbumBeanDao abd = new AlbumBeanDao();
	ArrayList al = (ArrayList)request.getAttribute("albumList");
	if(al==null){
		al = abd.getAllAlbum();
	}
	int size = al.size();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/abc.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form action="cart?type=addAlbum" method="post">
	<table width="100%" border="0" class="abc">

		<%
			int index = 0;
			for (int i = 0; i < 4; i++) {
		%>
		<tr>

			<%
				for (int j = 0; j < 3; j++) {
						index = i * 3 + j;
						if (index < size) {
							AlbumBean ab = (AlbumBean)al.get(index);
			%>
			<td width="26%"><table width="100%" border="0">
					<tr>
						<%
							System.out.println(ab.getImg());
						%>
						<td width="27%" rowspan="6"><img src=<%=ab.getImg()%>
							width="200" height="200" /></td>
						<td width="73%"><strong>Title</strong>:<a href="ShowAlbum?title=<%= ab.getTitle() %>"><%=ab.getTitle()%></a></td>
					</tr>
					<tr>
						<td><strong>Artist</strong>: <%=ab.getAlbumArtist()%></td>
					</tr>
					<tr>
						<td><strong>Genre</strong>: <%=ab.getGenre()%></td>
					</tr>
					<tr>
						<td><strong>Publisher</strong>: <%=ab.getPublisher()%></td>
					</tr>
					<tr>
						<td><strong>Year</strong>:<%=ab.getYear()%></td>
					</tr>
					<tr>
						<td><strong>Price</strong>:$<%=ab.getPrice()%></td>
					</tr>
					<tr>
						<td><label> <input type="checkbox" name="albumcheckbox"
								value="<%=ab.getTitle() %>" /> Select to Buy</label>
						</td>
					</tr>
				</table></td>

			<%
				}
					}
			%>
		</tr>
		<%
			}
		%>


  <tr align="right">
    <td colspan="4" align="right"><label>

      <input type="submit" name="Submit" value="Buy and Go to Cart" />
    </label></td>
  </tr>

	</table>

</form>


</body>
</html>