package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementProcedureDao;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.UpDateGrade;
import com.revature.services.RBProcedureService;
import com.revature.util.LoggingUtil;

/**
 * Servlet implementation class UpdateGrade
 */
public class UpdateGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ReimbursementProcedureDao rd = new ReimbursementProcedureDao();
	public static RBProcedureService rs = new RBProcedureService();
       
    
    public UpdateGrade() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		List<UpDateGrade> rblist;
		String name = request.getPathInfo();
		HttpSession sess = request.getSession(false);
		if (sess == null && sess.getAttribute("user") == null) {

			request.getRequestDispatcher("firstPage").forward(request, response);
			return;

		}

		else {
			rblist = rd.getAllResult1();
			ObjectMapper objectMapper = new ObjectMapper();
			String st = objectMapper.writeValueAsString(rblist);
			response.getWriter().write(st);
			LoggingUtil.trace("get list");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i = request.getParameter("id");
		String is= request.getParameter("isapproved");
		int id=Integer.parseInt(i);
		boolean isapp=Boolean.parseBoolean(is);
		rs.SecndBenCoApproval(id, isapp);
		response.sendRedirect("viewbencoupdate.html?success=1");
	}

}
