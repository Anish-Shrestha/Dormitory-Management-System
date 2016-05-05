package groupseven.mppproject.dataaccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import groupseven.mppproject.businesslogic.Report;
import groupseven.mppproject.businesslogic.StudentDetails;
import groupseven.mppproject.businesslogic.interfaces.ImySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonDAO implements ImySQL {
	public int studentId;
	public int roomNo;
	private int buildingNo;
	private String studentName;

	ConnectManager cm;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public PersonDAO(int studentId, String studentName, int roomNo, int buildingNo) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.roomNo = roomNo;
		this.buildingNo = buildingNo;
	}

	public PersonDAO() {
		try {
			con = ConnectManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void create() {

	}

	public ObservableList<StudentDetails> generateList() {
		try {
			String sql = "Select r.studentId,studentName,buildingNo,roomNo from roomallocate r,student s where s.studentId=r.studentId order by r.studentId";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ObservableList<StudentDetails> studentList = FXCollections.observableArrayList();
			while (rs.next()) {
				StudentDetails sd = new StudentDetails(rs.getInt("studentId"), rs.getString("studentName"),
						rs.getInt("buildingNo"), rs.getInt("roomNo"));
				studentList.add(sd);
			}
			return studentList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}
}
