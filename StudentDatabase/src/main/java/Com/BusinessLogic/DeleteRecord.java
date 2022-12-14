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
 * Servlet implementation class DeleteRecord
 */
@WebServlet("/DeleteRecord")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//read data from form 
		int rollno =Integer.parseInt(request.getParameter("txtrollno"));
		
		//esltablish connection 
		try {
			Connection con =DatabaseConnection.getMyConnection();
			//write query
			String str= "delete from student where rollno=?";
			PreparedStatement ps =con.prepareStatement(str);
			ps.setInt(1, rollno);
			
			//excute quere 
			int ans =ps.executeUpdate();
			PrintWriter out =response.getWriter();
			if(ans>0)
				out.println("record deleted");
			else
				out.println("record not deleted");
			//connection close;
			con.close();
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
