package groupseven.mppproject.businesslogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import groupseven.mppproject.dataaccess.ConnectManager;

public class Room {
	private int roomNo;
	Building building;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public Room() {

	}

	public Room(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void getRoomInfo() {
		getRoomNo();
	}

	public boolean roomAvailable(int buildingNo, int roomNo) {
		return false;

	}

	public ObservableList<Integer> getRoomList() {
		ObservableList<Integer> roomList = FXCollections.observableArrayList(101, 102, 103, 104, 105, 106, 107, 108,
				109, 110, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 301, 302, 303, 304, 305, 306, 307, 308, 309,
				310);
		return roomList;
	}

	public boolean isRoomOccupied(int buildingNo, int roomNo) {
		try {
			con = ConnectManager.getConnection();

			String sqlRoom = "select buildingNo,roomNo from roomallocate where buildingNo='" + buildingNo
					+ "' and roomNo='" + roomNo + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlRoom);
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
