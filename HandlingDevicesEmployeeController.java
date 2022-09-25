package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HandlingDevicesEmployeeController extends Label implements Initializable {

	Button switchBtnHallsCorridors;

	Button switchBtnBar;
	
	Button switchOtherDevices;

	@FXML
	ChoiceBox choiceBoxHalls;

	@FXML
	ChoiceBox choiceBoxCorridors;

	@FXML
	ChoiceBox choiceBoxBar;
	
	@FXML
	ChoiceBox choiceBoxDevices;
	
	@FXML
	Label labelToggleHallsCorridors;

	@FXML
	ImageView imageViewLightHallCorridor;

	@FXML
	ImageView imageViewtHall;
	
	@FXML
	ImageView imageViewBar;

	@FXML
	Label labelHallLight;

    @FXML
    ImageView imageViewCaffeteria;

	@FXML
	ImageView imageViewLightBar;

	@FXML
	Label labelToggleBar;
	
	@FXML
	Label labelBarLight;
	
	@FXML
	Label labelToogleDevices;
	
	
	@FXML
	Label labelOtherDevices;
	
	@FXML
	Pane paneCaffeteria;
	

	private String hall;
	private String corridor;

	ArrayList<String> halls = new ArrayList<String>(Arrays.asList("Αίθουσα 1", "Αίθουσα 2", "Αίθουσα 3", "Αίθουσα 4"));

	ArrayList<String> corridors = new ArrayList<String>(
			Arrays.asList("Διάδρομος 1", "Διάδρομος 2", "Διάδρομος 3", "Διάδρομος 4"));
	
	ArrayList<String> bars = new ArrayList<String>(Arrays.asList("FirstCinemaBarComplex","SecondCinemaBarComplex"));
	
    ArrayList<String> devices = new ArrayList<String>(Arrays.asList("Φωτοτυπικό","Σαρωτικό"));
	
	private SimpleBooleanProperty switchedOnHallCorridor = new SimpleBooleanProperty(true);
	private SimpleBooleanProperty switchedOnBar = new SimpleBooleanProperty(true);
	private SimpleBooleanProperty switchedOnOtherDevices = new SimpleBooleanProperty(true);
	
	@SuppressWarnings("unchecked")
	public void switchOtherDevicesOnOff(){
		
		choiceBoxDevices.getItems().addAll(devices);
		
		
		switchOtherDevices = new Button();
		switchOtherDevices.setPrefWidth(40);
		Image imageScannerOn = new Image("scannerOn.png");
		Image imageScannerOff = new Image("scannerOff.jpg");
		Image imagePhotocopierOn = new Image("photocopierOn.png");
		Image imagePhotocopierOff = new Image("photocopierOff.jpg");
		
		choiceBoxDevices.setOnAction(event->{
			if(choiceBoxDevices.getSelectionModel().getSelectedItem().equals("Φωτοτυπικό")) {
				paneCaffeteria.setVisible(true);
				imageViewCaffeteria.setImage(imagePhotocopierOff);

				labelToogleDevices.setText("OFF");
				labelToogleDevices.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
				labelToogleDevices.setContentDisplay(ContentDisplay.LEFT);
				 labelOtherDevices.setText("Το "+choiceBoxDevices.getSelectionModel().getSelectedItem()+" δεν είναι σε λειτουργία");
			}else if(choiceBoxDevices.getSelectionModel().getSelectedItem().equals("Σαρωτικό")) {
				paneCaffeteria.setVisible(true);
				 imageViewCaffeteria.setImage(imageScannerOff);

					labelToogleDevices.setText("OFF");
					labelToogleDevices.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
					labelToogleDevices.setContentDisplay(ContentDisplay.LEFT);
				 labelOtherDevices.setText("Το "+choiceBoxDevices.getSelectionModel().getSelectedItem()+" δεν είναι σε λειτουργία");
			}
			
			
		});

		
		
		switchOtherDevices.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				switchedOnOtherDevices.set(!switchedOnOtherDevices.get());
			}
		});

		labelToogleDevices.setGraphic(switchOtherDevices);

		switchedOnOtherDevices.addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {

				if (newValue && choiceBoxDevices.getSelectionModel().getSelectedItem()!=null) {

					labelToogleDevices.setText("ON");
					labelToogleDevices.setStyle("-fx-background-color: green;-fx-text-fill:white;");
					labelToogleDevices.setContentDisplay(ContentDisplay.RIGHT);
					paneCaffeteria.setVisible(true);
					if(choiceBoxDevices.getSelectionModel().getSelectedItem().equals("Σαρωτικό")) {
						imageViewCaffeteria.setImage(imageScannerOn);
						
					}else if(choiceBoxDevices.getSelectionModel().getSelectedItem().equals("Φωτοτυπικό")) {
						imageViewCaffeteria.setImage(imagePhotocopierOn);
						
					}
					labelOtherDevices.setText("Το "+choiceBoxDevices.getSelectionModel().getSelectedItem() + " είναι σε λειτουργία");
					
				} else  {

					labelToogleDevices.setText("OFF");
					labelToogleDevices.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
					labelToogleDevices.setContentDisplay(ContentDisplay.LEFT);
					
				  if(choiceBoxDevices.getSelectionModel().getSelectedItem()==null) {
					  labelOtherDevices.setText("Δεν έχετε επιλέξει κάποιο μηχάνημα");
					  paneCaffeteria.setVisible(false);
				  }	
					
				  else if(choiceBoxDevices.getSelectionModel().getSelectedItem()!=null &&choiceBoxDevices.getSelectionModel().getSelectedItem().equals("Σαρωτικό")) {
					 imageViewCaffeteria.setImage(imageScannerOff);
					 labelOtherDevices.setText("Το "+choiceBoxDevices.getSelectionModel().getSelectedItem()+" δεν είναι σε λειτουργία");		
					
				}else if(choiceBoxDevices.getSelectionModel().getSelectedItem()!=null &&choiceBoxDevices.getSelectionModel().getSelectedItem().equals("Φωτοτυπικό"))
				{
					imageViewCaffeteria.setImage(imagePhotocopierOff);
					labelOtherDevices.setText("Το "+choiceBoxDevices.getSelectionModel().getSelectedItem()+" δεν είναι σε λειτουργία");		
				}
					
			}
			}	
		});
		
		switchedOnOtherDevices.set(false);
		
		}

	public SimpleBooleanProperty switchedOnOtherDevices() {
		return switchedOnOtherDevices;
	}
		
		
		
		
	
	
	
	
	
	public void switchButtonBar() {
		Image imageBarLightOn= new Image("cinemaBarlightOn.jpg");
		Image imageBarLightOff= new Image("cinemaBarlightOff.jpg");
		
		Image lightBulbOn = new Image("lightBulbON.png");
		Image lightBulbOf = new Image("lightBulbOf.png");
		choiceBoxBar.getItems().addAll(bars);

		switchBtnBar = new Button();
		switchBtnBar.setPrefWidth(40);

		switchBtnBar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				switchedOnBar.set(!switchedOnBar.get());
			}
		});

		labelToggleBar.setGraphic(switchBtnBar);

		switchedOnBar.addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {

				if (newValue && choiceBoxBar.getSelectionModel().getSelectedItem()!=null) {

					labelToggleBar.setText("ON");
					labelToggleBar.setStyle("-fx-background-color: green;-fx-text-fill:white;");
					labelToggleBar.setContentDisplay(ContentDisplay.RIGHT);
					imageViewLightBar.setImage(lightBulbOn);
					imageViewBar.setImage(imageBarLightOn);
					labelBarLight.setText("Το φως στο μπαρ "+choiceBoxBar.getSelectionModel().getSelectedItem() + " είναι ανοιχτο");
					
				} else  {

					labelToggleBar.setText("OFF");
					labelToggleBar.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
					labelToggleBar.setContentDisplay(ContentDisplay.LEFT);
					imageViewLightBar.setImage(lightBulbOf);
					imageViewBar.setImage(imageBarLightOff);
					labelBarLight.setText("Το φως στο μπαρ "+choiceBoxBar.getSelectionModel().getSelectedItem()+" είναι κλειστό");
					

					if (choiceBoxBar.getSelectionModel().getSelectedItem() == null) {
						labelBarLight.setText("Επιλέξτε μπαρ");
					
					
				}
			}
			}	
		});
		
		switchedOnBar.set(false);
		
		}

	public SimpleBooleanProperty switchOnPropertyBar() {
		return switchedOnBar;
	}

	public void switchButtonHalls() {
		choiceBoxHalls.getItems().addAll(halls);
		choiceBoxCorridors.getItems().addAll(corridors);
		Image lightBulbOn = new Image("lightBulbON.png");
		Image lightBulbOf = new Image("lightBulbOf.png");
		Image imageDarktHall = new Image("HallOf.jpg");
		Image imageLightHall = new Image("HallOn.jpg");

		switchBtnHallsCorridors = new Button();
		switchBtnHallsCorridors.setPrefWidth(40);

		switchBtnHallsCorridors.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				switchedOnHallCorridor.set(!switchedOnHallCorridor.get());
			}
		});

		labelToggleHallsCorridors.setGraphic(switchBtnHallsCorridors);

		switchedOnHallCorridor.addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {

				if (newValue && choiceBoxHalls.getSelectionModel().getSelectedItem() != null
						&& choiceBoxCorridors.getSelectionModel().getSelectedItem() != null) {

					hall = String.valueOf(choiceBoxHalls.getSelectionModel().getSelectedItem());
					corridor = String.valueOf(choiceBoxCorridors.getSelectionModel().getSelectedItem());
					labelToggleHallsCorridors.setText("ON");
					labelToggleHallsCorridors.setStyle("-fx-background-color: green;-fx-text-fill:white;");
					labelToggleHallsCorridors.setContentDisplay(ContentDisplay.RIGHT);
					imageViewLightHallCorridor.setImage(lightBulbOn);
					imageViewtHall.setImage(imageLightHall);
					labelHallLight.setText("To φως στην " + choiceBoxHalls.getSelectionModel().getSelectedItem() + " είναι ανοιχτό");

				} else {

					labelToggleHallsCorridors.setText("OFF");
					labelToggleHallsCorridors.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
					labelToggleHallsCorridors.setContentDisplay(ContentDisplay.LEFT);
					imageViewLightHallCorridor.setImage(lightBulbOf);
					imageViewtHall.setImage(imageDarktHall);
					labelHallLight.setText("Το φως στην "+ choiceBoxHalls.getSelectionModel().getSelectedItem() +"είναι κλειστό");

					if (choiceBoxHalls.getSelectionModel().getSelectedItem() == null
							&& choiceBoxCorridors.getSelectionModel().getSelectedItem() != null) {
						labelHallLight.setText("Επιλέξτε αίθουσα");
					} else if (choiceBoxCorridors.getSelectionModel().getSelectedItem() == null
							&& choiceBoxHalls.getSelectionModel().getSelectedItem() != null) {
						labelHallLight.setText("Επιλέξτε  διάδρομο");
					} else if (choiceBoxHalls.getSelectionModel().getSelectedItem() == null
							&& choiceBoxCorridors.getSelectionModel().getSelectedItem() == null) {
						labelHallLight.setText("Επιλέξτε αίθουσα και διάδρομο");
					}
				}

			}
		});

		switchedOnHallCorridor.set(false);
	}

	public SimpleBooleanProperty switchOnPropertyHalls() {
		return switchedOnHallCorridor;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		//choiceBoxDevices.selectionModelProperty().setValue(devices.get(0));

		switchButtonBar();

		switchButtonHalls();
		switchOtherDevicesOnOff();

	}

}
