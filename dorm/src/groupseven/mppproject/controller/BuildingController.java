package groupseven.mppproject.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import groupseven.mppproject.businesslogic.Forum;
import groupseven.mppproject.dataaccess.ConnectManager;
import groupseven.mppproject.dataaccess.DashboardDAO;

public class BuildingController {
	@FXML
	ComboBox<String> buildingNo, roomNo;
	@FXML
	ComboBox<Integer> studentId;
	@FXML
	Button btnAllocateRoom;
	@FXML
	Text msg;
	int building, room, student;
	Connection con;
	Statement stmt;
	ResultSet rs;

	@FXML
	void onBuildingSelected() {
		// System.out.println(building);
		roomNo.setDisable(false);
		msg.setText(" ");
		// displaying value of room checking if room is available or not from
		// database
		List<String> room = Arrays.asList("101", "102", "103", "104", "105");
		roomNo.setPromptText("--Choose");
		roomNo.setItems(FXCollections.observableArrayList(room));
	}

	@FXML
	void onRoomSelected() throws SQLException {
		ObservableList<Integer> student = FXCollections.observableArrayList();
		// System.out.println(room);
		studentId.setDisable(false);
		// displaying value to student for those student for whom room are to be
		// allocated from database
		String sqlStudent = "select student.studentId from student where student.studentId not in(select roomallocate.studentId from roomallocate)";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlStudent);
		if (rs.next()) {
			student.add(rs.getInt("studentId"));
		}
		studentId.setPromptText("--Choose");
		studentId.setItems(student);
	}

	@FXML
	void onStudentSelected() {

	}

	@FXML
	void onAllocateRoomClicked() {
		int building = Integer.parseInt(buildingNo.getSelectionModel().getSelectedItem());
		int room = Integer.parseInt(roomNo.getSelectionModel().getSelectedItem());
		int student = studentId.getSelectionModel().getSelectedItem();
		// submit data to database
		try {
			if (isroomoccupied()) {
				msg.setText("Room already Occupied");
				roomNo.setDisable(true);
				studentId.setDisable(true);
			} else {
				String sql = "insert into roomallocate(buildingNo,roomNo,studentId) values('" + building + "','" + room
						+ "','" + student + "')";

				// Perform INSERT
				stmt = con.createStatement();

				if (stmt.executeUpdate(sql) > 0)
					msg.setText("Room Allocated Successfully");
				
				roomNo.setDisable(true);
				studentId.setDisable(true);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public ObservableList<String> buildingInfo = FXCollections.observableArrayList("140", "141", "142", "143", "144");

	public void initialize() {
		// TODO Auto-generated method stub
		buildingNo.setPromptText("--Choose");
		buildingNo.setItems(buildingInfo);
		roomNo.setDisable(true);
		studentId.setDisable(true);
		try {
			con = ConnectManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isroomoccupied() throws SQLException {
		int building = Integer.parseInt(buildingNo.getSelectionModel().getSelectedItem());
		int room = Integer.parseInt(roomNo.getSelectionModel().getSelectedItem());
		int student = studentId.getSelectionModel().getSelectedItem();
		String sqlRoom = "select buildingNo,roomNo from roomallocate where buildingNo='" + building + "' and roomNo='"
				+ room + "' and studentId='" + student + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlRoom);
		if (rs.next()) {
			return true;
		}
		return false;
	}

}

