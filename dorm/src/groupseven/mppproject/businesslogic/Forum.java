package groupseven.mppproject.businesslogic;

import java.util.ArrayList;
import java.util.List;

import groupseven.mppproject.dataaccess.ForumDAO;
import groupseven.mppproject.utils.Helper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Forum {
	public String type;
	public String title;
	public String description;
	
	public Forum() {

	}

	public Forum(String typeId, String title, String desc) {
		//System.out.println(typeId);
		this.type = typeId;
		this.title = title;
		this.description = desc;
	}

	public ObservableList<String> getExistingForum() {
		ForumDAO obj = new ForumDAO();
		final ObservableList<Forum> existingForumList = (ObservableList<Forum>) obj.selectAll(SingleLogin.getUserId());
		ObservableList<String> result = FXCollections.observableArrayList();
		if(existingForumList==null)return result;
		for (Forum object : existingForumList) {
			result.add(object != null ? object.type + " : " + object.title.toString() : "");
		}
		return result;
	}

	public boolean isNullorEmpty() {
		if (this.type == null || this.title == null || this.type.isEmpty() || this.title.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean createForum() {
		ForumDAO forumdb = new ForumDAO(this.type, this.title,this.description,SingleLogin.getUserId());
		forumdb.create();
		return true;
	}
}
