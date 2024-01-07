package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherJdbc;
import dto.Teacher;

@WebServlet("/Signup")
public class Signup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("inp1");
		long contact = Integer.parseInt(req.getParameter("inp2"));
		String email = req.getParameter("inp3");
		String password = req.getParameter("inp4");
		
		Teacher t = new Teacher();
		t.setTeacherName(name);
		t.setTeacherContact(contact);
		t.setTeacherEmail(email);
		t.setTeacherPassword(password);
		
		TeacherJdbc tj = new TeacherJdbc();
		
		try {
			int result = tj.signUp(t);
			if(result == 1)
			{
				req.setAttribute("message", "SignUp Successfull");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
