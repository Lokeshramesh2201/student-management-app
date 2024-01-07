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

@WebServlet("/Delete")
public class Delete extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		StudentJdbc sj = new StudentJdbc();
		int rollNo = Integer.parseInt(req.getParameter("rollNo"));
		if(session != null && session.getAttribute("Email") != null && session.getAttribute("Password") != null)
		{
			try {
				int result = sj.deleteStudentData(rollNo);
				if(result == 1)
				{
					req.setAttribute("message", "Student Data Deleted Successfully");
					req.setAttribute("AllStudents", sj.retriveAllStudentRecord());
					RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Student Data Not Delete ");
					req.setAttribute("AllStudents", sj.retriveAllStudentRecord());
					RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
					dispatcher.include(req, resp);
				}
			} catch (ClassNotFoundException | SQLException e) {
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
