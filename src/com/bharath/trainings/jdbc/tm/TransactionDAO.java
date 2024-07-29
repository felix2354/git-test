package com.bharath.trainings.jdbc.tm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {
	public static void main(String[] args)   {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			stmt.executeUpdate("update account set bal=bal-500 where accno=2");
			stmt.executeUpdate("update account set bal=bal+500 where accno=1");
			conn.commit();
		} 
		catch(SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
