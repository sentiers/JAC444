package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("Student Management - Hyunji Cho");
		window.setMinWidth(300);

		// Text
		Text typeTxt = new Text("STUDENT INFO");

		// StudentID
		Label stdIdLbl = new Label("StudentID :");
		TextField stdIdInput = new TextField();

		// First Name
		Label stdFirstNameLbl = new Label("First name :");
		TextField stdFirstNameInput = new TextField();

		// Last Name
		Label stdLastNameLbl = new Label("Last name :");
		TextField stdLastNameInput = new TextField();

		// Courses
		Label stdCoursesLbl = new Label("Courses :");
		TextArea stdCoursesInput = new TextArea();
		stdCoursesInput.setMaxWidth(150);
		stdCoursesInput.setMaxHeight(100);

		// Add Button
		Button addStdButton = new Button("Add Student");

		// Display Button
		Button displayStdButton = new Button("Display Students");

		// Grid Setup
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(30, 0, 30, 20));
		grid.setVgap(10);
		grid.setHgap(1);

		GridPane.setConstraints(typeTxt, 0, 1);

		GridPane.setConstraints(stdIdLbl, 0, 3);
		GridPane.setConstraints(stdIdInput, 1, 3);

		GridPane.setConstraints(stdFirstNameLbl, 0, 4);
		GridPane.setConstraints(stdFirstNameInput, 1, 4);

		GridPane.setConstraints(stdLastNameLbl, 0, 5);
		GridPane.setConstraints(stdLastNameInput, 1, 5);

		GridPane.setConstraints(stdCoursesLbl, 0, 6);
		GridPane.setConstraints(stdCoursesInput, 1, 6);

		GridPane.setConstraints(addStdButton, 1, 7);
		GridPane.setConstraints(displayStdButton, 1, 8);

		grid.getChildren().setAll(typeTxt, stdIdLbl, stdIdInput, stdFirstNameLbl, stdFirstNameInput, stdLastNameLbl,
				stdLastNameInput, stdCoursesLbl, stdCoursesInput, addStdButton, displayStdButton);

		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.show();

		// Button Functions

		addStdButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				// add new student information and display text notification
				Text notificationTxt = new Text(WriteStudent.add(stdIdInput.getText(), stdFirstNameInput.getText(),
						stdLastNameInput.getText(), stdCoursesInput.getText()));

				// clear the text field
				stdIdInput.setText("");
				stdFirstNameInput.setText("");
				stdLastNameInput.setText("");
				stdCoursesInput.setText("");

				StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().add(notificationTxt);

				Scene secondScene = new Scene(secondaryLayout, 250, 100);

				// New Modal Window
				Stage secondWindow = new Stage();
				secondWindow.setTitle("Notification");
				secondWindow.setScene(secondScene);

				// specifies modality
				secondWindow.initModality(Modality.WINDOW_MODAL);

				// specifies the owner Window
				secondWindow.initOwner(primaryStage);

				secondWindow.show();
			}
		});

		displayStdButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				// display students' information and display text notification
				Text notificationTxt = new Text(ReadStudent.display());

				StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().add(notificationTxt);

				Scene secondScene = new Scene(secondaryLayout, 250, 350);

				// New Modal Window
				Stage secondWindow = new Stage();
				secondWindow.setTitle("Display");
				secondWindow.setScene(secondScene);

				// specifies modality
				secondWindow.initModality(Modality.WINDOW_MODAL);

				// specifies the owner Window
				secondWindow.initOwner(primaryStage);

				secondWindow.show();
			}
		});

	}
}