package application;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RecentMoviesController {

	@FXML
	private HBox box;

	@FXML
	private ImageView imageCruella;

	@FXML
	private Button btnMovie;

	@FXML
	private Label movieName;

	@FXML
	private Label movieDirector;

	static Movies movieObj;

	static ArrayList<Movies> movies;

 //	private String [] colors= {""};
	
   	Stage stage = new Stage();

	public void setData(Movies movie) {
		
		
		// Image image = new
		// Image(getClass().getClassLoader().getResourceAsStream(movie.getImageSrc()));
		String theme1Url = getClass().getResource("/" + movie.getImageSrc()).toExternalForm();
		Image image = new Image(theme1Url);
		imageCruella.setImage(image);
		btnMovie.setGraphic(imageCruella);
		btnMovie.getStyleClass().add("mov1");
		stage.initStyle(StageStyle.UTILITY);
		stage.initModality(Modality.APPLICATION_MODAL);
		btnMovie.setOnAction(event -> {
			try {
				Parent root = null;

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MovieDetails.fxml"));

				root = fxmlLoader.load();

				MovieDetailsController movieDetailsController = fxmlLoader.getController();
				  
				movieDetailsController.getMovieTitle().setText(movie.getName().trim());
				movieDetailsController.getMoviePlot().setText(movie.getPlot().trim());
				movieDetailsController.getMovieStars().setText(movie.getActors());
				movieDetailsController.getMovieDir().setText(movie.getDirector());
				movieDetailsController.getHoursDisplay().setText(movie.getHoursDisplay());
				movieDetailsController.getMoviePrice().setText(movie.getPrice());
				movieDetailsController.getMovieRate().setText(movie.getCritics());
				
				movieDetailsController.setImage(movie.getImageSrc());
				movieDetailsController.getImageView().setImage(movieDetailsController.getImage());
				Platform.setImplicitExit(false);
				stage.setScene(new Scene(root));
				
				
				stage.showAndWait();
				
			
				

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		 
		stage.close();

		movieName.setText(movie.getName());
		movieDirector.setText(movie.getDirector());

	}
	
	
	

	public static Movies getMovie() {
		
		return movieObj;
	}

}
