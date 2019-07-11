package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.RBProcedureService;
import com.revature.util.LoggingUtil;

public class SuperVisor extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public static RBProcedureService rs= new RBProcedureService();  

    public SuperVisor() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.sendRedirect("superVisor.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i = request.getParameter("id");
		String is= request.getParameter("isapproved");
		int id=Integer.parseInt(i);
		boolean isapp=Boolean.parseBoolean(is);
		rs.SupervisorApproval(id, isapp);
		response.sendRedirect("viewAllReimbursement.html?success=1");
		LoggingUtil.trace("super visor page");
	}

}
