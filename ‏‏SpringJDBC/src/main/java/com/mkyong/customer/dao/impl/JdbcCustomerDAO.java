package com.mkyong.customer.dao.impl;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.bina.customer.model.Customer;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.mkyong.customer.dao.CustomerDAO;
import com.mysql.jdbc.ResultSetMetaData;

public class JdbcCustomerDAO implements CustomerDAO
{
	private static DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private Connection conn;
	private int objectCounter=0;
	private String insertSql;
	static ResultSet rs=null;
	private static java.sql.ResultSetMetaData rsmd;





	public List<String> getColumns(Customer customer) throws SQLException {


		System.out.println("first1");

		//		PreparedStatement stmt=null;
		List<String> columnNames =null;
		PreparedStatement stmt=null;
		//		String qualifiedName = (schemaName!=null&&!schemaName.isEmpty())?(schemaName+"."+tableName):tableName;
		try{
			conn = dataSource.getConnection();

			System.out.println("first2");

			System.out.println("first3");

			conn = dataSource.getConnection();
			stmt=conn.prepareStatement("select * from customer where 0=1");
			rs=stmt.executeQuery();//you'll get an empty ResultSet but you'll still get the metadata
			rsmd=rs.getMetaData();

			columnNames = new ArrayList<String>(); 
			for(int i=1;i<=rsmd.getColumnCount();i++)
				columnNames.add(rsmd.getColumnLabel(i));    
		}catch(SQLException e){
			throw e;//or log it
		}
		finally{
			//if(rs!=null)
			//if(stmt!=null)
		}
		return columnNames;
	}


	public void setDataSource(DataSource dataSource) {
		//	this.dataSource = dataSource;

		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);


	}

	public void insertRows(Customer customer) throws SQLException
	{
		List<Object> data = new ArrayList<>();
		data.add(2);
		data.add("bbb");
		data.add(333);
		data.add("ddd");
		data.add("eee");
		data.add("ff");
		data.add("GG");
		data.add("HH");
		data.add("II");
		data.add("jj");
		

		List<String> columnNames = getColumns(customer);
		System.out.println(columnNames);

		String insertColumns = ""; 
		String insertValues = "";

		if(columnNames != null && columnNames.size() > 0){
			insertColumns += columnNames.get(0);
			insertValues += "?,";
		}


		for(int i = 1; i < columnNames.size();i++){
			insertColumns += ", " + columnNames.get(i) ;
			if (i==columnNames.size()-1)
			{
				insertValues += "?";
			}
			else
			{
				insertValues += "?,";	
			}

		}

		insertSql = "INSERT INTO customer (" + insertColumns + ") values(" + insertValues + ")"; 
		System.out.println(insertColumns);
		System.out.println(insertValues);

		try{
			PreparedStatement pstmt = conn.prepareStatement(insertSql);

			System.out.println("first4");

			//			PreparedStatement pstmt = 
			//					conn.prepareStatement("INSERT INTO Employee (id) values(?)");



			//			PreparedStatement pstmt = 
			//					conn.prepareStatement("INSERT INTO Customer (" + insertColumns + ") values(?,?,?,?,?,?,?)");



			for(Object  o : data){
				System.out.println(o);
				objectCounter+= 1;
				System.out.println("first5");
				pstmt.setObject(objectCounter,o); //you must pass objects of correct type
			}
			System.out.println(pstmt);
			pstmt.execute(); //this inserts your data
		}catch(SQLException sqle){
			System.out.println(sqle);
		}


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
			table.addRow(1,"bdika11");
			table.addRow(2,"bdika12");
			//				table.addRow(3,"bdika15");
			//				table.addRow(4,"bdika16");
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




