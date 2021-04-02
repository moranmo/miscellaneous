package com.bina.common;

import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.bina.customer.model.Customer;
import com.bina.sp.Utils;
import com.mkyong.customer.dao.CustomerDAO;
import com.mkyong.customer.dao.impl.JdbcCustomerDAO;


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


//		jdbcCustomerDAO.addColumnWithTVP();


		//		//
				try {
					customerDAO.insertRows(customer);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
