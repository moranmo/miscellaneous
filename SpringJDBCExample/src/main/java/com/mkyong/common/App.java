package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.mkyong.customer.dao.CustomerDAO;
import com.mkyong.customer.dao.impl.JdbcCustomerDAO;
import com.mkyong.customer.model.Customer;
import com.mkyong.sp.Utils;

public class App 
{
	public static void main( String[] args )
	{


		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		//        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		//        Customer customer = new Customer(1, "mkyong",28);
		//        customerDAO.insert(customer);
		//    	
		//        Customer customer1 = customerDAO.findByCustomerId(1);
		//        System.out.println(customer1);
		//		Utils.callStoredProcedure();  	

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Customer customer = new Customer(1, "mkyong",28);
		customerDAO.insert(customer);
		Customer customer1 = customerDAO.findByCustomerId(1);
		System.out.println(customer1);

		
		
		JdbcCustomerDAO jdbcCustomerDAO = 
				(JdbcCustomerDAO)context.getBean("JdbcCustomerDAO");
//		jdbcCustomerDAO.addColumn("test4");
		
		
		
	/*	int[] customerIds = {1,5};
		DataTable tvp = new DataTable();
		tvp.Columns.Add(new DataColumn("ID", typeof(int)));
		// populate DataTable from your List here
		foreach(var id in employeeIds)
		      tvp.Rows.Add(id);
		      		      */
		
		jdbcCustomerDAO.addColumnWithTVP();


		
		

	}
}
