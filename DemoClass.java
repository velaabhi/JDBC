package jdbc;

/*
  Steps 
  1. import package java.sql.*;
  2. load and register the driver - com.mysql.jdbc.Driver
  3. Create Connection
  4. create Statement
  5. execute the Query
  6. Process the Result
  7. close the connection
  
 */
import java.sql.*;
public class DemoClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/abhidb";
		String uname = "root";
		String pswd = "root";
		String query = "select sname from student where rollno = 2;";
		String query1 = "select * from student;";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pswd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String result = rs.getString(1);
		System.out.println("name is "+result);
		
		System.out.println("\n\nPrinting whole table");
		ResultSet rs1 = st.executeQuery(query1);
		while(rs1.next())
		{
			System.out.println("| "+rs1.getInt(1)+" | "+rs1.getString(2));
		}
		
		st.close();
		con.close();
	}

}
