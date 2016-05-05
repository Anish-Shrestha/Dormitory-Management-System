package groupseven.mppproject.presentation;

import java.io.IOException;

import groupseven.mppproject.businesslogic.SingleLogin;
import groupseven.mppproject.controller.DashboardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Stage primaryStage;
	private Stage rootStage = new Stage();
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.rootStage = primaryStage;
		this.primaryStage.setTitle("Dormitory Management System");
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("login.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	
	public void Dashboard() {
		try {
			String message = "Student";
			if(SingleLogin.isAdmin()){
				message = "Admin";
			}
			this.rootStage.setTitle("Dormitory Management System ( Welcome "+message +"! UserId: "+SingleLogin.getUserId()+") ");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			rootStage.setScene(scene);
			rootStage.show();
		} catch (IOException e) {
			// Exception gets thrown if the fxml file could not be loaded
			e.printStackTrace();
		}
		// showMessageWindow();
		showDashboard();
	}

	public void showDashboard() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
			AnchorPane overviewPage = (AnchorPane) loader.load();
			Scene scene = new Scene(overviewPage);
			rootStage.setMaximized(true);
			rootLayout.setCenter(overviewPage);
			// rootLayout.setCenter(overviewPage);
			DashboardController controller = loader.getController();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAboutWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("about.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			// rootLayout.setCenter(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showMessageWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("forum.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			// rootLayout.setCenter(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showFormWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("form.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			// rootLayout.setCenter(page);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void allocateRoom() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("BuildingFXML.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			// rootLayout.setCenter(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addStudent() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("StudentFXML.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			// rootLayout.setCenter(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void generateReport() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("report.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			//rootLayout.setCenter(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void displayStudentDetails() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("StudentDetailsFXML.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			//rootLayout.setCenter(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}