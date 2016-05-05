package groupseven.mppproject.controller;

import groupseven.mppproject.businesslogic.Report;
import groupseven.mppproject.dataaccess.FormDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReportController {
	@FXML
	private TableView<Report> reportTable;
	@FXML
	private TableColumn<Report, String> buildingNo;
	@FXML
	private TableColumn<Report, String> roomsOccupied;
	private FormDAO db;

	public ReportController() {
		db = new FormDAO();
	}

	@FXML
	private void initialize() {
		ObservableList<Report> reports = FXCollections.observableArrayList();
		reports.addAll(db.generateReport());
		displayReport(reports);
	}

	public void displayReport(ObservableList<Report> reports) {
		buildingNo.setCellValueFactory(new PropertyValueFactory<Report, String>("buildingNo"));
		roomsOccupied.setCellValueFactory(new PropertyValueFactory<Report, String>("roomsOccupied"));
		reportTable.setItems(reports);
	}

}
