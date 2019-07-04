package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.pojo.Employee;
import com.revature.pojo.Reimbursement;

/**
 * Servlet implementation class ViewAllReimbursementServlet
 */
public class ViewAllReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ReimbursementDao rd =new ReimbursementDao();
	
	
    public ViewAllReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Reimbursement> rblist;
		String name = request.getPathInfo();
	    HttpSession sess = request.getSession(false);  
	    if (sess == null && sess.getAttribute("user") == null) 
	    	{
	    	
	    	request.getRequestDispatcher("firstPage").forward(request,response);
				return;
	    		
	    	}
	
		else {
			
	    	 rblist= rd.viewAllReimbursement();
	    	ObjectMapper objectMapper = new ObjectMapper();  
	    	String st=objectMapper.writeValueAsString(rblist);
	    	response.getWriter().write(st);
		}
	      	//response.getWriter().write("<p>"+st+"</p>");
	    	//response.getWriter().append(objectMapper.writeValueAsString(rblist));            
	    	//response.setStatus(401);
	    	
			/* we user it for jsp viewform.jsp
			 * System.out.println("servlet "+rblist); sess.setAttribute("rblist", rblist);
			 * //RequestDispatcher reqdisp= request.getRequestDispatcher("viewform.jsp");
			 * //reqdisp.forward(request, response);
			 */	
	}
	
		
		
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		}
	
}
