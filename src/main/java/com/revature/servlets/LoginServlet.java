package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;



public class LoginServlet extends HttpServlet{
	public static Connection conn = ConnectionFactory.getConnection();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello TM!!!!");
		PrintWriter pw = resp.getWriter();
		pw.write("Hello World from servlet doGet method!!!!!");
		resp.sendRedirect("firstPage.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("Hello Post???");
		PrintWriter pw = resp.getWriter();
		pw.write("Hello World from servlet doPost method!!!!!!");
		
		tOffer(2,"hello");
			
		
	}
	
	
	static void tOffer(int i,String it) {
		
		String sql="update offer set status = ? where offer_id = "+i;
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, it);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
	}
}