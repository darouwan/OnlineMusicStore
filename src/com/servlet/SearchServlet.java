package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.model.*;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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
		String attribute = request.getParameter("attribute");
		String searchContent = request.getParameter("searchcontent");
		String sPageNow =request.getParameter("pageNow") ;
		if(sPageNow == null){
			sPageNow = "1";
		}
		int pageNow = Integer.parseInt(sPageNow);
		
		String type = request.getParameter("type");
		AlbumBeanDao abd = new AlbumBeanDao();
		SongBeanDao sbd = new SongBeanDao();
		ArrayList<AlbumBean> al = new ArrayList<AlbumBean>();
		ArrayList<SongBean> al2 = new ArrayList<SongBean>();

		try {
			if (type.equals("0")) {
				// search album
				if (attribute.equals("0")) {
					// search by Artist

					al = abd.searchByArtist(searchContent);
					
					//request.getRequestDispatcher("main.jsp").forward(request, response);
				} else if (attribute.equals("1")) {
					
					// search by Genre
					al = abd.searchByGenre(searchContent);
					//request.getRequestDispatcher("main.jsp").forward(request, response);
				} else if (attribute.equals("2")) {
					// search by Year
					al = abd.searchByYear(searchContent);
					//request.getRequestDispatcher("main.jsp").forward(request, response);
				} else if (attribute.equals("3")) {
					//search by title
					al = abd.searchByTitle(searchContent);
				}

				request.setAttribute("albumList", al);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else if(type.equals("1")){
				if (attribute.equals("0")) {
					// search by Artist

					al2 = sbd.searchByArtist(searchContent);
					
					//request.getRequestDispatcher("main.jsp").forward(request, response);
				} else if (attribute.equals("1")) {
					
					// search by Genre
					al2 = sbd.searchByGenre(searchContent);
					//request.getRequestDispatcher("main.jsp").forward(request, response);
				} else if (attribute.equals("2")) {
					// search by Year
					al2 = sbd.searchByYear(searchContent);
					//request.getRequestDispatcher("main.jsp").forward(request, response);
				} else if (attribute.equals("3")) {
					//search by title
					al2 = sbd.searchByTitle(searchContent);
				}
				Paging page = new Paging();
				int pageCount = page.getPageCount(10, al2.size());
				al2 = page.getGoodsByPage(al2, 10, pageNow);
				
				request.setAttribute("pageNow", pageNow+"");
				request.setAttribute("pageCount", pageCount+"");
				
				request.setAttribute("songList", al2);
				
				request.setAttribute("attribute", attribute);
				request.setAttribute("searchcontent", searchContent);
				request.setAttribute("type", type);
				
				request.getRequestDispatcher("result.jsp").forward(request, response);
			}
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
