package groupseven.mppproject.businesslogic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Building {
private int buildingNo;

public Building(int buildingNo){
	this.buildingNo=buildingNo;
}
public Building() {
	// TODO Auto-generated constructor stub
}
public int getBuildingNo() {
	return buildingNo;
}

public ObservableList<Integer> getBuildingList(){
	ObservableList<Integer> buildingList = FXCollections.observableArrayList(140,141,142,143,144);
	return buildingList;   
}

}
