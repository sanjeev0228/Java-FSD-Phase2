package Com.BusinessLogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//read data from form
		int rollno=Integer.parseInt(request.getParameter("txtrollno"));
		String name= request.getParameter("txtname");
		int marks= Integer.parseInt(request.getParameter("txtmarks"));
		
		// establic connection with database
		
		try {
			Connection con=DatabaseConnection.getMyConnection();	
			
			//write query
			
			String str= "Insert into student (rollno ,name,marks) values (?,?,?)";
			//string str= "update student set marks=? where rollno=?"
			//String str="delete from student where rollno=?"
			
			//to execute query create object of preparedSatement
			
			PreparedStatement ps = con.prepareStatement(str);
			
			ps.setInt(1,rollno);
			ps.setString(2, name);
			ps.setInt(3, marks);
			
			//excuteQuery
			int ans =ps.executeUpdate();
			PrintWriter out= response.getWriter();
			if(ans>0) 
				out.println("Record Inserted");
			else
				out.println("Record Not inserted");
			//close connection
			con.close();
			
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}


	}

	}
