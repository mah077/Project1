package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.pojo.Employee;
import com.revature.pojo.Reimbursement;
import com.revature.util.LoggingUtil;



public class ReEmbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ReimbursementDao rd =new ReimbursementDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ReEmbursement.html");		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Employee employee=(Employee) sess.getAttribute("employee");
		
		String fn = request.getParameter("fn");
		String ls = request.getParameter("ln");
		String username = request.getParameter("username");
		String ct = request.getParameter("coursetype");
		String adrs = request.getParameter("address");
		String dat = request.getParameter("date");
		String time = request.getParameter("time");
		String grdfrm = request.getParameter("gradeformat");
		String passgrad = request.getParameter("passgrade");
		String wrj = request.getParameter("wrj");
		String discr = request.getParameter("discr");
		String cost = request.getParameter("cost");// we wanna make sure that the user is sending an double not String 
		double cst=Double.parseDouble(cost);
		
		rd.FillReEmbursement(new Reimbursement(fn, ls, username, ct, adrs, dat, time, grdfrm, passgrad, wrj, discr, cst));
		System.out.println("fill success"+fn+ls);
		PrintWriter pw=response.getWriter();
		pw.write("<h1>Reimbursment Submitted</h1>");
		response.sendRedirect("Employee.html");
		pw.write("<h1>Reimbursment Submitted</h1> !important");
		LoggingUtil.trace("get list");
		}
	

}
