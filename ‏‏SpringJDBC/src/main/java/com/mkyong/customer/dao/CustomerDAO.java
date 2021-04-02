package com.mkyong.customer.dao;

import java.sql.SQLException;
import java.util.List;

import com.bina.customer.model.Customer;


public interface CustomerDAO 
{
	
	public Customer findByCustomerId(int custId);
	public void addColumn(String str);
//	public void addColumnWithTVP();
	public void insert(Customer customer);
	public void insertRows(Customer customer) throws SQLException;
	public List<String> getColumns(Customer customer) throws SQLException;
	
}




