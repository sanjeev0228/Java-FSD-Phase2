package com.StudentInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class StudentDAO
 */
@WebServlet("/StudentDAO")
public class StudentDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				// reading form values
				int marks = Integer.parseInt(request.getParameter("txtmarks"));
				String name = request.getParameter("txtName");
				// put values in Object
				Student stud = new Student();
				stud.setMarks(marks);
				stud.setName(name);
				//create connection
				Configuration config=new Configuration();
				SessionFactory sessionFactory=config.configure().buildSessionFactory();
				
				//open connection
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				//save object as record
				int i=(Integer)session.save(stud);
				session.getTransaction().commit();

				session.close();
				PrintWriter out = response.getWriter();
				if (i > 0)
					out.println("Record inserted");
				else
					out.println("Record not inserted");


				
				
			
	
	
	
	}

}
