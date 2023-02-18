package jdbc;
import java.sql.*;
public class Demo_InsertRow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/abhidb";
		String uname = "root";
		String pswd = "root";
		
		/*
		 String q1= "insert into student values(4,'Priya');";
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pswd);
		Statement st = con.createStatement();
		int count = st.executeUpdate(q1);
		System.out.println(count + " rows affected");
		
		//another way by passing parameters
		int rollno = 5;
		String sname = "Sneha";
		String q2= "insert into student values("+rollno+",'"+sname+"');";
		int count1 = st.executeUpdate(q2);
		System.out.println(count1 + " rows affected");
		*/
		
		//another way using prepared statement - used when values are coming dynamically
		int rollno = 6;
		String sname= "Neeraj";
		String q2 = "insert into student values(?,?);";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pswd);
		PreparedStatement st = con.prepareStatement(q2);
		st.setInt(1, rollno);	//(col index, value)
		st.setString(2, sname);
		int cnt2 = st.executeUpdate();
		System.out.println(cnt2+" rows affected");
		
		st.close();
		con.close();
	}

}
