package Com.BusinessLogic;

import java.sql.*;

public class DatabaseConnection {
	static Connection con = null;
	public static Connection getMyConnection() {
		   try {
	            // Step 1 :load Driver class. Class.forName() tells class loader to load Driver
	            // class in memory at runtime
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // Step2 : Connection- Database url, username, password
	            // DriverManager is available in java.sql
	            String url = "jdbc:mysql://localhost:3306/practice";
	            String user = "root";
	            String password = "smpen.273304#";
	            con = DriverManager.getConnection(url, user, password);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
	}


