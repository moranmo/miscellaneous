package com.mkyong.sp;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public final class Utils {


	public static JdbcTemplate jdbcTemplate;

	public static SimpleJdbcCall simpleJdbcCall;

	// init SimpleJdbcCall

	public static void callStoredProcedure() {
		// o_name and O_NAME, same
//		jdbcTemplate.setResultsMapCaseInsensitive(true);

		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("AddAnEmployee");
		
		 SqlParameterSource in = new MapSqlParameterSource()
	                .addValue("coll", "test");

//	        Optional result = Optional.empty();

	        try {

	            Map out = simpleJdbcCall.execute(in);
	            
	     //       jdbcTemplate.execute(SQL_STORED_PROC_REF);



	        } catch (Exception e) {
	            // ORA-01403: no data found, or any java.sql.SQLException
	            System.err.println(e.getMessage());
	        }

//	        return result;
		
		

	}
	
//	public static void callStoredProcedure2() {
//		
//		
//		
//		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
//		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
//		Map<String, Object> out = jdbcCall.execute(in);
//	}
	
	
	
/*	public static void callStoredProcedureWithList() {
		// o_name and O_NAME, same
//		// Obtain your list of ids to send, this is just an example call to a helper utility function
		int[] employeeIds = new int[] {1, 5};

		DataTable tvp = new DataTable();
		tvp.Columns.Add(new DataColumn("ID", typeof(int)));
		
		
		

		// populate DataTable from your List here
		foreach(var id in employeeIds)
		    tvp.Rows.Add(id);

		using (conn)
		{
		    SqlCommand cmd = new SqlCommand("dbo.DoSomethingWithEmployees", conn);
		    cmd.CommandType = CommandType.StoredProcedure;
		    SqlParameter tvparam = cmd.Parameters.AddWithValue("@List", tvp);
		    // these next lines are important to map the C# DataTable object to the correct SQL User Defined Type
		    tvparam.SqlDbType = SqlDbType.Structured;
		    tvparam.TypeName = "dbo.IDList";
		    // execute query, consume results, etc. here
		}
		
		
		
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("addReportColums");
		
		 SqlParameterSource in = new MapSqlParameterSource()
	                .addValue("test", "col1");

//	        Optional result = Optional.empty();

	        try {

	            Map out = simpleJdbcCall.execute(in);

//	            if (out != null) {
//	                Book book = new Book();
//	                book.setId(id);
//	                book.setName((String) out.get("O_NAME"));
//	                book.setPrice((BigDecimal) out.get("O_PRICE"));
//	                result = Optional.of(book);
//	            }

	        } catch (Exception e) {
	            // ORA-01403: no data found, or any java.sql.SQLException
	            System.err.println(e.getMessage());
	        }

	}*/
}
