package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

public class ConfirmationBoxOrderByEmployeeController implements Initializable {

	@FXML
	TextArea textOrder;

	@FXML
	ProgressBar progressOrder;

	@FXML
	Label statusOrder;
	
	@FXML
	Label labelNameEmployee;
	
	@FXML
	ProgressIndicator progressIndicator;
	
	
	

	public Label getLabelNameEmployee() {
		return labelNameEmployee;
	}



	

	private boolean isFinished = false;

	
	
	public Label getStatusOrder() {
		return statusOrder;
	}

	

	public boolean getIsFinished() {
		return isFinished;
	}

	public TextArea getTextOrder() {
		return textOrder;
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		
		progressOrder.setStyle("-fx-accent: #00FF00");
		progressIndicator.setStyle("-fx-accent: #00FF00");
		progressIndicator.progressProperty().bind(progressOrder.progressProperty());
		KeyValue start = new KeyValue(progressOrder.progressProperty(), 0);
		KeyValue end = new KeyValue(progressOrder.progressProperty(), 1);
		KeyFrame frame = new KeyFrame(Duration.seconds(10), start, end);
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(1);
		timeline.play();
		timeline.setOnFinished(event -> {
		isFinished = true;	
		statusOrder.setText("Η παραγγελία διεκπεραίωθηκε!");
		});
	
		labelNameEmployee.setText("Παραγγελίες Πελατών  χρήστης: "+ControllerLogIn.getEmployee().getUserName());
		

	}

	public void increaseProgress() {
		// progress += 0.1;
		// progressOrder.setProgress(progress);
		// progress += 0.1;
		// progressOrder.setProgress(progress);
		// statusOrder.setText(Double.toString((int)Math.round(progress*100)));
	}

}
