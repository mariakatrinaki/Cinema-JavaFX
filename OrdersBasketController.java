package application;

import application.Products;
import application.OrdersController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OrdersBasketController implements Initializable {

	@FXML
	Label labelOrders;

	@FXML
	Label orderComplete;

	@FXML
	ListView<String> myListViewFoods;

	@FXML
	AnchorPane anchorPane;

	ArrayList<Integer> numbers = new ArrayList<Integer>();

	private Stage stage;

	@FXML
	TextArea textAreaOrder;

	String informationOfOrders;

	int min, max, i = 0;

	String products="";
	
	@FXML
	ImageView imageCloseButton ;
	
	
	
   Text textInformationProducts = new Text();
	


	@FXML
	public void handleCloseButton(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("You are about to exit!");
		alert.setContentText("Do you want to exit? ");

		if (alert.showAndWait().get() == ButtonType.OK) {

			stage = (Stage) anchorPane.getScene().getWindow();
			stage.close();
		}

	}

	public void setOrderInformation(Text text) {
			   
     textAreaOrder.setText(text.getText());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	//	Image closeButton = new Image ("closeButton.png");
	//	imageCloseButton.setImage(closeButton);
	//	closeBtn.setGraphic(imageCloseButton);
		
		labelOrders.setText("Καλάθι αγορών του χρήστη " + OrdersController.getUser().getUserName());
		orderComplete.setText("H παραγγελία σου διεκπαιρεώθηκε");
         
		for (Orders or : OrdersController.getUser().getNumberOfOrder()) {

			myListViewFoods.getItems().addAll("Παραγγελία: " + or.getNumber());
		}
         
		

		
		myListViewFoods.setStyle("-fx-font-size: 1.5em ;");

		myListViewFoods.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> args0, String oldOrder, String newOrder) {

				informationOfOrders = myListViewFoods.getSelectionModel().getSelectedItem();

				for (Orders or : OrdersController.getUser().getNumberOfOrder()) {

					if (informationOfOrders.contains(String.valueOf(or.getNumber()))) {
						
						for (Products fd : or.getProducts()) {
                              
							products += String.valueOf(fd.getProduct())+" ποσότητα: "+String.valueOf(fd.getQuantite())+"\n";
													 
						}
						

				}   
					textInformationProducts.setText(products);
					
					 System.out.println(textInformationProducts.getText());
					setOrderInformation(textInformationProducts);
				
				OrdersController.getUser().getNumberOfOrder().get(0).getProducts().clear();
				
				

			}
			}
		});

	}
}