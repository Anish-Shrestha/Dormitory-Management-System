package groupseven.mppproject.controller;

import groupseven.mppproject.businesslogic.StudentDetails;

import groupseven.mppproject.dataaccess.PersonDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentDetailController {
	@FXML
	private TableView<StudentDetails> displayStudentDetails;
	@FXML
	private TableColumn<StudentDetails, Integer> studentId, roomNo, buildingNo;
	@FXML
	private TableColumn<StudentDetails, String> studentName;

	@FXML
	private void initialize() {
		PersonDAO db = new PersonDAO();
		ObservableList<StudentDetails> stdetails = FXCollections.observableArrayList();
		stdetails.addAll(db.generateList());

		studentId.setCellValueFactory(new PropertyValueFactory<StudentDetails, Integer>("studentId"));
		studentName.setCellValueFactory(new PropertyValueFactory<StudentDetails, String>("studentName"));
		buildingNo.setCellValueFactory(new PropertyValueFactory<StudentDetails, Integer>("buildingNo"));
		roomNo.setCellValueFactory(new PropertyValueFactory<StudentDetails, Integer>("roomNo"));

		displayStudentDetails.setItems(stdetails);
	}

}
