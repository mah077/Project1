package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDao;
import com.revature.services.RBProcedureService;

/**
 * Servlet implementation class HeadDep
 */
public class HeadDep extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static RBProcedureService rs= new RBProcedureService();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadDep() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("HeadDep.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i = request.getParameter("id");
		String is= request.getParameter("isapproved");
		int id=Integer.parseInt(i);
		boolean isapp=Boolean.parseBoolean(is);
		rs.HeadDepApproval(id, isapp);
		response.sendRedirect("vrh.html?success=1");
	}

}
