package com.CookieExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/DisplayCookie")
public class DisplayCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie[]= request.getCookies();
		PrintWriter out =response.getWriter();
		
		if(cookie!=null) {
			for(Cookie c: cookie) {
				String uname=c.getValue();
				if(uname!=null || uname.equals("")) {
					out.println("Welcome "+uname);
				}
			}
		}
		
	}

}
