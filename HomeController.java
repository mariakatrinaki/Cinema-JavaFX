package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomeController extends Label implements Initializable {

	// private static final String wordsClass1;

	Users user;

	boolean autoPlay;

	Image img1;
	Image img2;
	Image img3;
	Image img4;
	Image img5;
	Image img6;
	Image img7;

	Image imgButton;

	ImageView viewButton;

	ArrayList<Image> images;

	boolean isOn = false;

	int count;

	int positiveCount;

	int negativeCount;

	Text text1;

	@FXML
	TextArea textArea;

	@FXML
	Button btnNext;

	@FXML
	Button btnPrevious;

	@FXML
	private BorderPane mainWindow;

	@FXML
	private Label labelTitle;

	

	private static Timeline timeline;

	private static Button switchBtn;

	@FXML
	private AnchorPane mainPane;

	@FXML
	private AnchorPane homeScene;

	private Stage stage = null;

	@FXML
	private ImageView imageViewHomeVisitor;

	@FXML
	private Label labelToggle;

	@FXML
	private Circle picOne;

	@FXML
	private Circle picTwo;

	@FXML
	private Circle picThree;

	@FXML
	private Circle picFour;

	@FXML
	private Circle picFive;

	@FXML
	private Circle picSix;

	@FXML
	private Circle picSeven;
	
	@FXML
	Label labelAnimation;

	private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(true);

	private TranslateTransition transLateAnimation = new TranslateTransition(Duration.minutes(0.25));

	public SimpleBooleanProperty switchOn() {
		return switchedOn;
	}

	@FXML
	public void btnPreviousImage(ActionEvent event) {

		if (isOn == false) {

			if (count > negativeCount && autoPlay == true) {
				count = negativeCount;
			}
			count--;
			if (count >= 6) {
				count = 0;

			} else if (count < 0) {
				count = 6;

			}
			imageViewHomeVisitor.setImage(images.get(count));

			switch (count) {
			case 0:

				setStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				labelTitle.setText("Cinema Complex Ένας νέος κόσμος, μία ολοκληρωτική εμπειρία.");
                getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class1.txt", text1);
                

				break;
			case 1:

				setStroke(picTwo);
				resetStroke(picOne);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				

				break;
			case 2:

				setStroke(picThree);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);

				break;
			case 3:

				setStroke(picFour);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);

				break;
			case 4:

				setStroke(picFive);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picSix);
				resetStroke(picSeven);
				labelTitle.setText("Στις αίθουσες Cinema Complex κάθε "
						+ "θέση είναι ξεχωριστή.");
				getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class2.txt", text1);

				break;
			case 5:

				setStroke(picSix);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSeven);

				break;
			case 6:

				setStroke(picSeven);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				labelTitle.setText("Πρόγραμμα Προβολλών  Cinema Complex");
                getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class3.txt", text1);
				
				break;

			}

		}
		autoPlay = false;
	}

	@FXML
	public void btnNextImage(ActionEvent event) {

		if (isOn == false) {

			if (count > positiveCount && autoPlay == true) {
				count = positiveCount;
			}
			count++;
			if (count > 6) {
				count = 0;

			}
			imageViewHomeVisitor.setImage(images.get(count));
			switch (count) {
			case 0:

				setStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				labelTitle.setText("Cinema Complex Ένας νέος κόσμος, μία ολοκληρωτική εμπειρία.");
                getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class1.txt", text1);


				break;
			case 1:

				setStroke(picTwo);
				resetStroke(picOne);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				break;
			case 2:

				setStroke(picThree);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				break;
			case 3:

				setStroke(picFour);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				break;
			case 4:

				setStroke(picFive);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picSix);
				resetStroke(picSeven);
				labelTitle.setText("Στις αίθουσες  Cinema Complex κάθε "
						+ "θέση είναι ξεχωριστή.");
				getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class2.txt", text1);
				break;
			case 5:

				setStroke(picSix);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSeven);

				break;
			case 6:

				setStroke(picSeven);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
			    labelTitle.setText("Πρόγραμμα Προβολλών Cinema Complex");
                getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class3.txt", text1);
			

				break;

			}

		}

		autoPlay = false;
	}

	public void SwitchButton() {
		switchBtn = new Button();
		switchBtn.setPrefWidth(40);

		switchBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				switchedOn.set(!switchedOn.get());
				if (switchedOn.get() == true) {
					isOn = true;
					displayImages();
					btnNext.setVisible(false);
					btnPrevious.setVisible(false);
				} else {
					isOn = false;
					pauseButton();
					btnNext.setVisible(true);
					btnPrevious.setVisible(true);

				}
			}
		});

		labelToggle.setGraphic(switchBtn);

		switchedOn.addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
				if (t1) {
					labelToggle.setText("ON");
					labelToggle.setStyle("-fx-background-color: red;-fx-text-fill: white;");
					labelToggle.setContentDisplay(ContentDisplay.RIGHT);

				} else {
					labelToggle.setText("OFF");
					labelToggle.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
					labelToggle.setContentDisplay(ContentDisplay.LEFT);

				}
			}
		});

		switchedOn.set(false);
	}

	public void displayImages() {
	//	ImageView imgMovie = new ImageView("movie2.jpg");
		
		
		images = new ArrayList<Image>();
		Image img1 = new Image("cinema1.jpg", 445, 341, false, false);
		Image img3 = new Image("cinema3.jpg", 445, 341, false, false);
		Image img2 = new Image("cinema2.jpg", 445, 341, false, false);
		Image img4 = new Image("cinema4.jpg", 445, 341, false, false);
		Image img5 = new Image("cinema5.jpg", 445, 341, false, false);
		Image img6 = new Image("cinema6.jpg", 445, 341, false, false);
		Image img7 = new Image("cinema7.jpg", 445, 341, false, false);

		images.add(img1);
		images.add(img3);
		images.add(img2);
		images.add(img4);
		images.add(img5);
		images.add(img6);
		images.add(img7);

		if (imageViewHomeVisitor.getImage().getUrl().contains(images.get(0).getUrl())) {
			setStroke(picOne);
			resetStroke(picTwo);
			resetStroke(picThree);
			resetStroke(picFour);
			resetStroke(picFive);
			resetStroke(picSix);
			resetStroke(picSeven);
			labelTitle.setText("Cinema Complex Ένας νέος κόσμος, μία ολοκληρωτική εμπειρία.");
            getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class1.txt", text1);

			count = 1;

		}

		KeyFrame keyframe = new KeyFrame(Duration.seconds(2), ActionEvent -> {

			imageViewHomeVisitor.setImage(images.get(count));
			switch (count) {
			case 0:
				setStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				negativeCount = count;
				positiveCount = count;
				
				labelTitle.setText("Complex Cinema Ένας νέος κόσμος, μία ολοκληρωτική εμπειρία.");
                getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class1.txt", text1);

				break;
			case 1:
				setStroke(picTwo);
				resetStroke(picOne);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				
				negativeCount = count;
				positiveCount = count;
			

				break;
			case 2:
				setStroke(picThree);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				negativeCount = count;
				positiveCount = count;

				break;
			case 3:
				setStroke(picFour);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFive);
				resetStroke(picSix);
				resetStroke(picSeven);
				negativeCount = count;
				positiveCount = count;
				break;
			case 4:
				setStroke(picFive);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picSix);
				resetStroke(picSeven);
				negativeCount = count;
				positiveCount = count;
				labelTitle.setText("Στις αίθουσες Gold Class των Cinema Complex κάθε "
						+ "θέση είναι ξεχωριστή.");
				getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class2.txt", text1);
				break;
			case 5:
				setStroke(picSix);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSeven);
				negativeCount = count;
				positiveCount = count;

				break;
			case 6:
				setStroke(picSeven);
				resetStroke(picOne);
				resetStroke(picTwo);
				resetStroke(picThree);
				resetStroke(picFour);
				resetStroke(picFive);
				resetStroke(picSix);
				negativeCount = count;
				positiveCount = count;
				labelTitle.setText("Πρόγραμμα Προβολλών ");
                getText1("C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\Class3.txt", text1);
				
				
				
				
				break;

			}
			count++;
			if (count > 6) {
				count = 0;
			}

		});

		timeline = new Timeline(keyframe);

		if (isOn == true) {
			startButton();
			System.out.println("play");

		} else if (isOn == false) {
			pauseButton();
			System.out.println("not play");

		}
		autoPlay = true;

	}

	private static void startButton() {
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

	}

	private static void pauseButton() {
		System.out.println("hey pause");
		timeline.setCycleCount(0);
		timeline.stop();

	}

	public void setStroke(Circle indicator) {
		indicator.setFill(Paint.valueOf("#03a9f4"));
		indicator.setStroke(Paint.valueOf("#cddc39"));
		indicator.setStrokeType(StrokeType.OUTSIDE);
		indicator.setStrokeWidth(5);

	}

	public void resetStroke(Circle indicator) {
		indicator.setFill(Paint.valueOf("ffffff"));
		indicator.setStroke(Paint.valueOf("#1e90ff"));
		indicator.setStrokeType(StrokeType.INSIDE);
		indicator.setStrokeWidth(1);

	}
	/*
	 * @FXML private void handleMaxButton(ActionEvent event) { stage = (Stage)
	 * mainPane.getScene().getWindow(); stage.setMaximized(true); }
	 */

	@FXML
	private void handleMinButton(ActionEvent event) {
		stage = (Stage) mainPane.getScene().getWindow();
		stage.setIconified(true); // to minimize stage

	}

	@FXML
	private void handleCloseButton(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("You are about to exit!");
		alert.setContentText("Do you want to exit? ");

		if (alert.showAndWait().get() == ButtonType.OK) {

			stage = (Stage) mainPane.getScene().getWindow();
			stage.close();
		}

	}

	@FXML
	private void handleHomeButton(ActionEvent event) {
		
		
		mainWindow.setCenter(homeScene);
		displayImages();

	}

	@FXML
	private void handleMovieButton(ActionEvent event) {

		AnchorPane view = loadPage("MoviesVisitor.fxml");
		isOn = false;
		pauseButton();
		btnNext.setVisible(true);
		btnPrevious.setVisible(true);
		labelToggle.setText("OFF");
		labelToggle.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
		labelToggle.setContentDisplay(ContentDisplay.LEFT);

		mainWindow.setCenter(view);

	}

	@FXML
	private void handleOrdersVisitor(ActionEvent events) {

		Pane view = loadPage("OrdersBar.fxml");
		isOn = false;
		pauseButton();
		btnNext.setVisible(true);
		btnPrevious.setVisible(true);
		labelToggle.setText("OFF");
		labelToggle.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
		labelToggle.setContentDisplay(ContentDisplay.LEFT);

		mainWindow.setCenter(view);

	}

	

	private AnchorPane loadPage(String page) {
		AnchorPane scenePane = null;
		try {
			URL fileURL = getClass().getResource(page);
			if (fileURL == null) {
				throw new java.io.FileNotFoundException("fILE CANNOT BE FOUND");
			}

			new FXMLLoader();
			scenePane = FXMLLoader.load(fileURL);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("No page" + page + "please check fxml loader");
		}

		return scenePane;
	}

	public void getText1(String path, Text text) {
		String word = " ";
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			while (line != null) {
				
				word = word + line + "\n";

				line = br.readLine();

			}

			text = new Text(word);
			text.setFont(Font.font("Italic", 15));
			
			textArea.setText(text.getText());
			textArea.setEditable(false);
		
              
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelAnimation.setText("Καλως ήρθες "+ControllerLogIn.getVisitor().getUserName()
				+" στο Cinema Complex");
		
	    FadeTransition fadeIn = new FadeTransition(Duration.seconds(10),labelAnimation);
	    fadeIn.setFromValue(0.0);
	    fadeIn.setToValue(0.67);
	    fadeIn.play();
		
	    fadeIn.setOnFinished(event->{
	    	   
	           

	           Timeline timeline = new Timeline(
	               new KeyFrame(Duration.seconds(0), new KeyValue(labelAnimation.textFillProperty(), Color.DARKBLUE)),
	               new KeyFrame(Duration.seconds(2), new KeyValue(labelAnimation.textFillProperty(), Color.DARKMAGENTA)),
	               new KeyFrame(Duration.seconds(4), new KeyValue(labelAnimation.textFillProperty(), Color.BLUEVIOLET))
	           );
	           timeline.setAutoReverse(true);
	           timeline.setCycleCount(Animation.INDEFINITE);
	           timeline.play();

	    	
	    });
		
		
		displayImages();

		SwitchButton();

	}

}
