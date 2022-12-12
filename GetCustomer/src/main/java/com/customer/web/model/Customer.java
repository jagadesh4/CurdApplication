package com.customer.web.model;

public class Customer {
	
	private int ID;
	private String CustomerName;
	private int Age;
	
	public Customer() {
	}
	
	public Customer(String name, int age, String pincode) {
		super();
		this.CustomerName = name;
		this.Age = age;
		this.CustomerPinCode = pincode;
	}

	public Customer(int id, String name, int age, String pincode) {
		super();
		this.ID = id;
		this.CustomerName = name;
		this.Age = age;
		this.CustomerPinCode = pincode;
	}
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return CustomerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return Age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		Age = age;
	}
	/**
	 * @return the customerPinCode
	 */
	public String getCustomerPinCode() {
		return CustomerPinCode;
	}
	/**
	 * @param customerPinCode the customerPinCode to set
	 */
	public void setCustomerPinCode(String customerPinCode) {
		CustomerPinCode = customerPinCode;
	}
	private String CustomerPinCode;
	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", CustomerName=" + CustomerName + ", Age=" + Age + ", CustomerPinCode="
				+ CustomerPinCode + "]";
	}
	

}
