package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MovieDetailsController implements Initializable {

	@FXML
	Label movieTitle;

	@FXML
	Label moviePlot;

	@FXML
	Label moviePrice;

	@FXML
	Label movieStars;

	@FXML
	Label movieDir;

	@FXML
	Label movieRate;
	
	@FXML
	Label hoursDisplay;

	@FXML
	ImageView imageView;

	Image image;

	
	
	
	
	
	
	public void setImage(String imagePath) {
		String path = getClass().getResource("/" + imagePath).toExternalForm();
		image = new Image(path);

	}

	public Image getImage() {

		return image;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public Label getMovieDir() {
		return movieDir;
	}

	public Label getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String text) {

		movieTitle.setText(text);

	}

	public Label getMoviePlot() {
		return moviePlot;
	}

	public void setMoviePlot(Label moviePlot) {
		this.moviePlot = moviePlot;
	}

	public Label getMoviePrice() {
		return moviePrice;
	}

	public void setMoviePrice(Label moviePrice) {
		this.moviePrice = moviePrice;
	}

	public Label getMovieStars() {
		return movieStars;
	}

	public void setMovieStars(Label movieStars) {
		this.movieStars = movieStars;
	}

	public void setMovieDir(Label movieDir) {
		this.movieDir = movieDir;
	}

	public Label getMovieRate() {
		return movieRate;
	}

	public void setMovieRate(Label movieRate) {
		this.movieRate = movieRate;
	}
	
	
	public Label getHoursDisplay() {
		return hoursDisplay;
	}

	public void setHoursDisplay(Label hoursDisplay) {
		this.hoursDisplay = hoursDisplay;
	}

	@FXML
   public void btnSelectSeat(ActionEvent event) {
		try {
		Stage stage = new Stage();
		Parent root = null;

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReservationMovie.fxml"));

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
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// getMovieTitle();

	}

}
