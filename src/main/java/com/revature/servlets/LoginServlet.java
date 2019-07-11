package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.dao.LoginDao;
import com.revature.services.CheckLoginService;
import com.revature.util.LoggingUtil;




public class LoginServlet extends HttpServlet{

	public static LoginDao login= new LoginDao();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("firstPage.html");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		CheckLoginService cl= new CheckLoginService();
		
		String username = req.getParameter("email");
		String password = req.getParameter("password");
		//boolean istrue = login.isCorrectAuth(username, password);
		boolean istrue =cl.CheckAuth(username,password);
		
		  if(istrue==true) { 
		 HttpSession sess = req.getSession(true);//this for to create a session to make sure dont open any page either you are logging in 
		 sess.setAttribute("user", true);// i put the youser in the session
		 LoggingUtil.trace("login Success");
		 
		 
		 if(username.contains("@emp")) {
		 resp.sendRedirect("Employee.html");
		 }
		 else 
			 if (username.contains("@sup"))
		 {resp.sendRedirect("superVisor.html");}
		 
		 else 
			 if (username.contains("@head"))
		 { resp.sendRedirect("HeadDep.html");}
		 
		 else if (username.contains("@benco"))
		 { resp.sendRedirect("benCo.html");}
		 
		 
		  //resp.getWriter().write("<h1>Successful Login</h1>");
		 //req.getRequestDispatcher("home").forward(req, resp);
			
		  } 
		  else {
			  LoggingUtil.trace("login Failed");
		  //resp.setStatus(401); 
			  resp.sendRedirect("firstPage.html?error=1");
			//resp.getWriter().write("<h1>Failed "+username+"Login</h1>");
			 
		  }
		 
		 
		
	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside the server method of lifeCycleServlet");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("Inside the destroy method of lifeCycleServlet");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Inside the init method of lifeCycleServlet");
		super.init();
	}

}