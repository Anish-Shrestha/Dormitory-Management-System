package groupseven.mppproject.controller;

import groupseven.mppproject.businesslogic.SingleLogin;
import groupseven.mppproject.presentation.Main;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class RootController {
	Main m = new Main();
	@FXML
	private MenuItem messageMenu;
	@FXML private MenuItem checkInForm, roomAllocationId,addStudent, generateReport,displayStudent, about;

	@FXML
	private void initialize() {
		about.setOnAction((event) -> {
			m.showAboutWindow();
		});
		if(!SingleLogin.isAdmin())
		messageMenu.setOnAction((event) -> {
			m.showMessageWindow();
		});
		else
			messageMenu.setDisable(true);
	
		checkInForm.setOnAction((event) -> {
			m.showFormWindow();
		});
		if(SingleLogin.isAdmin())
		roomAllocationId.setOnAction((event) -> {
			m.allocateRoom();
		});
		else
			roomAllocationId.setDisable(true);
		
		if(SingleLogin.isAdmin())
		addStudent.setOnAction((event) -> {
			m.addStudent();
		});
		else
			addStudent.setDisable(true);
		
		
		generateReport.setOnAction((event) -> {
			m.generateReport();
		});
		
		displayStudent.setOnAction((event) -> {
			m.displayStudentDetails();
		});
	}
}
