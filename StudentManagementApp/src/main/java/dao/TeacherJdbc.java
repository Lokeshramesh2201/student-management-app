package dao;
import java.sql.*;

import dto.Teacher;
public class TeacherJdbc 
{
	static Connection db() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///studentmanagement?user=root&password=root");
		return con;
	}
	
	public int signUp(Teacher t) throws ClassNotFoundException, SQLException
	{
		Connection con = TeacherJdbc.db();
		String query = "insert into teacher values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, t.getTeacherName());
		pst.setString(2, t.getTeacherEmail());
		pst.setString(3, t.getTeacherPassword());
		pst.setLong(4, t.getTeacherContact());
		int result = pst.executeUpdate();
		return result;
	}
	
	public Teacher findByEmail(String email) throws ClassNotFoundException, SQLException
	{
		Connection con = TeacherJdbc.db();
		String query ="select * from teacher where email = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Teacher t = new Teacher();
		t.setTeacherName(rs.getString(1));
		t.setTeacherEmail(rs.getString(2));
		t.setTeacherPassword(rs.getString(3));
		t.setTeacherContact(rs.getLong(4));
		return t;
	}
}
