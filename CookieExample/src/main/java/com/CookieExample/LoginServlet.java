package com.CookieExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Reading values
		String uname= request.getParameter("uname");
		String pword=request.getParameter("password");
		PrintWriter out=response.getWriter();
		
		if(pword.equals("abc123")){
			
			Cookie cookie=new Cookie("username",uname);//key,value
			response.addCookie(cookie);
			
			//Request Dispatcher is used to send information on next page or same page
			RequestDispatcher rs= request.getRequestDispatcher("Link.html");
			rs.forward(request, response);
			
		}
		else
		{
			out.println("sorry username or password is wrong");
			RequestDispatcher rs= request.getRequestDispatcher("Login.html");
			rs.include(request, response);
		}
		
		
	}

}