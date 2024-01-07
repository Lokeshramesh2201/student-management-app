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

@WebServlet("/LoginSessionCheck")
public class LoginSessionCheck extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		StudentJdbc sj = new StudentJdbc();
		if(session != null && session.getAttribute("Email") != null && session.getAttribute("Password") != null)
		{
			try {
				req.setAttribute("AllStudents", sj.retriveAllStudentRecord());
				RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
				dispatcher.include(req, resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
			dispatcher.include(req, resp);
		}
	}

}
