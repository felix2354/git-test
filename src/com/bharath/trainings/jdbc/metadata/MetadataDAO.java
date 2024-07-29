package com.bharath.trainings.jdbc.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetadataDAO {

	public static void main(String[] args)   {
		try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root"); ) {
			Statement stmt = conn.createStatement();
			ResultSet resultset = stmt.executeQuery("select * from account");
			ResultSetMetaData resultSetMetaData = resultset.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int i=1;i<=columnCount;i++) {
				System.out.println(resultSetMetaData.getColumnName(i));
				System.out.println(resultSetMetaData.getColumnType(i));
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
