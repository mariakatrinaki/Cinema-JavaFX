package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ReservationMovieController implements Initializable {
	
	@FXML
	Button firstSeat;
	
	@FXML
	Button secondSeat;
	
	@FXML
	Button thirdSeat;
	
	@FXML
	Button fourthSeat;
	
	@FXML
	Button fiveSeat;
	
	@FXML
	Button sixSeat;
	
	@FXML
	Button sevenSeat;
	
	@FXML
	Button eightSeat;
	
	@FXML
	Button nineSeat;
	
	@FXML
	Button tenSeat;
	
	@FXML
	Button elevenSeat;
	
	@FXML
	Button twelveSeat;
	
	@FXML
	Button btnPurchaseTicket;
	
	@FXML
	Label labelStatus;
	
	public String position;
	
	@FXML
	Label labelFirst;
	
	@FXML
	Label labelSecond;
	
	@FXML
	Label labelThird;
	
	@FXML
	Label labelFourth;
	
	@FXML
	Label labelFive;
	
	@FXML
	Label labelSix;
	
	@FXML
	Label labelSeven;
	
	@FXML
	Label labelEight;
	
	@FXML
	Label labelNine;
	
	@FXML
	Label labelTen;
	
	@FXML
	Label labelEleven;
	
	@FXML
	Label labelTwelve;
	
	@FXML
	ImageView imageFirstSeat;
	
	@FXML
	ImageView imageSecondSeat;
	
	@FXML
	ImageView imageThirdSeat;
	
	@FXML
	ImageView imageFourthSeat;
	
	@FXML
	ImageView imageFiveSeat;
	
	@FXML
	ImageView imageSixSeat;
	
	@FXML
	ImageView imageSevenSeat;
	
	@FXML
	ImageView imageEightSeat;
	
	@FXML
	ImageView imageNineSeat;
	
	@FXML
	ImageView imageTenSeat;
	
	@FXML
	ImageView imageElevenSeat;
	
	@FXML
	ImageView imageTwelveSeat;
	
	
	@FXML
	public void purchaseTicket(ActionEvent event) {
		
			if((firstSeat.getStyle().contains("white")) &&
				secondSeat.getStyle().contains("white") &&
				secondSeat.getStyle().contains("white") &&
				thirdSeat.getStyle().contains("white")  &&
				fourthSeat.getStyle().contains("white") &&
				fiveSeat.getStyle().contains("white") &&
				sixSeat.getStyle().contains("white") &&
				sevenSeat.getStyle().contains("white")&&
				eightSeat.getStyle().contains("white")&&
				nineSeat.getStyle().contains("white")&&
				tenSeat.getStyle().contains("white")&&
				elevenSeat.getStyle().contains("white")&&
				twelveSeat.getStyle().contains("white"))
				
					{
						labelStatus.setText("Δεν μπορεί να γίνει κράτηση χωρίς να επιλέξετε θέση");
						
					}
			else {
				try {
					Stage stage = new Stage();
					Parent root = null;

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PurchaseTicket.fxml"));

					root = fxmlLoader.load();

					stage.resizableProperty().setValue(Boolean.FALSE);
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setScene(new Scene(root));
					stage.show();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		
		
		
		
		
	}
	
	
	public void Select_DeselectSeat() {
		firstSeat.setOnAction(event ->{
			
			 if("-fx-background-color: Red".equals(firstSeat.getStyle())){          
		         firstSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelFirst.getText())) {
		        	 position =position.replace(", "+labelFirst.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		     }else{
		         firstSeat.setStyle("-fx-background-color: Red");
		         position = position+", "+labelFirst.getText();
		         labelStatus.setText(position);
		         
		     }
			
		});
		
		secondSeat.setOnAction(event ->{
			 if("-fx-background-color: Red".equals(secondSeat.getStyle())){          
		         secondSeat.setStyle("-fx-background-color: White");
		         if(position.contains(labelSecond.getText())) {
		        	 position =position.replace(", "+labelSecond.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		        
		     }else{
		         secondSeat.setStyle("-fx-background-color: Red");  
		         position = position+", "+labelSecond.getText();
		         labelStatus.setText(position);
		     }
			
			
		});
	    
		thirdSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(thirdSeat.getStyle())){          
		         thirdSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelThird.getText())) {
		        	 position =position.replace(", "+labelThird.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		         
		     }else{
		         thirdSeat.setStyle("-fx-background-color: Red"); 
		         position = position+", "+labelThird.getText();
		         labelStatus.setText(position);
		     }
			
			
		});
		
		fourthSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(fourthSeat.getStyle())){          
		         fourthSeat.setStyle("-fx-background-color: White");  
		         if(position.contains(labelFourth.getText())) {
		        	 position =position.replace(", "+labelFourth.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		         
		     }else{
		         fourthSeat.setStyle("-fx-background-color: Red");  
		         position = position+", "+labelFourth.getText();
		         labelStatus.setText(position);
		     }
			
		});
		
		fiveSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(fiveSeat.getStyle())){          
		         fiveSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelFive.getText())) {
		        	 position =position.replace(", "+labelFive.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		         
		     }else{
		         fiveSeat.setStyle("-fx-background-color: Red"); 
		         position = position+", "+labelFive.getText();
		         labelStatus.setText(position);
		     }
			
		});
		
		sixSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(sixSeat.getStyle())){          
		         sixSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelSix.getText())) {
		        	 position =position.replace(", "+labelSix.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		     }else{
		         sixSeat.setStyle("-fx-background-color: Red"); 
		         position = position+", "+labelSix.getText();
		         labelStatus.setText(position);
		     }
			
		});
		
		sevenSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(sevenSeat.getStyle())){          
		         sevenSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelSeven.getText())) {
		        	 position =position.replace(", "+labelSeven.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		     }else{
		         sevenSeat.setStyle("-fx-background-color: Red"); 
		         position = position+", "+labelSeven.getText();
		         labelStatus.setText(position);
		     }
			
		});
		
		eightSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(eightSeat.getStyle())){          
		         eightSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelEight.getText())) {
		        	 position =position.replace(", "+labelEight.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		     }else{
		         eightSeat.setStyle("-fx-background-color: Red");
		         position = position+", "+labelEight.getText();
		         labelStatus.setText(position);
		     }
			
		});
		
		nineSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(nineSeat.getStyle())){          
		         nineSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelNine.getText())) {
		        	 position =position.replace(", "+labelNine.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		     }else{
		         nineSeat.setStyle("-fx-background-color: Red");
		         position = position+", "+labelNine.getText();
		         labelStatus.setText(position);
		     }
			
		});
		tenSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(tenSeat.getStyle())){          
		         tenSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelTen.getText())) {
		        	 position =position.replace(", "+labelTen.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		     }else{
		         tenSeat.setStyle("-fx-background-color: Red"); 
		         position = position+", "+labelTen.getText();
		         labelStatus.setText(position);
		     }
			
		});
		
		elevenSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(elevenSeat.getStyle())){          
		         elevenSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelEleven.getText())) {
		        	 position =position.replace(", "+labelEleven.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		     }else{
		         elevenSeat.setStyle("-fx-background-color: Red");
		         position = position+", "+labelEleven.getText();
		         labelStatus.setText(position);
		     }
			
		});
		twelveSeat.setOnAction(event->{
			 if("-fx-background-color: Red".equals(twelveSeat.getStyle())){          
		         twelveSeat.setStyle("-fx-background-color: White"); 
		         if(position.contains(labelTwelve.getText())) {
		        	 position =position.replace(", "+labelTwelve.getText()," ");
		        	 
		        	
		         }
		         labelStatus.setText(position);
		         
		         
		     }else{
		         twelveSeat.setStyle("-fx-background-color: Red");  
		         position = position+", "+labelTwelve.getText();
		         labelStatus.setText(position);
		     }
			
		});
		
		
		
	}
	
	
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image imageSeat = new Image("cinemaSeat.png");
		imageFirstSeat.setImage(imageSeat);
		imageSecondSeat.setImage(imageSeat);
		imageThirdSeat.setImage(imageSeat);
		imageFourthSeat.setImage(imageSeat);
		imageFiveSeat.setImage(imageSeat);
		imageSixSeat.setImage(imageSeat);
		imageSevenSeat.setImage(imageSeat);
		imageEightSeat.setImage(imageSeat);
		imageNineSeat.setImage(imageSeat);
		imageTenSeat.setImage(imageSeat);
		imageElevenSeat.setImage(imageSeat);
		imageTwelveSeat.setImage(imageSeat);
		
		 position=labelStatus.getText();
		Select_DeselectSeat();
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
}
