package com.customer.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.web.model.Customer;

public class CustomerDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/operations_database";
	private String jdbcUsername = "root";
	private String jdbcPassword = "jaga123";
	
	private static final String UPDATE_USERS_SQL = "update customer set custmername = ?,age= ?, customerpincode =? where id = ?;";
	private static final String INSERT_USERS_SQL = "insert into customer (custmerName,Age, CustomerPinCode) values (?,?,?);";
	private static final String DELETE_USERS_SQL = "delete from customer where id = ?;";
	private static final String CHECK_USER = "select * from login where username = ? and password  = ?;";
	
	//Select List of Customers
	public List<Customer> selectAllUsers()
	{			
		List<Customer> lst =new ArrayList<Customer>();
		try 
		{			
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rslt =  st.executeQuery("select * from customer");			
			while(rslt.next())
			{
				Customer objcust = new Customer();
				objcust.setID(rslt.getInt("ID"));
				objcust.setCustomerName(rslt.getString("CustmerName"));
				objcust.setCustomerPinCode(rslt.getString("CustomerPinCode"));
				objcust.setAge(rslt.getInt("Age"));
				lst.add(objcust);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lst;
	}
	
	//Select Customer
	public Customer selectCustomer(int id)
	{
		Customer objcust = new Customer();
		try 
		{
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rslt =  st.executeQuery(" select * from customer where id ="+id);			
			while(rslt.next())
			{		
				objcust.setID(rslt.getInt("ID"));
				objcust.setCustomerName(rslt.getString("CustmerName"));
				objcust.setCustomerPinCode(rslt.getString("CustomerPinCode"));
				objcust.setAge(rslt.getInt("Age"));
				
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return objcust;
	}
	
	//Update Customer
	public boolean updateCustomer(Customer cust)
	{	
		boolean rowUpdated = false;		
		try 
		{			
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL); 
			statement.setString(1, cust.getCustomerName());
			statement.setInt(2, cust.getAge());
			statement.setString(3, cust.getCustomerPinCode());
			statement.setInt(4, cust.getID());			
			rowUpdated = statement.executeUpdate() > 0;
			return rowUpdated;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	//Insert Customer 
	public boolean insertCustomer(Customer cust)
	{
		boolean rowInserted = false;		
		try 
		{			
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(INSERT_USERS_SQL); 
			statement.setString(1, cust.getCustomerName());
			statement.setInt(2, cust.getAge());
			statement.setString(3, cust.getCustomerPinCode());	
			rowInserted = statement.executeUpdate() > 0;
			return rowInserted;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowInserted;
	}
	
	//Delete Customer
	public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted= false;		
		try 
		{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(DELETE_USERS_SQL); 
			statement.setInt(1, id);			
			rowDeleted = statement.executeUpdate() > 0;
			return rowDeleted;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return rowDeleted;		
	}
	//Login Check
	public boolean checkCustomer(String uname, String password)
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(CHECK_USER); 
			statement.setString(1, uname);
			statement.setString(2, password);
			ResultSet rslt = statement.executeQuery();
			if(rslt.next())
			{
				return true;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		return false;
	}
	//Return Connection object
	public Connection getConnection() throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		try {
			con = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
