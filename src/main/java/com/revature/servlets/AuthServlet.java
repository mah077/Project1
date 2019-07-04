package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AuthServlet() {
        super();
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);//you get the user from the session
		if (sess == null || sess.getAttribute("user") == null) { //check the user if he is in the session
			//response.sendRedirect("login.html");
			response.getWriter().write("0");// send response = to zero means you are not logging in 
		} else {
			response.getWriter().write("1");// send response =1 means that you are loggin in is successfully
		}
	}

}
