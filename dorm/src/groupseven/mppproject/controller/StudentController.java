package groupseven.mppproject.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import groupseven.mppproject.dataaccess.ConnectManager;
import groupseven.mppproject.dataaccess.LoginDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StudentController {
	@FXML
	TextField idTextField, nameTextField, emailTextField;
	@FXML
	Button btnAddStudent;
	@FXML
	Text msg;
	ConnectManager cm;
	Connection con;
	Statement stmt;
	ResultSet rs;

	@FXML
	void onAddStudent() {
		if (idTextField.getText().isEmpty() || nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty())
			msg.setText("Fields cannot be empty");
		else {
			int studentId = Integer.parseInt(idTextField.getText());
			String studentName = nameTextField.getText().toString();
			String studentEmail = emailTextField.getText().toString();
			// submit data to database
			try {
				if (isstudentadded()) {
					msg.setText("Student already Exists");
				
				} else {
					String sql = "insert into student(studentId,studentName,studentEmail) values('"
							+ studentId+ "','"+ studentName + "','"	+ studentEmail+ "')";

					// Perform INSERT
					stmt = con.createStatement();
					LoginDAO loginCreate = new LoginDAO();
					if (stmt.executeUpdate(sql) > 0)
						loginCreate.create(idTextField.getText());
						msg.setText("Student Added Successfully!! default password: 12345");
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void initialize() {
		// TODO Auto-generated method stub
		cm = new ConnectManager();
		try {
			con = cm.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isstudentadded() throws SQLException {
		int studentId = Integer.parseInt(idTextField.getText());
		String sqlRoom = "select studentId from student where studentId='" + studentId + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlRoom);
		if (rs.next()) {
			return true;
		}
		return false;
	}
}