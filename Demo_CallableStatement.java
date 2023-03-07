package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Demo_CallableStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Connection established");
			
	//1. 1st callable for select * 
			System.out.println("\nShowing table using select stmt procedure");
			String query1 = "call selectStudent;";
	
			CallableStatement callableStatement = connection.prepareCall(query1);	//exe procedure
			ResultSet resultSet = callableStatement.executeQuery();	//to store res into resultset
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			System.out.println(resultSetMetaData.getColumnLabel(1)+"\t"+resultSetMetaData.getColumnName(2)+"\t\t"+resultSetMetaData.getColumnName(3));
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3));
			}
			
		//2. 2nd callable to update value by passing a parameter
			String query2 = "call updateCourse(?);"; 	//? to pass a parameter		
			CallableStatement callableStatement2 = connection.prepareCall(query2);
			
			callableStatement2.setInt(1, 3);	//setting parameter 3 in col no 1
			int count1 = callableStatement2.executeUpdate();
			System.out.println(count1+" Rows affected");
			
			
		//3. again showing all the entries
			CallableStatement callableStatement3 = connection.prepareCall(query1);
			ResultSet resultSet2 = callableStatement3.executeQuery();	//to store res into resultset
			ResultSetMetaData resultSetMetaData2 = resultSet2.getMetaData();
			
			System.out.println(resultSetMetaData2.getColumnLabel(1)+"\t"+resultSetMetaData2.getColumnName(2)+"\t\t"+resultSetMetaData2.getColumnName(3));
			while(resultSet2.next()) {
				System.out.println(resultSet2.getInt(1)+"\t"+resultSet2.getString(2)+"\t\t"+resultSet2.getString(3));
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
