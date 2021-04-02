package com.bina.customer.model;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.mkyong.customer.dao.CustomerDAO;
import com.mkyong.customer.dao.impl.JdbcCustomerDAO;

public class Customer 
{
	int custId;
	String name;
	int age;
	
	
	public Customer(int custId, String name, int age) {
		this.custId = custId;
		this.name = name;
		this.age = age;
	}
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [age=" + age + ", custId=" + custId + ", name=" + name
				+ "]";
	}
/*  Methods to work with the database **/
	
	/**
	 * Method to save the current user in the database
	 */
//	public void save() throws SQLException{
//		JdbcCustomerDAO.insert(this);
//	}
	
	/**
	 * Method to save the current user in the database
	 */
//	public void delete() throws SQLException{
//		userDAO().delete(this);
//	}
//	
//	
//	/**
//	 * Method to find all users from the database
//	 * @return users all users from the database
//	 */
//	public static List<User> all() throws SQLException {
//		return userDAO().all();
//	}
	
}
