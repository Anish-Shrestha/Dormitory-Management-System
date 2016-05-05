package groupseven.mppproject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import groupseven.mppproject.businesslogic.Dashboard;
import groupseven.mppproject.businesslogic.SingleLogin;
import groupseven.mppproject.dataaccess.DashboardDAO;
import groupseven.mppproject.presentation.Main;

public class DashboardController {
	@FXML
	private TableView<Dashboard> assotiatedTable;
	@FXML
	private TableColumn<Dashboard, String> buildingNo;
	@FXML
	private TableColumn<Dashboard, String> roomNo;
	@FXML
	private TableColumn<Dashboard, String> person;
	@FXML
	private TableColumn<Dashboard, String> emailAdd;
	DashboardDAO db = new DashboardDAO();
	@FXML
	private TextField searchName;
	@FXML
	private ListView<String> studentInformation = new ListView<String>();
	@FXML
	private ListView<String> studentMessage = new ListView<String>();
	@FXML
	public Button refresh;
	@FXML
	private PieChart chart;
	// @FXML
	// private Button messageBtn;
	// @FXML
	// private Button reportBtn;
	// @FXML
	// private Button personBtn;
	// @FXML
	// private Button formBtn;
	Main main = new Main();

	public DashboardController() {
	}


	@FXML
	private void initialize() {

		
		 	chart.setData(db.pieChart());
	        chart.setTitle("Number of Students in Buildings");
		
	        studentMessage.setItems(db.getAllMessages());
		
		ObservableList<Dashboard> assotiation = FXCollections.observableArrayList();
		assotiation.addAll(db.selectAll());

		// System.out.println("isAdmin "+ SingleLogin.isAdmin());
		// Initialize the person table
		buildingNo.setCellValueFactory(new PropertyValueFactory<Dashboard, String>("buildingNumber"));
		roomNo.setCellValueFactory(new PropertyValueFactory<Dashboard, String>("roomNumber"));
		person.setCellValueFactory(new PropertyValueFactory<Dashboard, String>("personName"));
		emailAdd.setCellValueFactory(new PropertyValueFactory<Dashboard, String>("email"));
		assotiatedTable.setItems(db.selectAll());

		searchName.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.isEmpty()) {
				assotiatedTable.setItems(db.selectAll());
			} else
				assotiatedTable.setItems(db.selectAll(newValue));

		});
		
		refresh.setOnAction((event) -> {
			assotiatedTable.setItems(db.selectAll());
			 studentMessage.setItems(db.getAllMessages());
		 	chart.setData(db.pieChart());
	        chart.setTitle("Number of Students in Buildings");
		});
		
		assotiatedTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	System.out.println();
				studentInformation.setItems(db.getStudentDetail(newSelection.email));
		    }
		});


		// messageBtn.setOnAction((event) -> {
		// System.out.println("Button Action\n");
		// });
		// reportBtn.setOnAction((event) -> {
		// System.out.println("Button Action\n");
		// });
		// personBtn.setOnAction((event) -> {
		// System.out.println("Button Action\n");
		// });
		// formBtn.setOnAction((event) -> {
		// System.out.println("Button Action\n");
		// });
	}

}
