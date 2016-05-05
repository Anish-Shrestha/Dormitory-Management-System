package groupseven.mppproject.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import groupseven.mppproject.businesslogic.Dashboard;
import groupseven.mppproject.businesslogic.Forum;
import groupseven.mppproject.businesslogic.Report;
import groupseven.mppproject.businesslogic.interfaces.ImySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.text.Font;
import javafx.scene.text.TextBuilder;

public class DashboardDAO implements ImySQL {
	public String buildingNumber;
	public String roomNumber;
	public String personName;
	public String email;
	ConnectManager cm;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public DashboardDAO(String buildingNumber, String roomNumber, String personName, String email) {
		try {
			con = ConnectManager.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
		this.buildingNumber = buildingNumber;
		this.roomNumber = roomNumber;
		this.personName = personName;
		this.email = email;
	}

	public DashboardDAO() {
		try {
			con = ConnectManager.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void create() {

	}

	public ObservableList<Dashboard> selectAll() {
		// public String buildingNumber;
		// public String roomNumber;
		// public String personName;
		// public String email;
		try {

			String sql = "SELECT buildingNo, roomNo, studentName, studentEmail FROM mppproject.roomallocate t1 INNER JOIN mppproject.student t2 ON t1.studentId=t2.studentid;";
			//System.out.println(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ObservableList<Dashboard> dashboardList = FXCollections.observableArrayList();
			while (rs.next()) {
			//	System.out.println(rs.getString("studentName").trim());
				Dashboard f = new Dashboard(rs.getString("buildingNo").trim(), rs.getString("roomNo").trim(),
						rs.getString("studentName").trim(), rs.getString("studentEmail").trim());
				dashboardList.add(f);

			}

			return dashboardList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}

	public ObservableList<Dashboard> selectAll(String searchText) {
		// public String buildingNumber;
		// public String roomNumber;
		// public String personName;
		// public String email;
		try {
			String sql = "SELECT buildingNo, roomNo, studentName, studentEmail FROM mppproject.roomallocate t1 INNER JOIN mppproject.student t2 ON t1.studentId=t2.studentid where studentName like '"
					+ searchText + "%';";
			// System.out.println(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ObservableList<Dashboard> dashboardList = FXCollections.observableArrayList();
			while (rs.next()) {
				Dashboard f = new Dashboard(rs.getString("buildingNo").trim(), rs.getString("roomNo").trim(),
						rs.getString("studentName").trim(), rs.getString("studentEmail").trim());
				dashboardList.add(f);

			}

			return dashboardList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}

	// SELECT studentName,type,title FROM mppproject.messageboard mb
	// inner join mppproject.student s on mb.studentid = s.studentid;
	
	public ObservableList<String> getAllMessages() {

		try {
			String sql = "SELECT studentName,type,title FROM mppproject.messageboard mb inner join mppproject.student s on mb.studentid = s.studentid order by id desc;";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ObservableList<String> dashboardList = FXCollections.observableArrayList();
			while (rs.next()) {
				dashboardList.add(rs.getString("studentName") + " (" + rs.getString("type").trim() + ") : " + rs.getString("title").trim());
			}

			return dashboardList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}

	public ObservableList<String> getStudentDetail(String email) {

		try {
			String sql = "select studentId, filledDate, formType, items from mppproject.report where studentId = (select studentId from mppproject.student where studentEmail = '"
					+ email + "')";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ObservableList<String> dashboardList = FXCollections.observableArrayList();
			while (rs.next()) {
				dashboardList.add("Student Id: " + rs.getString("studentId").trim());
				dashboardList.add("Form: " + rs.getString("formType").trim());
				dashboardList.add("Filled Date : " + rs.getString("filledDate").trim());
				dashboardList.add("Items in room : " + rs.getString("items").trim());
				dashboardList.add("----------------------------------------------------------------");
			}

			return dashboardList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}

	public ObservableList<PieChart.Data> pieChart() {
		// ObservableList<PieChart.Data> pieChartData =
		// FXCollections.observableArrayList(
		// new PieChart.Data("Grapefruit", 13),
		// new PieChart.Data("Oranges", 25),
		// new PieChart.Data("Plums", 10),
		// new PieChart.Data("Pears", 22),
		// new PieChart.Data("Apples", 30));
		try {
			String sql = "SELECT buildingNo, count(*) roomsOccupied FROM report where formType != 'CheckOut' group by buildingNo";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ObservableList<PieChart.Data> reportList = FXCollections.observableArrayList();
			while (rs.next()) {
				String buildingNo = String.valueOf(rs.getInt("buildingNo"));
				int count = rs.getInt("roomsOccupied");
				PieChart.Data r = new PieChart.Data("Building-" + buildingNo + " : " + count, count);
				reportList.add(r);

			}
			return reportList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}

	// SELECT buildingNo, roomNo, name, email
	// FROM mppproject.roomallocate t1
	// INNER JOIN mppproject.person t2
	// ON t1.studentId=t2.id where name like 'a%'

}