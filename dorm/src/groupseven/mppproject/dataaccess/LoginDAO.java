package groupseven.mppproject.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import groupseven.mppproject.businesslogic.SingleLogin;

public class LoginDAO {
	ConnectManager cm;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public LoginDAO() {
		try {
			con = ConnectManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isUser(String userid, String password) {
		try {
			String sql = "SELECT userId, isAdmin FROM mppproject.usercredential where userId = '" + userid + "' and password = '"
					+ password + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs == null)
				return false;
			if (rs.next()) {
			//	System.out.println("test: "+rs.getString("isAdmin").trim());
				SingleLogin.setIsAdmin(rs.getString("isAdmin").trim());
				return true;
			}

			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void create(String studentId) {
		try {
			String sql = "INSERT INTO `mppproject`.`usercredential`(`userid`,`password`,`isAdmin`)VALUES('"+studentId+"','12345',0);";

			//System.out.println(sql);
			// Perform INSERT
			stmt = con.createStatement();

			stmt.executeUpdate(sql);
			// success

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
