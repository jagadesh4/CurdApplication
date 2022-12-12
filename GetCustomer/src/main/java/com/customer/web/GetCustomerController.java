package com.customer.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.web.dao.CustomerDao;
import com.customer.web.model.Customer;

/**
 * Servlet implementation class GetCustomerController
 */
@SuppressWarnings("serial")
@WebServlet("/")
public class GetCustomerController extends HttpServlet 
{
	
	private CustomerDao CustomerDAO;
	
	
	public void init() 
	{
		CustomerDAO = new CustomerDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { int i =
	 * Integer.parseInt(request.getParameter("aid")); CustomerDao daocust =new
	 * CustomerDao(); List<Customer> obj = daocust.getCustomer(i);
	 * request.setAttribute("customer", obj); RequestDispatcher rd =
	 * request.getRequestDispatcher("ShowCustomer.jsp"); rd.forward(request,
	 * response); }
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateCustomer(request, response);
				break;
			case "/delete":
				deleteCustomer(request, response);
				break;
			case "/insert":
				insertCustomer(request, response);
				break;
			default:
				listCustomer(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Customer> listCustomer = CustomerDAO.selectAllUsers();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowCustomer.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer existingCustomer = CustomerDAO.selectCustomer(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowCustomer.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);

	}
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		if (request.getParameter("Back") == null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String customerpincode = request.getParameter("customerpincode");
			Customer customer = new Customer(id, name, age,customerpincode);
			CustomerDAO.updateCustomer(customer);
		}
		response.sendRedirect("list");
	}
	
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		if (request.getParameter("Back") == null)
		{
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String customerpincode = request.getParameter("customerpincode");
			Customer customer = new Customer(name, age,customerpincode);
			CustomerDAO.insertCustomer(customer);
		}
		response.sendRedirect("list");
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerDAO.deleteCustomer(id);
		response.sendRedirect("list");
	}
	

}
