package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;

/**
 * Servlet implementation class ConfirmServlet
 */
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyCartDao mcd = (MyCartDao) request.getSession().getAttribute("mycart");
		ArrayList<AlbumBean> albumList = mcd.getAlbumCart();
		ArrayList<SongBean> songList = mcd.getSongCart();
		UserBean ub = mcd.getUser();
		String mailAddress = ub.getEmail();
		float alPrice = mcd.getAllPrice();
		String content = "";

		content += "<html>";
		content += "<head>";
		content += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />";
		content += "<title>无标题文档</title>";
		content += "<style type=\"text/css\">";
		content += "<!--";
		content += ".STYLE1 {";
		content += "font-size: 18px;";
		content += "font-weight: bold;";
		content += "font-style: italic;";
		content += "	color: #0000FF;";
		content += "}";
		content += ".STYLE2 {font-weight: bold; font-size: 16px;}";
		content += ".STYLE4 {font-weight: bold; font-size: 24px; color: #FF0000; }";
		content += ".STYLE5 {";
		content += "color: #0000FF;" + "";
		content += "	font-weight: bold;";
		content += "}";
		content += ".STYLE6 {color: #0000FF}";
		content += "-->";
		content += "</style>";
		content += "</head>";

		content += "<body>";
		content += "<h1>Dear " + ub.getName() + ", this is your order: </h1>";
		content += "<table width=\"800\" border=\"0.5\" align=\"left\">";
		content += "<tr>";
		content += "<td colspan=\"2\"><span class=\"STYLE1\">You have ordered the following goods: </span></td>";
		content += "</tr>";
		content += "<tr>";
		content += "<td colspan=\"2\" class=\"STYLE2\">Album</td>";
		content += "</tr>";
		content += "<tr>";
		content += "<td colspan=\"2\"><table width=\"100%\" border=\"0\">";
		content += " <tr>";
		content += "<td width=\"49%\"><span class=\"STYLE5\">Title</span></td>";
		content += " <td width=\"25%\"><span class=\"STYLE5\">Artist</span></td>";
		content += "<td width=\"15%\"><span class=\"STYLE5\">Price</span></td>";
		content += "</tr>";

		for (int i = 0; i < albumList.size(); i++) {

			AlbumBean ab = albumList.get(i);
			content += "<tr>";
			content += " <td>" + ab.getTitle() + " </a></td>";
			content += " <td>" + ab.getAlbumArtist() + " </td>";
			content += " <td>$" + ab.getPrice() + "</td>";
			content += " </tr>";

		}
		content += " </table></td>";
		content += " </tr>";
		content += " <tr>";
		content += "<td colspan\"2\" class=\"STYLE2\">Song</td>";
		content += "</tr>";
		content += "<tr>";
		content += "<td colspan=\"2\"><table width=\"100%\" border=\"0\">";
		content += "<tr>";
		content += " <td width=\"27%\"><span class=\"STYLE6\"><strong>Title</strong></span></td>";
		content += "	<td width=\"22%\"><span class=\"STYLE6\"><strong>Album</strong></span></td>";
		content += "      <td width=\"25%\"><span class=\"STYLE6\"><strong>Artist</strong></span></td>";
		content += "      <td width=\"15%\"><span class=\"STYLE6\"><strong>Price</strong></span></td>";
		content += "  </tr>";

		for (int i = 0; i < songList.size(); i++) {
			SongBean sb = songList.get(i);
			content += "	<tr>";
			content += "   <td>" + sb.getTitle() + "</td>";
			content += " <td>" + sb.getAlbumTitle() + "</td>";
			content += "<td>" + sb.getArtist() + "</td>";
			content += "<td>$" + sb.getPrice() + "</td>";

			content += "</tr>";
		}
		content += "</table><span class=\"STYLE1\">Totla Price: $" + mcd.getAllPrice()+"</span>";

		content += "<p>&nbsp;</p>";
		content += "<p>&nbsp;</p>";

		content += "<p>This is your information:</p>";
		content += "<p>Name: "+ub.getName()+"</p>";
		content += "<p>Phone Number:"+ub.getPhoneNumber()+"</p>";
		content += "<p>Adress:"+ub.getAddress()+"</p>";
		content += "<p>Country:"+ub.getCountry()+"</p>";
		content += "<p>Postcode:"+ub.getPostcode()+" </p>";

		content += "</body></html>";
		Mail mail = new Mail();
		mail.setSendTo(mailAddress);
		mail.setContent(content);
		//mail.send();
		//mail.sendMailTLS();
		Boolean sendStatus = mail.send();
		if(sendStatus){
			request.setAttribute("email", mailAddress);
			request.getRequestDispatcher("confirmation.jsp").forward(request,
					response);
		}else{
			request.getRequestDispatcher("emailerror.jsp").forward(request,
					response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
