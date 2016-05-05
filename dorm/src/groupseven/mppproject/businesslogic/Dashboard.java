package groupseven.mppproject.businesslogic;

public class Dashboard {
	public String buildingNumber;
	public String roomNumber;
	public String personName;
	public String email;
	
	public Dashboard(String bn,String rn, String personName, String email){
		this.buildingNumber = bn;
		this.roomNumber = rn;
		this.personName = personName;
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getBuildingNumber(){
		return buildingNumber;
	}
	public void setBuildingNumber(String buildingNumber){
		this.buildingNumber = buildingNumber;
	}
	public String getRoomNumber(){
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber){
		this.roomNumber = roomNumber;
	}
	public String getPersonName(){
		return personName;
	}
	public void setPersonName(String personName){
		this.personName = personName;
	}
}
