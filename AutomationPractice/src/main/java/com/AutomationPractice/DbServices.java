package com.AutomationPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbServices {

	public static String abc() {
		StringBuilder st = new StringBuilder();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try {
				Connection conn = DriverManager.getConnection(
						"jdbc:sqlserver://nv-sql-240-02.dev.kingsway.asos.com\\backoffice;integratedSecurity=true;");
				
				Statement stmt = conn.createStatement();
				
				String sql = "select * from AsosBackoffice.dbo.Inventory where SKU='797249'";
				
				ResultSet result = stmt.executeQuery(sql);
				
				while(result.next()){
					st.append(result.getString("StatusID"));
				}
				System.out.println(st);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return st.toString();
	}

	public static void main(String[] args) {

		System.out.println("result: "+abc());
	}
}