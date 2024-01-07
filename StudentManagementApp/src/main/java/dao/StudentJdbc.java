package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.Student;
public class StudentJdbc 
{
	static Connection db() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///studentmanagement?user=root&password=root");
		return con;
	}
	
	public int insertStudentData(Student s) throws ClassNotFoundException, SQLException
	{
		Connection con = StudentJdbc.db();
		String query = "insert into student values(?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, s.getStudentRollNo());
		pst.setString(2, s.getStudentName());
		pst.setString(3, s.getStudentStd());
		pst.setString(4, s.getStudentAddress());
		pst.setLong(5, s.getStudentContact());
		int result = pst.executeUpdate();
		return result;
	}
	
	public int deleteStudentData(int rollNo) throws ClassNotFoundException, SQLException
	{
		Connection con = StudentJdbc.db();
		String query = "delete from student where rollno = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, rollNo);
		int result = pst.executeUpdate();
		return result;
	}
	
	public int updateStudentData(Student s) throws ClassNotFoundException, SQLException
	{
		Connection con = StudentJdbc.db();
		String query = "update student set name=?, std=?, address=?, contact=? where rollno =?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, s.getStudentName());
		pst.setString(2, s.getStudentStd());
		pst.setString(3, s.getStudentAddress());
		pst.setLong(4, s.getStudentContact());
		pst.setInt(5, s.getStudentRollNo());
		int result = pst.executeUpdate();
		return result;
	}
	
	public Student retriveStudentByRollNo(int rollno) throws ClassNotFoundException, SQLException
	{
		Connection con = StudentJdbc.db();
		String query = "select * from student where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, rollno);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Student s = new Student();
		s.setStudentRollNo(rs.getInt(1));
		s.setStudentName(rs.getString(2));
		s.setStudentStd(rs.getString(3));
		s.setStudentAddress(rs.getString(4));
		s.setStudentContact(rs.getLong(5));
		return s;
	}
	
	public List<Student> retriveAllStudentRecord() throws ClassNotFoundException, SQLException
	{
		Connection con = StudentJdbc.db();
		String query = "select * from student";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		List<Student> data = new ArrayList<Student>();
		while(rs.next())
		{
			Student s = new Student();
			s.setStudentRollNo(rs.getInt(1));
			s.setStudentName(rs.getString(2));
			s.setStudentStd(rs.getString(3));
			s.setStudentAddress(rs.getString(4));
			s.setStudentContact(rs.getLong(5));
			data.add(s);
		}
		return data;
	}
}
