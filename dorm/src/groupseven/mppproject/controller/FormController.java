package groupseven.mppproject.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import groupseven.mppproject.dataaccess.FormDAO;
import groupseven.mppproject.exceptions.FormException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FormController implements Initializable {
	@FXML
	private ComboBox formType;
	@FXML
	private TextField studentId;
	@FXML
	private ComboBox buildingNo;
	@FXML
	private ComboBox roomNo;
	@FXML
	private DatePicker formSubmissionDate;
	@FXML
	private Button submitButton;
	@FXML
	private CheckBox bedItem;
	@FXML
	private CheckBox chairItem;
	@FXML
	private CheckBox curtainItem;
	@FXML
	private CheckBox mirrorItem;
	@FXML
	private CheckBox bedLinenItem;
	@FXML
	private Text message;

	private ObservableList staticFormTypes = FXCollections.observableArrayList("CheckIn", "CheckOut");
	private ObservableList staticBuildingNumbers = FXCollections.observableArrayList("140", "141", "142", "143", "144");
	private ObservableList staticRoomNumbers = FXCollections.observableArrayList("101", "102", "103", "104", "105",
			"306");
	private FormDAO formDAO;

	public void formTypeSelected() {

	}

	public void onBuildingSelected() {
		roomNo.setDisable(false);
		roomNo.setPromptText("--Choose");
	}

	public void onRoomSelected() {

	}

	public void onDateSelected() {

	}

	public void submitButtonClicked() {
		try {
			validateEmptiness();
			validateNumeric();
		} catch (FormException fe) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(fe.getMessage());
			alert.showAndWait();
		}
		String items = "";
		if (bedItem.isSelected()) {
			items += "Bed ";
		}
		if (chairItem.isSelected()) {
			items += "Chair ";
		}
		if (curtainItem.isSelected()) {
			items += "Curtain ";
		}
		if (mirrorItem.isSelected()) {
			items += "Mirror ";
		}
		if (bedLinenItem.isSelected()) {
			items += "Bed Linen";
		}

		try {
			formDAO = new FormDAO(Integer.parseInt(studentId.getText().toString()),
					Integer.parseInt(roomNo.getSelectionModel().getSelectedItem().toString()),
					Integer.parseInt(buildingNo.getSelectionModel().getSelectedItem().toString()),
					formSubmissionDate.getValue(), formType.getSelectionModel().getSelectedItem().toString(), items);
			formDAO.create();
			message.setText("Form Submitted successfully");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void validateNumeric() throws FormException {
		if (!studentId.getText().toString().matches("^\\d+$"))
			throw new FormException("Student Id field must be numeric");
	}

	private void validateEmptiness() throws FormException {
		if (studentId.getText().toString().isEmpty()
				|| roomNo.getSelectionModel().getSelectedItem() == null
				|| buildingNo.getSelectionModel().getSelectedItem() == null
				|| formSubmissionDate.getValue() == null
				|| formType.getSelectionModel().getSelectedItem().toString().isEmpty()) {
			throw new FormException("One or more fields are empty");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		formType.setItems(staticFormTypes);
		formType.setValue("CheckIn");
		buildingNo.setItems(staticBuildingNumbers);
		buildingNo.setPromptText("--Choose");
		roomNo.setItems(staticRoomNumbers);
		roomNo.setDisable(true);
	}
}
