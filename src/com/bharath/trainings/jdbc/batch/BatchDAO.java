package com.bharath.trainings.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Iterator;

public class BatchDAO {
	public static void main(String[] args)   {
		try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root"); ) {
			Statement stmt = conn.createStatement();
			stmt.addBatch("insert into account values(1,'clinton','bill',10000)");
			stmt.addBatch("insert into account values(2,'clinton','hilary',20000)");
			int[] result = stmt.executeBatch();
			for (int i=0;i<result.length;i++) {
				System.out.println(result[i]);
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
