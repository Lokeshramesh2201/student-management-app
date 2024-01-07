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
import dao.TeacherJdbc;
import dto.Teacher;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		Teacher t = new Teacher();
		TeacherJdbc tj = new TeacherJdbc();
		StudentJdbc sj = new StudentJdbc();
		
		String email = req.getParameter("inp1");
		String password = req.getParameter("inp2");
		
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
			try {
				Teacher data = tj.findByEmail(email);
				
				if(data != null && email.equals(data.getTeacherEmail()))
				{
					if(password.equals(data.getTeacherPassword()))
					{
						session.setAttribute("Email", email);
						session.setAttribute("Password", password);
						req.setAttribute("AllStudents", sj.retriveAllStudentRecord());
						RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
						dispatcher.include(req, resp);
					}
					else
					{
						req.setAttribute("message", "Entered Wrong Password");
						RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
						dispatcher.include(req, resp);
					}
					
				}
				else
				{
					req.setAttribute("message", "Entered Wrong Email");
					RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
					dispatcher.include(req, resp);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
