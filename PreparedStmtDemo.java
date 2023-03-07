package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStmtDemo {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/abhidb","root","root");
			System.out.println("Connection established");
			String queryString= "select sname from student where rollno=6";
			PreparedStatement preparedstatement =  connection.prepareStatement(queryString);
			ResultSet resultSet = preparedstatement.executeQuery();
			
			System.out.println("\nInserting value into db");
			String queryString1 = "insert into student values(?,?);";
			PreparedStatement preparedstatement1 = connection.prepareStatement(queryString1);
			preparedstatement1.setInt(1, 7);
			preparedstatement1.setString(2, "Omkar");
			int count = preparedstatement1.executeUpdate();
			System.out.println(count+"rows affected");
			
			
			
			System.out.println("\nDeleting value from the db");
			String queryString3 = "delete from student where rollno=7;";
			PreparedStatement preparedStatement3 = connection.prepareStatement(queryString3);
			int count2 = preparedStatement3.executeUpdate(); 	//for delete its exeUpdate
			System.out.println(count2+" rows affected");
			
			System.out.println("\nshowing db");
			String queryString2 = "select * from student;";
			PreparedStatement preparedStatement2 = connection.prepareStatement(queryString2);
			ResultSet resultSet1 = preparedStatement2.executeQuery();	//for select its exeQuery
			
			while (resultSet1.next()) {
				System.out.println(resultSet1.getInt(1)+resultSet1.getString(2));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
