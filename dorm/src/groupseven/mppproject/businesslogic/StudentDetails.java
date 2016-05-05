package groupseven.mppproject.businesslogic;

public class StudentDetails {
	private int studentId, roomNo, buildingNo;
	private String studentName;

	public StudentDetails(int studentId, String studentName, int buildingNo, int roomNo) {
		this.studentId=studentId;
		this.studentName=studentName;
		this.roomNo=roomNo;
		this.buildingNo = buildingNo;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	public int getBuildingNo() {
		return buildingNo;
	}

}
