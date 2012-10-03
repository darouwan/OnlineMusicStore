<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.model.*"%>

<%
	ArrayList al = (ArrayList) request.getAttribute("songList");
	int pageCount = 1;
	String sPageCount = (String) request.getAttribute("pageCount");
	if (sPageCount != null) {
		pageCount = Integer.parseInt(sPageCount);
	}

	String attribute = (String) request.getAttribute("attribute");
	String searchContent = (String) request
			.getAttribute("searchcontent");
	String type = (String) request.getAttribute("type");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="cart?type=addSong" method="post">
		<table width="100%" border="0">


			<tr>
				<td width="47%">Title</td>
				<td width="15%">Artist</td>
				<td width="17%">Album</td>
				<td width="10%">Price</td>
				<td width="11%">Buy it?</td>
			</tr>

			<%
				for (int i = 0; i < al.size(); i++) {
					SongBean sb = (SongBean) al.get(i);
					System.out.println("Result = " + sb.getTitle());
			%>
			<tr>
				<td><%=sb.getTitle()%></td>
				<td><%=sb.getArtist()%></td>
				<td><a href="ShowAlbum?title=<%=sb.getAlbumTitle()%>"><%=sb.getAlbumTitle()%></a>
				</td>
				<td>$<%=sb.getPrice()%></td>
				<td><label> <input type="checkbox" name="songcheckbox"
						value="<%=sb.getTitle()%>" /> Select to Buy</label>
				</td>
			</tr>


			<%
				}
			%>
			<tr align="center">

				<td colspan="4"><label> <%
 	for (int i = 1; i <= pageCount; i++) {
 %> <a
						href="Search?attribute=<%=attribute%>&searchcontent=<%=searchContent%>&type=<%=type%>&pageNow=<%=i%>">[<%=i%>]</a>
						<%
							}
						%> </label></td>


				<td colspan="5" align="right"><label> <input
						type="submit" name="Submit" value="Buy and Go to Cart" /> </label></td>
			</tr>


		</table>
	</form>
</body>
</html>