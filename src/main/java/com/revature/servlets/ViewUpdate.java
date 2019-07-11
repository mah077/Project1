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
import com.revature.pojo.Reimbursement;
import com.revature.services.RBProcedureService;
import com.revature.util.LoggingUtil;


public class ViewUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ReimbursementDao rd = new ReimbursementDao();
	public static RBProcedureService rs = new RBProcedureService();
	
	public ViewUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Reimbursement> rblist;
		String name = request.getPathInfo();
		HttpSession sess = request.getSession(false);
		if (sess == null && sess.getAttribute("user") == null) {
			LoggingUtil.trace("faild");
			request.getRequestDispatcher("firstPage").forward(request, response);
			return;
		
		}

		else {
			rblist = rd.getReimbursement();
			ObjectMapper objectMapper = new ObjectMapper();
			String st = objectMapper.writeValueAsString(rblist);
			response.getWriter().write(st);
			LoggingUtil.trace("get list");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String i = request.getParameter("id");
		String grade= request.getParameter("grade");
		int id=Integer.parseInt(i);
		
		rs.EmployeeUpdateGrade(id, grade);
		response.sendRedirect("UpdateGrade.html?success=1");
	}

}
