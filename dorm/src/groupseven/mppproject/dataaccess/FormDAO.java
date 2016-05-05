package groupseven.mppproject.dataaccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import groupseven.mppproject.businesslogic.Forum;
import groupseven.mppproject.businesslogic.Report;
import groupseven.mppproject.businesslogic.interfaces.ImySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FormDAO implements ImySQL {
	private int formId;
	public int studentId;
	public int roomNo;
	private int buildingNo;
	private LocalDate filledDate;
	private String formType;
	private String items;
	ConnectManager cm;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public FormDAO(int studentId, int roomNo, int buildingNo, LocalDate filledDate, String formType, String items)
			throws IOException {
		try {
			con = ConnectManager.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}

		this.studentId = studentId;
		this.roomNo = roomNo;
		this.buildingNo = buildingNo;
		this.filledDate = filledDate;
		this.formType = formType;
		this.items = items;
	}

	public FormDAO() {
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
			String sql = "insert into mppproject.report(studentId,roomNo,buildingNo, filledDate, formType, items) values("
					+ this.studentId + "," + this.roomNo + "," + this.buildingNo + ",'" + this.filledDate + "','"
					+ this.formType + "','" + this.items + "')";

			stmt = con.createStatement();
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ObservableList<Report> generateReport() {
		try {
			String sql = "SELECT buildingNo, count(*) roomsOccupied FROM report where formType != 'CheckOut' group by buildingNo";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ObservableList<Report> reportList = FXCollections.observableArrayList();
			while (rs.next()) {
				Report r = new Report(String.valueOf(rs.getInt("buildingNo")),
						String.valueOf(rs.getInt("roomsOccupied")));
				reportList.add(r);

			}
			return reportList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}
}
