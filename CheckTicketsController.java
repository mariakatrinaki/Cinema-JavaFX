package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class CheckTicketsController implements Initializable {

	@FXML
	ChoiceBox choiceBoxHall;

	@FXML
	ChoiceBox choiceBoxSeats;

	@FXML
	TextArea textAreaPayment;

	@FXML
	TextArea textAreaNameCustomer;

	@FXML
	Label statusOrder;
	
	@FXML
	 Circle firstCircle;
	
	@FXML
	Circle secondCircle;
	
	@FXML
	Circle thirdCircle;
	
	@FXML
	ImageView imageViewEmployee;

	private String selectedHall;

	private String selectedSeat;

	private String selectedPayment;

	private String selectedName;
	


	private String[] halls = { "Αίθουσα 1", "Αίθουσα 2", "Αίθουσα 3", "Αίθουσα 4", };

	private String[] seats = { "Θέση 1", "Θέση 2", "Θέση 3", "Θέση 4", "Θέση 5", "Θέση 6", "Θέση 7", "Θέση 8", "Θέση 9",
			"Θέση 10", "Θέση 11" };

	private String[] payment = { "Έχει εξοφληθεί", "Δεν έχει εξοφληθεί" };

	private String[] names = { "Δημήτρης Παπαδόπουλος", "Αντρέας Αθανασίου", "Γιώργος Αντρέου", "Παναγιώτης Νικολάου",
			"Δήμητρα Γκρέκου", "Γεωργία Στεργίου", "Αγάπη Νικολάου", "Θεοδώρα Παπαθανασίου" };

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		Image imageEmployee = new Image("imageEmployee.png");
		imageViewEmployee.setImage(imageEmployee);
	
		choiceBoxHall.getItems().addAll(halls);
		choiceBoxSeats.getItems().addAll(seats);
		statusOrder.setVisible(false);
		firstCircle.setVisible(false);
		secondCircle.setVisible(false);
		thirdCircle.setVisible(false);
		
		
		

		choiceBoxHall.setOnAction(event -> {
			selectedPayment = getRandomStrings(payment);
			selectedName = getRandomStrings(names);
			selectedHall = String.valueOf(choiceBoxHall.getSelectionModel().getSelectedItem());
			
			
			if ((selectedHall != null && selectedSeat != null && !selectedPayment.equals("Δεν έχει εξοφληθεί"))) {
				textAreaPayment.setText(selectedPayment);
				textAreaNameCustomer.setText(selectedName);
				firstCircle.setVisible(true);
				secondCircle.setVisible(true);
				thirdCircle.setVisible(true);
				statusOrder.setVisible(true);
				statusOrder.setText("Επιβεβαιώστε την κράτηση εισιτήρίου στο όνομα " + selectedName + " ,χρήστη: "+ ControllerLogIn.getEmployee().getUserName());
				

			} else if (selectedHall == null || selectedSeat == null) {
				if(selectedHall== null && selectedSeat!=null) {
					firstCircle.setVisible(true);
					secondCircle.setVisible(true);
					thirdCircle.setVisible(true);
					statusOrder.setVisible(true);	
				statusOrder.setText("Δεν μπορεί να επιβεβαιωθεί η κράτηση επιλέξτε Αίθουσα");
				}else if(selectedSeat==null && selectedHall!=null) {
					firstCircle.setVisible(true);
					secondCircle.setVisible(true);
					thirdCircle.setVisible(true);
					statusOrder.setVisible(true);	
				statusOrder.setText("Δεν μπορεί να επιβεβαιωθεί η κράτηση επιλέξτε Θέση");
				}else {
					firstCircle.setVisible(true);
					secondCircle.setVisible(true);
					thirdCircle.setVisible(true);
					statusOrder.setVisible(true);	
				statusOrder.setText("Επιλέξτε αριθμό αίθουσας και αριθμό θέσης");
					
				}
			} else if (selectedPayment.equals("Δεν έχει εξοφληθεί")) {
				textAreaPayment.setText(selectedPayment);
				textAreaNameCustomer.setText(selectedName);
				firstCircle.setVisible(true);
				secondCircle.setVisible(true);
				thirdCircle.setVisible(true);
				statusOrder.setVisible(true);
				statusOrder.setText("Δεν έχει εξοφληθεί ενημερώστε τον πελάτη " + selectedName + ", χρήστη: "+ControllerLogIn.getEmployee().getUserName());

			}

		});
		choiceBoxSeats.setOnAction(event -> {
			
			
			
			selectedPayment = getRandomStrings(payment);
			selectedName = getRandomStrings(names);
			selectedSeat = String.valueOf(choiceBoxSeats.getSelectionModel().getSelectedItem());
			if ((selectedHall != null && selectedSeat != null && !selectedPayment.equals("Δεν έχει εξοφληθεί"))) {
				textAreaPayment.setText(selectedPayment);
				textAreaNameCustomer.setText(selectedName);
				firstCircle.setVisible(true);
				secondCircle.setVisible(true);
				thirdCircle.setVisible(true);
				statusOrder.setVisible(true);
				statusOrder.setText("Επιβεβαιώστε την κράτηση εισιτήρίου στο όνομα " + selectedName + ", χρήστη: "+ControllerLogIn.getEmployee().getUserName());
			} else if (selectedHall == null || selectedSeat == null) {
				if(selectedHall== null && selectedSeat!=null) {
					firstCircle.setVisible(true);
					secondCircle.setVisible(true);
					thirdCircle.setVisible(true);
					statusOrder.setVisible(true);	
				statusOrder.setText("Δεν μπορεί να επιβεβαιωθεί η κράτηση επιλέξτε Αίθουσα");
				}else if(selectedSeat==null && selectedHall!=null) {
					firstCircle.setVisible(true);
					secondCircle.setVisible(true);
					thirdCircle.setVisible(true);
					statusOrder.setVisible(true);	
				statusOrder.setText("Δεν μπορεί να επιβεβαιωθεί η κράτηση επιλέξτε Θέση");
				}else {
					firstCircle.setVisible(true);
					secondCircle.setVisible(true);
					thirdCircle.setVisible(true);
					statusOrder.setVisible(true);	
				statusOrder.setText("Επιλέξτε αριθμό αίθουσας και αριθμό θέσης");
					
				}
			} else if (selectedPayment.equals("Δεν έχει εξοφληθεί")) {
				textAreaPayment.setText(selectedPayment);
				textAreaNameCustomer.setText(selectedName);
				firstCircle.setVisible(true);
				secondCircle.setVisible(true);
				thirdCircle.setVisible(true);
				statusOrder.setVisible(true);
				
				statusOrder.setText("Δεν έχει εξοφληθεί ενημερώστε τον πελάτη " + selectedName + ", χρήστη: "+ControllerLogIn.getEmployee().getUserName());
			}
		});

	}

	public String getRandomStrings(String[] list) {

		String randomString = "";

		int numberPayment = (int) (Math.random() * 2);
		int numberNames = (int) (Math.random() * 8);

		if (list.length == payment.length) {
			randomString = list[numberPayment];

		} else if (list.length == names.length) {
			randomString = list[numberNames];
		}
		return randomString;
	}

	@FXML
	public void confirmReservationTicket(ActionEvent event) {
		if ((selectedHall != null && selectedSeat != null && !selectedPayment.equals("Δεν έχει εξοφληθεί"))) {
			try {
				Stage stage = new Stage();
				Parent root = null;

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConfirmationBoxTicketReservation.fxml"));

				root = fxmlLoader.load();
				ConfirmationBoxTicketReservationController confirmationBoxTicketReservationController = fxmlLoader
						.getController();

				if (root != null) {
					confirmationBoxTicketReservationController.getTextAreaConfirmTickets()
							.setText(selectedHall + "\n" + selectedSeat + "\n" + "Ονοματεπώνυμο: " + selectedName
									+ "\n To εισιτήριο " + selectedPayment);
					stage.setScene(new Scene(root));

					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initStyle(StageStyle.UTILITY);

					stage.show();
					stage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
						@SuppressWarnings("unchecked")
						public void handle(WindowEvent event) {
							if (confirmationBoxTicketReservationController.isFinished() == false) {
								event.consume();
								confirmationBoxTicketReservationController.getTaskStatus()
										.setText("Δεν έχει ολοκληρωθεί o έλεγχος");
							} else {
								choiceBoxHall.setValue(null);
								choiceBoxSeats.setValue(null);
								textAreaPayment.setText("");
								textAreaNameCustomer.setText("");
								statusOrder.setText("");
								firstCircle.setVisible(false);
								secondCircle.setVisible(false);
								thirdCircle.setVisible(false);
							}

						}
					});

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			firstCircle.setVisible(true);
			secondCircle.setVisible(true);
			thirdCircle.setVisible(true);
			statusOrder.setVisible(true);
			statusOrder.setText(
					"Δεν μπορεί να επιβεβαιωθεί η κράτηση ,χρήστη " + ControllerLogIn.getEmployee().getUserName());

		}

	}

}
