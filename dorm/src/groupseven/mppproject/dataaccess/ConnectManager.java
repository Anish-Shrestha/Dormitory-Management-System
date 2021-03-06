package groupseven.mppproject.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectManager {
	public static Connection getConnection() throws Exception{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mppproject", "root", "mysql");
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ConnectManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return con;
	}
	public void closeConnection(Connection con)  throws SQLException {
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
}
