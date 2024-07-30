package com.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.details.DAO.Empdatabase;

/**
 * Servlet implementation class Deleteservlet
 */
@WebServlet("/Deleteservlet")
public class Deleteservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		out.println("<h1> Record deleted</h1>");
		int EMPId = Integer.parseInt(req.getParameter("ID"));
		
		
		
			try {
				Empdatabase.Empdeleteentry(EMPId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("<br>");
			out.println("<br>");
			out.println("<a href='Laptop2.html'>Home Screen</a>");
			
			 RequestDispatcher rd= req.getRequestDispatcher("/Viewservlet");
				rd.forward(req, res);
				

}
}
