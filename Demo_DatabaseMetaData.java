package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo_DatabaseMetaData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
			System.out.println("Connection established");
			
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println(databaseMetaData.getDatabaseMajorVersion());
			System.out.println(databaseMetaData.getDatabaseMinorVersion());
			System.out.println(databaseMetaData.getDatabaseProductVersion());
			System.out.println(databaseMetaData.getDatabaseProductName());
			System.out.println(databaseMetaData.getDriverName());
			System.out.println(databaseMetaData.getSchemas());
			System.out.println(databaseMetaData.getJDBCMajorVersion());
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
