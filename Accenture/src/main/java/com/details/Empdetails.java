package com.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.details.DAO.Empdatabase;
import com.details.DTO.Empsetget;

/**
 * Servlet implementation class Empdetails
 */
@WebServlet("/Empdetails")
public class Empdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Empdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		
		
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String ctry=req.getParameter("ctry");
		out.println("Welcome "+name+" your data is saved");
	    RequestDispatcher rd= req.getRequestDispatcher("/Laptop2.html");
		rd.include(req, res);
		
		Empsetget ob1=new Empsetget();
		ob1.setCtry(ctry);
		ob1.setName(name);
		ob1.setPwd(pwd);
		Empdatabase.Emp(ob1);
	
			try {
				Empdatabase.getEmployee();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("<br>");
			out.println("<br>");
			out.println("<a href='Laptop2.html'>Home Screen</a>");
	}

}
