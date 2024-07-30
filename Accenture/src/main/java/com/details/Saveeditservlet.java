package com.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.details.DAO.Empdatabase;
import com.details.DTO.Empsetget;

/**
 * Servlet implementation class Saveeditservlet
 */
@WebServlet("/Saveeditservlet")
public class Saveeditservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		out.println("<h1> Update is Saved</h1>");
//		 RequestDispatcher rd= req.getRequestDispatcher("Viewservlet");
//			rd.include(req, res);
			int EMPId = Integer.parseInt(req.getParameter("ID1"));
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			String ctry=req.getParameter("ctry");
			
			Empsetget ob1=new Empsetget();
			ob1.setCtry(ctry);
			ob1.setName(name);
			ob1.setPwd(pwd);
			ob1.setID(EMPId);
			try {
				Empdatabase.Empupdateentry(ob1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.println("<h1>Employee List</h1>");
			try {
				List<Empsetget> l1=Empdatabase.getEmployee();
				
				out.print("<table border ='1' width''100%'>");
				out.print("<tr><th>ID</th>  <th> Name </th>  <th> password </th>  <th> country </th> <th>Edit</th></th><th>Delete</th>");
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
			out.println("<a href='Laptop2.html'>Home Screen</a>");
			
	}
	
	

}
