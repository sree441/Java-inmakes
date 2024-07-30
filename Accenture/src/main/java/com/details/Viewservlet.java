package com.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.details.DAO.Empdatabase;
import com.details.DTO.Empsetget;

/**
 * Servlet implementation class Viewservlet
 */
@WebServlet("/Viewservlet")
public class Viewservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
	
		out.println("<a href='Laptop2.html'>Add new Employee</a>");
		out.println("<h1>Employee List</h1>");
		try {
			List<Empsetget> l1=Empdatabase.getEmployee();
			
			out.print("<table border ='1' width''100%'>");
			out.print("<tr><th>ID</th>  <th> Name </th>  <th> password </th>  <th> country </th> <th>Edit</th><th>Delete</th>");
			for(Empsetget g:l1)
			{
			
				out.print("<tr><td> "+g.getID()+"</td><td> "+g.getName()+"</td><td> "+g.getPwd()+"</td><td> "+g.getCtry()+" </td><td><a href='Editempservlet?ID1="+g.getID()+"'>Edit</a></td>"+"<td><a href='Deleteservlet?ID="+g.getID()+"'>Delete</a></td></tr>");
				
			}
			out.print("</table>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<a href='Laptop2.html'>Home Screen</a>");
	
	}
	
	

}
