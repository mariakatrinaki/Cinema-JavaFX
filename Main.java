package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Main extends Application  {
	
	

	public static void main(String[] args) {
	launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
				
		//primaryStage.setTitle("Todo List");
		primaryStage.setScene(new Scene(root,300,300));
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.show();
	}



	
	
	
}