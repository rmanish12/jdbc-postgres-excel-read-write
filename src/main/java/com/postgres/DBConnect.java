package com.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	private static final String DRIVER_CLASS = "org.postgresql.Driver";
	
	//jdbc:postgresql://localhost:5432/[DATABASE_NAME]
	private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "abcd1234";
	
	Connection conn = null;
	Statement stmt = null;
	
	void writeToDB(String name, int maths, int science, int english) {
		try {
			
			//register driver
			Class.forName(DRIVER_CLASS);
			
			//create connection
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			
			//create statement
			stmt = conn.createStatement();
				
			//insert statement
			String sql = "insert into marks(name, maths, science, english) values('" + name + "'," + maths + "," + science + "," + english + ");";
			stmt.executeUpdate(sql);
			
			//select statement

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("Data successfully inserted");
	}
	
	void readFromDB() {
		WriteExcel w = new WriteExcel();
		WriteExcel.createSheet();
		
		try {
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			
			String sql = "select * from marks;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
				w.writeExcelFile(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			}
			
			WriteExcel.doneWriting();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
