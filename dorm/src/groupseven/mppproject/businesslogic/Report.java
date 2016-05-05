package groupseven.mppproject.businesslogic;

public class Report {
	private String buildingNo;
	private String roomsOccupied;

	public Report(String buildingNo, String roomsOccupied) {
		this.buildingNo = buildingNo;
		this.roomsOccupied = roomsOccupied;
	}

	/**
	 * @return the buildingNo
	 */
	public String getBuildingNo() {
		return buildingNo;
	}

	/**
	 * @param buildingNo the buildingNo to set
	 */
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	/**
	 * @return the roomsOccupied
	 */
	public String getRoomsOccupied() {
		return roomsOccupied;
	}

	/**
	 * @param roomsOccupied the roomsOccupied to set
	 */
	public void setRoomsOccupied(String roomsOccupied) {
		this.roomsOccupied = roomsOccupied;
	}

	/*public ObservableList<String> generateReport() {
		FormDAO obj = new FormDAO();
		final ObservableList<Report> reports = (ObservableList<Report>) obj.generateReport();
		ObservableList<String> result = FXCollections.observableArrayList();
		for (Report object : reports) {
			result.add(object.toString());
		}
		return result;
	}

	public String toString() {
		return "Building " + this.buildingNo + " has " + this.roomsOccupied + " occupied.\n";
	}*/

}
