package fr.sofeed.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestPostgres {
	public static void main(String[]args) throws ClassNotFoundException{
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(""
					+ "jdbc:postgresql://localhost:5432/sofeeddb","postgres","root");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from projects");
			while(rs.next()){
				System.out.println(rs);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
