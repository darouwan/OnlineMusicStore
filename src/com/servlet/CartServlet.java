package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MyCartDao;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		MyCartDao mcd;
		HttpSession hs = request.getSession(true);
		hs.setMaxInactiveInterval(60*60*24);
		mcd =(MyCartDao) hs.getAttribute("mycart");
		if(mcd==null){
			mcd = new MyCartDao();
		}
		
		//MyCartDao mcd = new MyCartDao();
		if(type.equals("addAlbum")){
			String [] albums = request.getParameterValues("albumcheckbox");
			System.out.println(albums);
			if(albums!=null){
				for(int i=0;i<albums.length;i++){
					mcd.addAlbum(albums[i]);
				}
			}
		}else if(type.equals("addSong")){
			String [] songs = request.getParameterValues("songcheckbox");
			if(songs!=null){
				for(int i = 0;i<songs.length;i++){
					mcd.addSong(songs[i]);
					mcd.checkDuplicates(songs[i]);
				}
			}

		}else if(type.equals("delAll")){
			mcd.clearCart();
		}else if(type.equals("delSong")){
			String songTitle = request.getParameter("songTitle");
			mcd.delSong(songTitle);
			System.out.println("Removed song = "+songTitle);
		}else if(type.equals("delAlbum")){
			String albumTitle = request.getParameter("albumTitle");
			mcd.delAlbum(albumTitle);
		}else if(type.equals("merge")){
			mcd.mergeCart();
		}
		
		
		hs.setAttribute("mycart", mcd);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
