package groupseven.mppproject.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import groupseven.mppproject.businesslogic.Forum;
import groupseven.mppproject.businesslogic.interfaces.ImySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ForumDAO implements ImySQL {
	public String type;
	public String title;
	public String description;
	public String studentid;
	ConnectManager cm;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public ForumDAO(String type, String title, String description, String studentId) {
		try {
			con = ConnectManager.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
		this.type = type;
		this.title = title;
		this.description = description;
		this.studentid = studentId;
	}

	public ForumDAO() {
		try {
			con = ConnectManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void create() {
		try {
			String sql = "insert into mppproject.messageboard(type,title,description,studentid) values('" + this.type
					+ "','" + this.title + "','" + this.description + "','" + this.studentid + "')";

	//		System.out.println(sql);
			// Perform INSERT
			stmt = con.createStatement();

			stmt.executeUpdate(sql);
			// success

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ObservableList<Forum> selectAll(String userId) {
		try {
			String sql = "SELECT type, title, description FROM mppproject.messageboard where studentid="
					+ userId + " order by id desc;";
		//	System.out.println(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ObservableList<Forum> forumList = FXCollections.observableArrayList();
			while (rs.next()) {
				Forum f = new Forum(rs.getString("type").trim(), rs.getString("title").trim(),
						rs.getString("description").trim());
				forumList.add(f);
			
			}
			return forumList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}
}
