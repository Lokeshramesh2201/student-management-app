package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentJdbc;
import dto.Student;

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		StudentJdbc sj = new StudentJdbc();
		Student s = new Student();
		
		int rollNo = Integer.parseInt(req.getParameter("inp1"));
		String name = req.getParameter("inp2");
		String std = req.getParameter("inp3");
		String address = req.getParameter("inp4");
		long contact = Long.parseLong(req.getParameter("inp5"));
		
		s.setStudentRollNo(rollNo);
		s.setStudentName(name);
		s.setStudentStd(std);
		s.setStudentAddress(address);
		s.setStudentContact(contact);
		
		if(session != null && session.getAttribute("Email") != null && session.getAttribute("Password") != null)
		{
			try {
				int result = sj.updateStudentData(s);
				if(result == 1)
				{
					req.setAttribute("message", "Student Data Edited Successfully");
					req.setAttribute("AllStudents", sj.retriveAllStudentRecord());
					RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Student Data Not Edited ");
					req.setAttribute("AllStudents", sj.retriveAllStudentRecord());
					RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
					dispatcher.include(req, resp);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			req.setAttribute("message", "LogIn Required");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
			dispatcher.include(req, resp);
		}
	}

}
