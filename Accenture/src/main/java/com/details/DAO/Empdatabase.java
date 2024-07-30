package com.details.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.details.DTO.Empsetget;

public class Empdatabase {
	
	static Connection con;
	
//	public static Connection getdbconnection() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String url="jdbc:mysql://localhost:3306/Accenture_emp";
//		con=DriverManager.getConnection(url,"root","Sreedev");
//		return con;
//	}
	public static void Emp(Empsetget e1)
	{
	System.out.println("hai "+ e1.getName());
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Accenture_emp";
		con=DriverManager.getConnection(url,"root","Sreedev");
		PreparedStatement stmt=con.prepareStatement("insert into Acc_emptable(name,password,country) values (?,?,?)");
		stmt.setString(1,e1.getName());
		stmt.setString(2,e1.getPwd());
		stmt.setString(3,e1.getCtry());
		
		
		int i=stmt.executeUpdate();
		if(i>0)
		{
			System.out.println("insertion successful");
			
		}
		else
		{
			System.out.println("insertion NOT successful");
		}
		
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	

}
	public static List<Empsetget> getEmployee() throws SQLException, ClassNotFoundException
	{
		ArrayList<Empsetget> l1=new ArrayList<Empsetget>();
		
		//Connection con=getdbconnection();
		PreparedStatement stmt=con.prepareStatement("select * from Acc_emptable");
		ResultSet rs=stmt.executeQuery();
		while (rs.next())
		{
			Empsetget e2=new Empsetget();	
		
		e2.setID(rs.getInt(1));
		e2.setName(rs.getString(2));
		e2.setPwd(rs.getString(3));
		e2.setCtry(rs.getString(4));
		l1.add(e2);
		
		}
		return l1;
	}
	
	public static Empsetget Editemp(int id) throws SQLException, ClassNotFoundException
	{
		System.out.println("hai_____ "+id);
		
		//Connection con=getdbconnection();
		Empsetget ob2=new Empsetget();	
		PreparedStatement stmt2=con.prepareStatement("select * from Acc_emptable where ID='"+id+"'");           
		ResultSet rs=stmt2.executeQuery();
		rs.next();
		ob2.setID(rs.getInt(1));
		ob2.setName(rs.getString(2));
		ob2.setPwd(rs.getString(3));
		ob2.setCtry(rs.getString(4));
		System.out.println("the name of ob2 ="+ob2.getName());
		return ob2;
	}
	public static void Empupdateentry(Empsetget e4) throws ClassNotFoundException, SQLException
	{
		//Connection con=getdbconnection();
		PreparedStatement stmt=con.prepareStatement("Update Acc_emptable set name=?,password =?,country = ? where ID="+e4.getID());
		stmt.setString(1,e4.getName());
		stmt.setString(2,e4.getPwd());
		stmt.setString(3,e4.getCtry());
		stmt.executeUpdate();
		
}
	public static void Empdeleteentry(int ID) throws ClassNotFoundException, SQLException
	{
		
		//Connection con=getdbconnection();
		PreparedStatement stmt=con.prepareStatement("DELETE FROM Acc_emptable  where ID="+ID);
		stmt.executeUpdate();
		
}
	}
