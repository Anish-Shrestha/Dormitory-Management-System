package groupseven.mppproject.controller;

import groupseven.mppproject.businesslogic.Forum;
import groupseven.mppproject.utils.Helper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ForumController {
	@FXML
	private Text message;
	@FXML
	public Button submit;
	@FXML
	private TextField title;
	@FXML
	private ListView<String> existingForum = new ListView<String>();
	Forum forum = new Forum();

	@FXML
	public ComboBox<String> forumType;
	public ObservableList<String> forumTypeData = FXCollections.observableArrayList("Suggestion", "Complain",
			"Maintainance");

	@FXML
	private TextArea description;

	public ForumController() {

	}

	public void initialize() {
		forumType.setItems(forumTypeData);

		existingForum.setItems(forum.getExistingForum());
	}

	@FXML
	protected void SubmitForum(ActionEvent event) {

		if(!validateForum())
			return;

		Forum f = new Forum(forumType.getSelectionModel().getSelectedItem(), title.getText(),
				description.getText());

		if (f.createForum())
			message.setText("Message added!!");

		existingForum.setItems(forum.getExistingForum());

	}

	public boolean validateForum() {
		if (Helper.isNullorEmpty(title.getText())) {
			message.setText("Please select Message Title");
			return false;
		}
		if (Helper.isNullorEmpty(forumType.getSelectionModel().getSelectedItem())) {
			message.setText("Please select Message Type");
			return false;
		}
		return true;
	}

}
