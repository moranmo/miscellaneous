package com.mkyong.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.mkyong.customer.dao.CustomerDAO;
import com.mkyong.customer.model.Customer;

public class JdbcCustomerDAO implements CustomerDAO
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		//	this.dataSource = dataSource;

		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);


	}

	public void insert(Customer customer){

		String sql = "INSERT INTO CUSTOMER " +
				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public Customer findByCustomerId(int custId){

		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(
						rs.getInt("CUST_ID"),
						rs.getString("NAME"), 
						rs.getInt("Age")
						);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	public void addColumn(String str) {
		SimpleJdbcCall jdbcCall = new 
				SimpleJdbcCall(dataSource).withProcedureName("addReportColums");

		SqlParameterSource in = new MapSqlParameterSource().addValue("coll", str);
		Map<String, Object> out = jdbcCall.execute(in);

		//		Student student = new Student();
		//		student.setId(id);
		//		student.setName((String) out.get("out_name"));
		//		student.setAge((Integer) out.get("out_age"));
		//		return student;      
	}

	public void addColumnWithTVP() {





		try {
			SQLServerDataTable table = new SQLServerDataTable();


			table.addColumnMetadata("i" ,java.sql.Types.INTEGER);
			table.addColumnMetadata("Name", java.sql.Types.VARCHAR);
			table.addRow(1,"bdika5");
			table.addRow(2,"bdika6");
			table.addRow(3,"bdika7");
			table.addRow(4,"bdika8");
			SimpleJdbcCall jdbcCall = new 
					SimpleJdbcCall(dataSource).withProcedureName("AddColumnsWtihTVP");
			SqlParameterSource in = new MapSqlParameterSource().addValue("ParTempType", table);
			jdbcCall.execute(in);

		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 



	}

}




