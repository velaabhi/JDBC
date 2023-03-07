package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo_ResultMetaData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver loaded ");

				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
						"root","root"); 
				System.out.println("Connetion estd ");
				String query = "select * from employees";
				Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery(query);	//ResultSet stores data/table in java
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();	//to  get meta data 
				int choice;
				Scanner scanner = new Scanner(System.in);
				do 
				{
					System.out.println("\n\nPlease select Meta Data you want to view ");
					System.out.println("1.Table name \n2. Nos of Cols \n3.Labels of Cols \n4.Datatypes of col ");
					choice = scanner.nextInt();
					
						switch(choice)
						{
							case 1 : 	System.out.println("Table name is "+resultSetMetaData.getTableName(1)); 		//table name
										break;
							
							case 2 :	 System.out.println("No of columns is "+resultSetMetaData.getColumnCount());		//no of cols
										break;
										
							case 3 :	System.out.println("Label of column 1  is "+resultSetMetaData.getColumnLabel(1));		//labels of cols
										System.out.println("Label of column 2 is "+resultSetMetaData.getColumnLabel(2));
										System.out.println("Label of column 3 is "+resultSetMetaData.getColumnLabel(3));
										System.out.println("Label of column 4 is "+resultSetMetaData.getColumnLabel(4));
										System.out.println("Label of column 5 is "+resultSetMetaData.getColumnLabel(5));
										System.out.println("Label of column 6 is "+resultSetMetaData.getColumnLabel(6));
										break;
										
							case 4 :	System.out.println("Type of col 1 is "+resultSetMetaData.getColumnTypeName(1));	//datatype of cols
										System.out.println("Type of col 2 is "+resultSetMetaData.getColumnTypeName(2));
										System.out.println("Type of col 3 is "+resultSetMetaData.getColumnTypeName(3));
										System.out.println("Type of col 4 is "+resultSetMetaData.getColumnTypeName(4));
										System.out.println("Type of col 5 is "+resultSetMetaData.getColumnTypeName(5));
										System.out.println("Type of col 6 is "+resultSetMetaData.getColumnTypeName(6));
										break;
										
							default : System.out.println("Invalid choice");
							}
				}while(choice<5);
				System.out.println("End of prog ");	//schema name
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
