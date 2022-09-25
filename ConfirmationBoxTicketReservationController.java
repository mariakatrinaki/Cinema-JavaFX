package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ConfirmationBoxTicketReservationController implements Initializable {

	 @FXML
	 TextArea textAreaConfirmTickets;
	
	 @FXML
	 Label  taskStatus;
	 
	 @FXML
	 Label boxTitleTicket;
	 
	 @FXML
	 ProgressBar progressCheckTicket;
	 
	 @FXML
	 ProgressIndicator progressIndicator;
	 
	 private boolean isFinished;
	 
	 
	 
	 
	 
	public boolean isFinished() {
		return isFinished;
	}





	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}





	public TextArea getTextAreaConfirmTickets() {
		return textAreaConfirmTickets;
	}





	public Label getTaskStatus() {
		return taskStatus;
	}





	public Label getBoxTitleTicket() {
		return boxTitleTicket;
	}





	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
		
		boxTitleTicket.setText("Έλεγχος εισιτηρίου απο τον χρήστη "+ControllerLogIn.getEmployee().getUserName());
		progressIndicator.setStyle("-fx-accent: #00FF00");
		progressIndicator.progressProperty().bind(progressCheckTicket.progressProperty());
		progressCheckTicket.setStyle("-fx-accent: #00FF00");
		KeyValue start = new KeyValue(progressCheckTicket.progressProperty(), 0);
		KeyValue end = new KeyValue(progressCheckTicket.progressProperty(), 1);
		KeyFrame frame = new KeyFrame(Duration.seconds(10), start, end);
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(1);
		timeline.play();
		
		timeline.setOnFinished(event -> {
		isFinished = true;	
		taskStatus.setText("Ο έλεγχος ολοκληρώθηκε.");
		
		});
		taskStatus.setText("Ο έλεγχος βρίσκεται σε εξέλιξη..");
	}

}
