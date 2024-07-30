package com.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.details.DAO.Empdatabase;
import com.details.DTO.Empsetget;

/**
 * Servlet implementation class Editempservlet
 */
@WebServlet("/Editempservlet")
public class Editempservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		out.println("<h1> Update Table Entries</h1>");
		
		
		Empsetget ob3=new Empsetget();
		int EMPId = Integer.parseInt(request.getParameter("ID1"));
		
		
		try {
			ob3=Empdatabase.Editemp(EMPId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String nm=ob3.getName();
		String pw2=ob3.getPwd();
		String cntry2=ob3.getCtry();
		
		
		
		out.print("<form action='Saveeditservlet?ID1="+EMPId+"' method='post'>");

		out.print("<table border='1'>");
	    out.print(" <tr><td>Name</td> <td><input type='text' name='name' value="+nm+"></td></tr>");
		out.print("<tr> <td>Password</td> <td><input type='text' name='pwd' value="+pw2+"></td></tr>");
		out.print("<tr><td>Country</td><td><select name ='ctry'><option value= "+cntry2+">"+cntry2+"</option><option>England</option><option>Russia</option><option>America</option></select></td></tr>");
		
		
		out.print("<tr><td><input type='submit' value='savemp' ></td></tr>");

		out.print("</table>");
		out.print("</form>");
		
		out.println("<br>");
		out.println("<br>");
		out.println("<a href='Laptop2.html'>Home Screen</a>");
		
		
		
	}

	

}
