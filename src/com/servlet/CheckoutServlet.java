package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MyCartDao;
import com.model.UserBean;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("textfieldName");
		String phoneNumber = request.getParameter("textfieldPhone");
		String address = request.getParameter("textfieldAddress");
		String country = request.getParameter("textfieldCountry");
		String email = request.getParameter("textfieldEmail");
		String postCode = request.getParameter("textfieldPostcode");
		UserBean ub = new UserBean();
		ub.setName(name);
		ub.setPhoneNumber(phoneNumber);
		ub.setAddress(address);
		ub.setCountry(country);
		ub.setEmail(email);
		ub.setPostcode(postCode);
		System.out.println(name);
		System.out.println(phoneNumber);
		System.out.println(address);
		System.out.println(country);
		System.out.println(email);
		System.out.println(postCode);
		
		
		HttpSession hs = request.getSession();
		MyCartDao mcd;
		mcd =(MyCartDao) hs.getAttribute("mycart");
		if(mcd==null){
			//cart is not existed in session
			System.out.println("Cart Error");
		}else{
			//cart is existed in session
			System.out.println("Cart right");
			mcd.setUser(ub);

		}
		hs.setAttribute("mycart", mcd);
		request.getRequestDispatcher("complete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
