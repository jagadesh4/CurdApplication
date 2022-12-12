package com.customer.web.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.web.dao.CustomerDao;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/Login")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username = request.getParameter("username");
		String Password = request.getParameter("userpassword");
		CustomerDao dao =new CustomerDao();
		
		if(dao.checkCustomer(Username,Password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("Username", Username);
			session.setAttribute("Password", Password);
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("Error.jsp");
		}
		
	}

}
