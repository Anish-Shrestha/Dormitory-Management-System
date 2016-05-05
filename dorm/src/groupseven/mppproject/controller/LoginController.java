package groupseven.mppproject.controller;

import groupseven.mppproject.businesslogic.SingleLogin;
import groupseven.mppproject.dataaccess.LoginDAO;
import groupseven.mppproject.presentation.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Text message;
	@FXML
	private TextField userId;
	@FXML
	private PasswordField password;
	@FXML
	public Button submit;

	@FXML
	protected void Submit(ActionEvent event) {

		System.out.println(userId.getText());
		System.out.println(password.getText());
		LoginDAO loginCheck = new LoginDAO();
		boolean credential = loginCheck.isUser(userId.getText(), password.getText());
		if (credential) {
			SingleLogin.setLoginParam(userId.getText(), password.getText());
			Main m = new Main();
			Stage stage = (Stage) submit.getScene().getWindow();
			stage.close();
			m.Dashboard();
		}else{
			message.setText("user or password is invalid");
		}
		

	}

	public LoginController() {

	}

	public void initialize() {

	}
}
