package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class CleanHallsSeatsEmployeeController implements Initializable {

	@FXML
	ChoiceBox choiceBoxHall;

	@FXML
	TextField textFieldUse;

	@FXML
	TextField textFieldObjects;

	@FXML
	Label labelToggleRobot;

	@FXML
	ImageView imageView;

	@FXML
	Label robotSpeak;

	@FXML
	Circle firstCircle;

	@FXML
	Circle secondCircle;

	@FXML
	Circle thirdCircle;

	@FXML
	Circle fourthCircle;
	
	@FXML
	Circle fifthCircle;

	

	@FXML
	ImageView imageGarbageBottle;

	@FXML
	ImageView imageGarbageCan;

	@FXML
	ImageView imageGarbagePaper;

	@FXML
	ImageView imageGarbagePhone;

	boolean isFinished = false;

	private String[] halls = { "Αίθουσα 1", "Αίθουσα 2", "Αίθουσα 3" };

	private String[] seats = { "Θέση 1", "Θέση 2", "Θέση 3", "Θέση 4", "Θέση 5", "Θέση 6", "Θέση 7", "Θέση 8", "Θέση 9",
			"Θέση 10", "Θέση 11", "Θέση 12" };

	private String[] objects = { "Ανιχνεύτηκαν αντικείμενα","Δεν ανιχνεύτηκαν αντικείμενα" };

	private String[] uses = { "Έχει χρησιμοποιηθεί", "Δεν έχει χρησιμοποιηθεί", "Χρησιμοποιείται" };

	private SimpleBooleanProperty switchedOnRobot = new SimpleBooleanProperty(true);

	ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

	Button switchBtnRobot;

	int randomUses = 0;
	int randomObjects = 0;
	int randomSeats = 0;
	int count = 0;

	@SuppressWarnings("unchecked")
	public void getRandomString() {

		choiceBoxHall.getItems().addAll(halls);

		choiceBoxHall.setOnAction(event -> {

			if (choiceBoxHall.getSelectionModel().getSelectedItem() != null) {

				randomUses = (int) (Math.random() * 3);
				if (!randomNumbers.contains(randomUses)) {
					randomNumbers.add(randomUses);
					textFieldUse.setText(uses[randomUses]);
				} else {
					while (randomNumbers.contains(randomUses)) {
						randomUses = (int) (Math.random() * 3);
					}
					randomNumbers.add(randomUses);
					textFieldUse.setText(uses[randomUses]);
				}

			}
			count++;
			if (count == 3) {
				randomNumbers.clear();
				count = 0;
			}
			if (textFieldUse.getText().equals("Έχει χρησιμοποιηθεί")) {
				robotSpeak.setText("Ενεργοποιείστε τον αυτόματο καθαρισμό");
			} else {
				robotSpeak.setText("Ο αυτόματος καθαρισμός δεν μπορεί να ενεργοποιηθεί");
			}
		});

	}

	public void switchRobot() {

		Image imageRobot = new Image("robotCleaner.png");
		Image garbageBottle = new Image("garbageBottle.png");
		Image garbageCan = new Image("garbageCan.png");
		Image garbagePaper = new Image("garbagePaper.png");
		Image garbagePhone = new Image("garbagePhone.png");
		imageView.setImage(imageRobot);
		imageGarbageBottle.setImage(garbageBottle);
		imageGarbageCan.setImage(garbageCan);
		imageGarbagePaper.setImage(garbagePaper);
		imageGarbagePhone.setImage(garbagePhone);

		TranslateTransition translate = new TranslateTransition();
		
		switchBtnRobot = new Button();
		switchBtnRobot.setPrefWidth(40);
		switchBtnRobot.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				switchedOnRobot.set(!switchedOnRobot.get());
			}
		});

		labelToggleRobot.setGraphic(switchBtnRobot);

		switchedOnRobot.addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {

				if (newValue && textFieldUse.getText().equals("Έχει χρησιμοποιηθεί")) {
					imageGarbageBottle.setVisible(true);
					imageGarbageCan.setVisible(true);
					imageGarbagePaper.setVisible(true);
					imageGarbagePhone.setVisible(true);
					labelToggleRobot.setText("ON");
					labelToggleRobot.setStyle("-fx-background-color: green;-fx-text-fill:white;");
					labelToggleRobot.setContentDisplay(ContentDisplay.RIGHT);
					firstCircle.setVisible(false);
					secondCircle.setVisible(false);
					thirdCircle.setVisible(false);
					fourthCircle.setVisible(false);
					fifthCircle.setVisible(false);
					
					robotSpeak.setText("");

					translate.setNode(imageView);
					translate.setDuration(Duration.millis(3000));
					translate.setCycleCount(2);
					translate.setByX(1000);
					translate.setAutoReverse(true);
					translate.play();

					translate.setOnFinished(event -> {
						isFinished = true;
						labelToggleRobot.setText("OFF");
						labelToggleRobot.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
						labelToggleRobot.setContentDisplay(ContentDisplay.LEFT);
						firstCircle.setVisible(true);
						secondCircle.setVisible(true);
						thirdCircle.setVisible(true);
						fourthCircle.setVisible(true);
						fifthCircle.setVisible(true);
						
						imageGarbageBottle.setVisible(false);
						imageGarbageCan.setVisible(false);
						imageGarbagePaper.setVisible(false);
						imageGarbagePhone.setVisible(false);
						robotSpeak.setText("O καθαρισμός ολοκληρώθηκε");

						randomObjects = (int) (Math.random() * 2);
						randomSeats = (int) (Math.random() * 12);
						if(randomObjects==1) {
						textFieldObjects.setText(objects[randomObjects]);	
						}else {

						textFieldObjects.setText(objects[randomObjects]+" /"+seats[randomSeats]);
						}

					});

					translate.statusProperty().addListener(new ChangeListener<Status>() {

						@Override
						public void changed(ObservableValue<? extends Status> observableValue, Status oldValue,
								Status newValue) {
							if (newValue == Status.RUNNING) {
								labelToggleRobot.setDisable(true);

							} else {
								labelToggleRobot.setDisable(false);
							}
						}
					});

				} else {
					imageGarbageBottle.setVisible(false);
					imageGarbageCan.setVisible(false);
					imageGarbagePaper.setVisible(false);
					imageGarbagePhone.setVisible(false);
					translate.statusProperty().addListener(new ChangeListener<Status>() {

						@Override
						public void changed(ObservableValue<? extends Status> observableValue, Status oldValue,
								Status newValue) {
							if (newValue == Status.RUNNING) {
								labelToggleRobot.setDisable(true);
							} else {
								labelToggleRobot.setDisable(false);
							}
						}
					});

					labelToggleRobot.setText("OFF");
					labelToggleRobot.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
					labelToggleRobot.setContentDisplay(ContentDisplay.LEFT);
					if (choiceBoxHall.getSelectionModel().getSelectedItem() == null) {
						robotSpeak.setText("Επιλέξτε αίθουσα");

					}

				}
			}
		});

		switchedOnRobot.set(false);

	}

	public SimpleBooleanProperty switchedswitchedOnRobots() {
		return switchedOnRobot;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		getRandomString();
		switchRobot();

	}

}
