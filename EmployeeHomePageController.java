package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class EmployeeHomePageController implements Initializable{

	@FXML
	AnchorPane mainPane;
	
	@FXML
	private BorderPane mainWindow;
	
	@FXML
	private AnchorPane homeScene;
	
	private Stage stage = null;
	
	double progress;
	
	@FXML
	ChoiceBox choiceBoxSeat;
	
	@FXML
	ChoiceBox choiceBoxHall;
	
	@FXML
	TextArea TextAreaProducts;
	
	@FXML
	ImageView imageViewEmployee;
	
	@FXML
	Circle firstCircle;
	
	@FXML
	Circle secondCircle;
	
	@FXML
	Circle thirdCircle;
	
	
	@FXML
	 Label statusOrder;
	
	
	boolean isFinished = false;
	 
	private static String selectedHall;
	
	private static String selectedSeat;
	 
	 




	private String [] halls = {"Αίθουσα 1","Αίθουσα 2","Αίθουσα 3","Αίθουσα 4"};
	
	private String [] seats= {"Θέση 1","Θέση 2","Θέση 3","Θέση 4","Θέση 5","Θέση 6","Θέση 7",
			"Θέση 8","Θέση 9","Θέση 10","Θέση 11"};
	
	
	@SuppressWarnings("unchecked")
	@FXML
	private void handleHomeButton(ActionEvent event) {
		
		
		mainWindow.setCenter(homeScene);
		choiceBoxSeat.setValue(null);
        choiceBoxHall.setValue(null);
        TextAreaProducts.setText(" ");
        firstCircle.setVisible(false);
		secondCircle.setVisible(false);
		thirdCircle.setVisible(false);
		statusOrder.setVisible(false);
		
	}
	
	@FXML
	private void handleCheckTicketsButton(ActionEvent event) {

		AnchorPane view = loadPage("CheckTickets.fxml");
		
		mainWindow.setCenter(view);

	}
	
	@FXML
	private void handleDevicesButton(ActionEvent event) {

		AnchorPane view = loadPage("HandlingDevicesEmployee.fxml");

		mainWindow.setCenter(view);

	}
	
	@FXML
	private void handleCleanHallSeatstButton(ActionEvent event) {

		AnchorPane view = loadPage("CleanHallsSeatsEmployee.fxml");

		mainWindow.setCenter(view);

	}
	
	
	
	
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
	
	@FXML
	public void confirmOrder(ActionEvent event) {
		
		//System.out.println(choiceBoxSeats.getValue()+" "+choiceBoxClasses.getValue()+" "+TextAreaProducts.getText());
		
		if((choiceBoxSeat.getValue()!=null && choiceBoxHall.getValue()!=null) && !TextAreaProducts.getText().equals("Δεν υπάρχει παραγγελία")) {
			
			
			try {
				Stage stage1= new Stage();
				Parent root = null;

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConfirmationBoxOrderByEmployee.fxml"));

				root = fxmlLoader.load();
				ConfirmationBoxOrderByEmployeeController confirmationBoxOrderByEmployeeController = fxmlLoader.getController();
				confirmationBoxOrderByEmployeeController.getTextOrder().setText(String.valueOf(choiceBoxHall.getValue())+"\n"+ String.valueOf(choiceBoxSeat.getValue())+
						"\nΠροιόντα: "+"\n"+TextAreaProducts.getText());
				
				
				if (root != null) {

					stage1.setScene(new Scene(root));
					
					stage1.initModality(Modality.APPLICATION_MODAL);
					stage1.initStyle(StageStyle.UTILITY);
					
					stage1.show();
					
					
					stage1.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
					      @SuppressWarnings("unchecked")
						public void handle(WindowEvent event) {
					    	  if(confirmationBoxOrderByEmployeeController.getIsFinished()==false){
					    		  event.consume();
					    		  confirmationBoxOrderByEmployeeController.getStatusOrder().setText("Δεν έχει ολοκληρωθεί η παραγελία!!");
								}else {
					          System.out.println("Stage is closing");
					          choiceBoxSeat.setValue(null);
					          choiceBoxHall.setValue(null);
					          TextAreaProducts.setText(" ");
					          statusOrder.setVisible(false);
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

		
				
		}else {
			statusOrder.setText("Δεν υπάρχει παραγγελία προς εκτέλεση");
			
		}
		
		
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		choiceBoxSeat.getItems().addAll(seats);
		choiceBoxHall.getItems().addAll(halls);
		 
		Image imageEmployee = new Image("imageEmployee.png");
		
		 imageViewEmployee.setImage(imageEmployee);
		 firstCircle.setVisible(false);
		 secondCircle.setVisible(false);
		 thirdCircle.setVisible(false);
		statusOrder.setVisible(false); 
		
		
		 
		 
		 
		 
	
		
		choiceBoxSeat.setOnAction(event -> {

			if(choiceBoxSeat.getSelectionModel().getSelectedItem()!=null  && choiceBoxHall.getSelectionModel().getSelectedItem()!=null) {
				
			 TextAreaProducts.setText( getRandomString());
			 TextAreaProducts.setStyle("-fx-font-size: 14 ; -fx-font-weight:bold;");
			 if(TextAreaProducts.getText().equals("Δεν υπάρχει παραγγελία"))
			 {
				 firstCircle.setVisible(true);
				 secondCircle.setVisible(true);
				 thirdCircle.setVisible(true);
				 statusOrder.setVisible(true); 
				 statusOrder.setText("Δεν υπάρχει παραγγελία προς εκτέλεση"); 
			 }else {
				 firstCircle.setVisible(true);
				 secondCircle.setVisible(true);
				 thirdCircle.setVisible(true);
				 statusOrder.setVisible(true); 
				
			statusOrder.setText("Επιβεβαίωσε την παραγγελία, χρήστη: "+ControllerLogIn.getEmployee().getUserName());
			 }
			 }else if(choiceBoxSeat.getSelectionModel().getSelectedItem()==null &&choiceBoxHall.getSelectionModel().getSelectedItem()!=null) {
				 firstCircle.setVisible(true);
				 secondCircle.setVisible(true);
				 thirdCircle.setVisible(true);
				 statusOrder.setVisible(true); 
				 statusOrder.setText("Επιλέξτε αριθμό θέσης"); 
			 }else if(choiceBoxHall.getSelectionModel().getSelectedItem()==null && choiceBoxSeat.getSelectionModel().getSelectedItem()!=null) {
				 firstCircle.setVisible(true);
				 secondCircle.setVisible(true);
				 thirdCircle.setVisible(true);
				 statusOrder.setVisible(true); 
				 statusOrder.setText("Επιλέξτε αριθμό Αίθουσας"); 
			 }else {
				 firstCircle.setVisible(true);
				 secondCircle.setVisible(true);
				 thirdCircle.setVisible(true);
				 statusOrder.setVisible(true); 
				 statusOrder.setText("Παρακαλώ επιλέξτε και αριθμό Αίθουσας και αριθμό Θέσης"); 
				 
			 }
			
			
        });
		
		choiceBoxHall.setOnAction(event -> {
			
			if(choiceBoxHall.getSelectionModel().getSelectedItem()!=null  && choiceBoxSeat.getSelectionModel().getSelectedItem()!=null) {
				 
				 TextAreaProducts.setText( getRandomString());
				TextAreaProducts.setStyle("-fx-font-size: 14 ; -fx-font-weight:bold;");
				 if(TextAreaProducts.getText().equals("Δεν υπάρχει παραγγελία"))
				 {
					 firstCircle.setVisible(true);
					 secondCircle.setVisible(true);
					 thirdCircle.setVisible(true);
					 statusOrder.setVisible(true); 
					 statusOrder.setText("Δεν υπάρχει παραγγελία προς εκτέλεση"); 
				 }else {
					 firstCircle.setVisible(true);
					 secondCircle.setVisible(true);
					 thirdCircle.setVisible(true);
					 statusOrder.setVisible(true); 
					 
				statusOrder.setText("Επιβεβαίωσε την παραγγελία χρήστη: "+ControllerLogIn.getEmployee().getUserName());
				 }
				}else if(choiceBoxSeat.getSelectionModel().getSelectedItem()==null &&choiceBoxHall.getSelectionModel().getSelectedItem()!=null) {
					 firstCircle.setVisible(true);
					 secondCircle.setVisible(true);
					 thirdCircle.setVisible(true);
					 statusOrder.setVisible(true); 
					 statusOrder.setText("Επιλέξτε αριθμό θέσης"); 
				 }else if(choiceBoxHall.getSelectionModel().getSelectedItem()==null && choiceBoxSeat.getSelectionModel().getSelectedItem()!=null) {
					 firstCircle.setVisible(true);
					 secondCircle.setVisible(true);
					 thirdCircle.setVisible(true);
					 statusOrder.setVisible(true); 
					 statusOrder.setText("Επιλέξτε αριθμό Αίθουσας"); 
				 }else {
					 firstCircle.setVisible(true);
					 secondCircle.setVisible(true);
					 thirdCircle.setVisible(true);
					 statusOrder.setVisible(true); 
					 statusOrder.setText("Παρακαλώ επιλέξτε και αριθμό Αίθουσας και αριθμό Θέσης"); 
					 
				 }
			 
       });
		}
		
	
	
	
	
	
	
	static String getRandomString(){
		String [] listProducts =  {"Δεν υπάρχει παραγγελία","Lemonade","Water","CocaCola","Sprite",
				"OrangeJuice","CherryJuice","Water 100ml","Chips","popCorn","Candy",
				"Cookies","IceCream","Donats","Toast"};
		String [] listQuantity = {"1","2","3"};
		
		int count =0;
		int randomNum = 1 + (int)(Math.random() * 5);
		
		 String products="";
		while (count<= randomNum) {
		
        int product = 0 + (int) (Math.random()*14);
        int quantity = 0 + (int) (Math.random()*2);
        
        if(!products.contains(listProducts[product])) {
        products += listProducts[product]+" ποσότητα: "+listQuantity[quantity]+"\n";
        System.out.println(products);
        
         if(products.contains("Δεν υπάρχει παραγγελία")) {
        	         	 
        	 products = listProducts[product] ;     
        	 if(!listProducts[product].equals("Δεν υπάρχει παραγγελία")) {
        		 products = listProducts[product] +" ποσότητα: "+listQuantity[quantity]+"\n";
        		 
        	 }
        	 count++;
         }
         count++;
        }
        
        
		}
		 
		
		
        return products;
    }
	
	
	
	
}
