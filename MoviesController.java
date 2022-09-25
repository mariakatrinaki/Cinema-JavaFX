package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MoviesController implements Initializable {

	Group group = new Group();

	@FXML
	AnchorPane anchorPane;

	@FXML
	HBox layOutSoon;

	@FXML
	HBox hBoxMovieSelected;

	List<Movies> recentlyAdd;

	@FXML
	CheckBox choiceKids;

	@FXML
	CheckBox choiceAnimation;

	@FXML
	CheckBox choiceAdventure;

	@FXML
	CheckBox choiceFun;

	@FXML
	CheckBox choiceMystery;

	@FXML
	CheckBox choiceDrama;

	@FXML
	CheckBox choiceCrime;


	
     boolean value = false;

	private List<Movies> previews;
	private List<String> userSelections;
	private List<Movies> movies;

	ArrayList<HBox> clearmovieKids = new ArrayList<HBox>();
	ArrayList<HBox> clearMovieAdventure = new ArrayList<HBox>();
	ArrayList<HBox> clearMovieMystery = new ArrayList<HBox>();
	ArrayList<HBox> clearMovieFun = new ArrayList<HBox>();
	ArrayList<HBox> clearMovieDrama = new ArrayList<HBox>();
	ArrayList<HBox> clearMovieCrime = new ArrayList<HBox>();
	
	ArrayList<CheckBox> list = new ArrayList<CheckBox>();

	Set<Movies> setKids = new HashSet<Movies>();
	Set<Movies> setFun = new HashSet<Movies>();

	int movieKidsCounter = 0;
	int movieAdventureCounter = 0;
	int movieFunCounter = 0;
	int movieMysteryCounter = 0;
	int movieDramaCounter = 0;
	int movieCrimeCounter = 0;
	boolean movieFunDisplay = false;
	boolean movieMysteryDisplay = false;
	boolean movieAdventureDisplay = false;
	boolean movieCrimeDisplay = false;
	boolean movieDramaDisplay = false;
	boolean movieKidsDisplay = false;
	boolean movieMysteryOne = false;
	boolean movieAdventureOne = false;
	boolean movieMysteryAndAdventure = false;
	boolean movieAdventureAndMystery = false;

	static Movies movie1 = new Movies();
	static Movies movie2 = new Movies();
	static Movies movie3 = new Movies();
	static Movies movie4 = new Movies();
	static Movies movie5 = new Movies();
	static Movies movie6 = new Movies();
	static Movies movie7 = new Movies();
	static Movies movie8 = new Movies();
	static Movies movie9 = new Movies();

	static MoviesController mc = new MoviesController();

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		recentlyAdd = new ArrayList<Movies>(soonMovies());

		try {
			for (int i = 0; i <= recentlyAdd.size() - 1; i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();

				fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
				HBox hboxMoview = fxmlLoader.load();
				RecentMoviesController recentMoviesController = fxmlLoader.getController();
				recentMoviesController.setData(soonMovies().get(i));
				layOutSoon.getChildren().add(hboxMoview);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		mc.addMovie(movie1);
		mc.addMovie(movie2);
		mc.addMovie(movie3);
		mc.addMovie(movie4);
		mc.addMovie(movie5);
		mc.addMovie(movie6);
		mc.addMovie(movie7);
		mc.addMovie(movie8);
		mc.addMovie(movie9);

	}



	public static List<Movies> soonMovies() {
		List<Movies> ls = new ArrayList<Movies>();

		movie1.setImageSrc("cruella.jpg");
		movie1.setName("Cruella");
		movie1.setPlot("A live-action " + "prequel feature film\n" + "following a young" + " Cruella de Vil.");
		movie1.setActors("Emma Stone, \n" + "Emma Thompson,\n" + " Joel Fry ");
		movie1.setDirector("Craig\r\n" + "Gillespie");
		movie1.setHoursDisplay("17:00-19:00 μμ");
		movie1.setPrice("10 Euros");
		movie1.setCritics("7.4");
		movie1.setCategory("Κωμωδία");

		ls.add(movie1);

		movie2.setImageSrc("knivesOut.jpg");
		movie2.setName("Knives\n Out");
		movie2.setPlot("A detective investigates"+ "the death\n of a patriarch of an eccentric\n" +" ,combative family.");
		movie2.setActors("Daniel Graig");
		movie2.setDirector("Rian Johnson");
		movie2.setHoursDisplay("19:00-20:30μμ");
		movie2.setPrice("11 Euros");
		movie2.setCritics("9");
		movie2.setCategory("Μυστηρίου");
		ls.add(movie2);

		movie3.setImageSrc("smallfoot.jpg");
		movie3.setName("Small\n Foot");
		movie3.setPlot("A Yeti is convinced that the elusive\n creatures known as humans\n really do exist.");
		movie3.setActors("Channing Tatum, James Corden, Zendaya.");
		movie3.setDirector("Karey Kirkpat");
		movie3.setHoursDisplay("11:00-13:00 μμ");
		movie3.setPrice("8 Euros");
		movie3.setCritics("9,5");
		movie3.setCategory("Παιδικά");
		movie3.setCategory("Animation");
		

		ls.add(movie3);

		movie4.setImageSrc("the man who sold his skin.jpg");
		movie4.setName("The Man\n who sold\n his skin");
		movie4.setPlot("Sam, a Syrian refugee, will soon realize\nto have sold away more than just his skin.");
		movie4.setActors("Yahya Mahayni, Dea Liane,\nKoen De Bouw, Monica Bellucci");
		movie4.setDirector("Kaouther\nBen Hania");
		movie4.setHoursDisplay("21:00-22:30μμ");
		movie4.setPrice("13 Euros");
		movie4.setCritics("8");
		movie4.setCategory("Αστυνομική");

		ls.add(movie4);

		movie5.setImageSrc("blackWidow.jpg");
		movie5.setName("Black\n Widow");
		movie5.setPlot("Natasha Romanoff confronts the darker parts of her\n ledger when a dangerous conspiracy with ties to her\npast arises.");
		movie5.setActors("Scarlet Yohanson, Florence Pugh, Rachel Weisz");
		movie5.setDirector("Cate\n Shortland");
		movie5.setHoursDisplay("19:00-20:30μμ");
		movie5.setPrice("12 Euros");
		movie5.setCritics("7,6");
		movie5.setCategory("Περιπέτεια");

		ls.add(movie5);

		movie6.setImageSrc("spongeBob.jpg");
		movie6.setName("The\nSpong\n BoB\nMovie");
		movie6.setPlot("SpongeBob's and Patrick embark on an epic\n adventure to The Lost City to bring Gary home.");
		movie6.setActors("Tim Hill, Clancy Brown, Bill Fagerbakke");
		movie6.setDirector("Tim Hill");
		movie6.setHoursDisplay("11:00-13:00 μμ");
		movie6.setPrice("8 Euros");
		movie6.setCritics("9");
		movie6.setCategory("Παιδικά");
		movie6.setCategory("Animation");

		ls.add(movie6);

		movie7.setImageSrc("jungleCruise.jpg");
		movie7.setName("Jungle\n Cruise");
		movie7.setPlot("A small riverboat takes a group of travelers\n through a jungle filled with dangerous animals.");
		movie7.setActors("Dwayne Johnson, Emily Blunt, Edgar Ramirez");
		movie7.setDirector("Jaume\nCollet-Serra");
		movie7.setHoursDisplay("19:00-20:30μμ");
		movie7.setPrice("12 Euros");
		movie7.setCritics("8");
		movie7.setCategory("Περιπέτεια");
		movie7.setCategory("Μυστηρίου");

		ls.add(movie7);

		movie8.setImageSrc("joker.jpg");
		movie8.setName("Joker");
		movie8.setPlot("In Gotham City, mentally troubled comedian Arthur\nFleckis disregarded and mistreated by society.");
		movie8.setActors("Joaquin Phoenix, Robert De Niro, Zazie Beetz");
		movie8.setDirector("Todd Phillips");
		movie8.setHoursDisplay("21:00-22:30μμ");
		movie8.setPrice("13 Euros");
		movie8.setCritics("10");
		movie8.setCategory("Δραματική");

		ls.add(movie8);

		movie9.setImageSrc("coco.jpg");
		movie9.setName("Coco");
		movie9.setPlot("Musician Miguel, confronted with his family's\nancestral ban on music, enters the Land of the Dead\n to find his great-great-grandfather.");
		movie9.setActors("Anthony Gonzalez, Gael García Bernal,\nBenjamin Bratt");
		movie9.setDirector("Lee Unkrichr");
		movie9.setHoursDisplay("11:00-13:00 μμ");
		movie9.setPrice("8 Euros");
		movie9.setCritics("8");
		movie9.setCategory("Παιδικά");
		movie9.setCategory("Animation");
		
		ls.add(movie9);

		return ls;

	}

	public MoviesController() {
		previews = new ArrayList<Movies>();
		userSelections = new ArrayList<String>();
		movies = new ArrayList<Movies>();

	}

	public void sethBoxMovieSelected(HBox hBoxMovieSelected) {
		this.hBoxMovieSelected.getChildren().add(hBoxMovieSelected);
	}

	public HBox gethBoxMovieSelected() {
		return hBoxMovieSelected;
	}

	// ---------------------------------
	public void showUserSelections() {
		System.out.println();
		if (!userSelections.isEmpty()) {
			for (String s : userSelections) {
				System.out.print("[x] " + s + " | ");
			}
			System.out.println();
		} else {
			System.out.println("Please select categories of your choice");
		}
	}

	// ---------------------------------
	public void addUserSelections(String select) {
		if (!userSelections.contains(select)) {
			userSelections.add(select);

			for (Movies m : movies) {
				if (m.checkIfCategorieExist(select)) {
					addPreviews(m);
				}
			}
		}
	}

	// ---------------------------------
	public void addMovie(Movies m) {
		if (!movies.contains(m)) {
			movies.add(m);
		}

	}

	// ---------------------------------
	public void removeSelection(String select) {

		// remove category for user selections
		if (userSelections.contains(select)) {
			userSelections.remove(select);

			previews.clear(); // clear previews

			// fill previews with movies that have the categories list
			for (String s : userSelections) {
				for (Movies m : movies) {
					if (m.checkIfCategorieExist(s)) {
						previews.add(m);
					}
				}
			}
		}

	}

	// ---------------------------------
	public void addPreviews(Movies movie) {
		if (!previews.contains(movie)) {
			previews.add(movie);
		}
	}

	// ---------------------------------
	private void removePreviews(Movies movie) {
		if (previews.contains(movie)) {
			previews.remove(movie);
		}

	}

	// ---------------------------------
	public ArrayList<Movies> showPreviews() {
		ArrayList<Movies> movies = new ArrayList<Movies>();
		if (!previews.isEmpty()) {
			for (Movies m : previews) {
				movies.add(m);
			}
		}

		return movies;
	}

	@FXML
	public void btnClearSelectedMoviesDisplay(ActionEvent event) {

		if (choiceKids.isSelected() == false && choiceAnimation.isSelected() == false) {
			for (HBox l : clearmovieKids) {
				l.setVisible(false);
				l.setManaged(false);
			}

			if (setKids != null) {
				setKids.clear();
			}
			movieKidsCounter = 0;
			movieKidsDisplay = false;

		}
		if (choiceAdventure.isSelected() == false
				&& (movieAdventureDisplay == true || movieAdventureDisplay == false)) {

			for (HBox l : clearMovieAdventure) {
				l.setVisible(false);
				l.setManaged(false);

			}
			choiceAdventure.setSelected(false);
			movieAdventureDisplay = false;
			movieAdventureCounter = 0;
			movieAdventureOne = false;
			movieAdventureAndMystery = false;
		}
		if (choiceMystery.isSelected() == false && (movieMysteryDisplay == true || movieMysteryDisplay == false)) {
			for (HBox l : clearMovieMystery) {
				l.setVisible(false);
				l.setManaged(false);

			}
			choiceMystery.setSelected(false);
			movieMysteryDisplay = false;
			movieMysteryCounter = 0;
			movieMysteryOne = false;
			movieMysteryAndAdventure = false;

		}
		if (choiceFun.isSelected() == false && movieFunDisplay == true) {

			for (HBox l : clearMovieFun) {
				l.setVisible(false);
				l.setManaged(false);
			}
			movieFunDisplay = false;
			movieFunCounter = 0;

		}if(choiceDrama.isSelected()== false ) {

			for (HBox l : clearMovieDrama) {
				l.setVisible(false);
				l.setManaged(false);
			}
			
			movieDramaDisplay = false;
			movieDramaCounter = 0;
			
		}if(choiceCrime.isSelected()== false ) {
			
			for (HBox l : clearMovieCrime) {
				l.setVisible(false);
				l.setManaged(false);
			}
			movieCrimeDisplay = false;
			movieCrimeCounter= 0;
			
		}
		

	}

	@FXML
	public void btnDisplaySelectedMovies(ActionEvent event) {
        
		if (choiceFun.isSelected() && movieFunCounter == 0) {

			mc.addUserSelections("Κωμωδία");
			mc.removeSelection("Παιδικά");
			mc.removeSelection("Animation");
			mc.removeSelection("Μυστηρίου");
			mc.removeSelection("Περιπέτεια");
			mc.removeSelection("Δραματική");
			mc.removeSelection("Αστυνομική");
			mc.showUserSelections();
			for (Movies m : mc.showPreviews()) {
				setFun.add(m);

			}
			for (Movies m : setFun) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader();

					fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
					HBox hboxMoview = fxmlLoader.load();
					RecentMoviesController recentMoviesController = fxmlLoader.getController();
					recentMoviesController.setData(m);
					clearMovieFun.add(hboxMoview);
					hBoxMovieSelected.getChildren().add(hboxMoview);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			movieFunDisplay = true;
			movieFunCounter++;
		}

		if (choiceKids.isSelected() || choiceAnimation.isSelected()) {
			if (movieKidsCounter == 0) {

				mc.addUserSelections("Παιδικά");
				mc.addUserSelections("Animation");
				mc.removeSelection("Μυστηρίου");
				mc.removeSelection("Περιπέτεια");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Δραματική");
				mc.removeSelection("Αστυνομική");

				mc.showUserSelections();
				for (Movies m : mc.showPreviews()) {
					setKids.add(m);

				}
				for (Movies m : setKids) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						hBoxMovieSelected.getChildren().add(hboxMoview);
						clearmovieKids.add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				movieKidsDisplay = true;
			}

			movieKidsCounter++;

		}

		if (choiceAdventure.isSelected() && choiceMystery.isSelected() == false) {

			if (choiceAdventure.isSelected() && movieAdventureCounter == 0 && movieAdventureDisplay == false
					&& choiceMystery.isSelected() == false) {
				System.out.println("hey");
				mc.addUserSelections("Περιπέτεια");
				mc.addPreviews(movie7);
				mc.addPreviews(movie5);
				mc.removeSelection("Μυστηρίου");
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Δραματική");
				mc.removeSelection("Αστυνομική");

				mc.showUserSelections();
				for (Movies m : mc.showPreviews()) {

					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						clearMovieAdventure.add(hboxMoview);
						hBoxMovieSelected.getChildren().add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				movieAdventureDisplay = true;

			} else if (choiceAdventure.isSelected() && movieAdventureOne == true && choiceMystery.isSelected() == false
					&& movieAdventureCounter == 1) {

				mc.addUserSelections("Περιπέτεια");
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");
				mc.removeSelection("Μυστηρίου");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Δραματική");
				mc.removeSelection("Αστυνομική");

				mc.showUserSelections();
				mc.removePreviews(movie5);
				mc.addPreviews(movie7);

				for (Movies m : mc.showPreviews()) {

					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						clearMovieAdventure.add(hboxMoview);
						hBoxMovieSelected.getChildren().add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				movieAdventureDisplay = true;
				movieMysteryDisplay = false;
				movieAdventureOne = false;

			}

			movieAdventureCounter++;

		}

		if (choiceMystery.isSelected() && choiceAdventure.isSelected() == false) {

			if (choiceMystery.isSelected() && movieMysteryCounter == 0 && movieMysteryDisplay == false
					&& choiceAdventure.isSelected() == false) {

				mc.addUserSelections("Μυστηρίου");

				mc.removeSelection("Περιπέτεια");
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Δραματική");
				mc.removeSelection("Αστυνομική");
				mc.addPreviews(movie7);
				mc.addPreviews(movie2);
				mc.showUserSelections();
				for (Movies m : mc.showPreviews()) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						clearMovieMystery.add(hboxMoview);
						hBoxMovieSelected.getChildren().add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}
					movieMysteryDisplay = true;
				}

			} else if (choiceMystery.isSelected() && movieMysteryOne == true && choiceAdventure.isSelected() == false
					&& movieMysteryCounter == 1) {

				mc.addUserSelections("Μυστηρίου");
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Περιπέτεια");
				mc.removeSelection("Δραματική");
				mc.removeSelection("Αστυνομική");

				mc.showUserSelections();

				if (mc.showPreviews().contains(movie7) && movieMysteryAndAdventure == true) {
					mc.removePreviews(movie7);

				} else {
					mc.addPreviews(movie7);
				}

				mc.removePreviews(movie2);

				for (Movies m : mc.showPreviews()) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						clearMovieMystery.add(hboxMoview);
						hBoxMovieSelected.getChildren().add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				movieMysteryDisplay = true;
				movieAdventureDisplay = false;
				movieMysteryOne = false;
			}
			movieMysteryCounter++;
		}
		if (choiceMystery.isSelected() && choiceAdventure.isSelected()) {
			System.out.println("movieMysteryDisplay " + movieMysteryDisplay);
			System.out.println("movieMysteryCounter " + movieMysteryCounter);
			System.out.println("movieAdventureDisplay " + movieMysteryDisplay);
			System.out.println("movieAdventureCounter " + movieAdventureCounter);

			if (movieMysteryDisplay == true && movieAdventureDisplay == false && movieAdventureCounter == 0) {

				mc.addUserSelections("Περιπέτεια");
				mc.showUserSelections();

				mc.removeSelection("Μυστηρίου");
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Δραματική");
				mc.removeSelection("Αστυνομική");

				if (movieMysteryOne == true) {

					mc.addPreviews(movie7);
					movieAdventureOne = false;

				} else {
					mc.removePreviews(movie7);
					movieAdventureOne = true;
				}

				for (Movies m : mc.showPreviews()) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						clearMovieAdventure.add(hboxMoview);
						hBoxMovieSelected.getChildren().add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				movieAdventureDisplay = true;
				movieAdventureCounter++;

			} else if (movieAdventureDisplay == true && movieMysteryDisplay == false && movieMysteryCounter == 0) {

				mc.addUserSelections("Μυστηρίου");
				mc.showUserSelections();
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Περιπέτεια");
				mc.removePreviews(movie7);
				if (movieAdventureOne == true) {
					mc.addPreviews(movie7);
					movieMysteryOne = false;

				} else {
					mc.removePreviews(movie7);
					movieMysteryOne = true;
				}

				for (Movies m : mc.showPreviews()) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						clearMovieMystery.add(hboxMoview);
						hBoxMovieSelected.getChildren().add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				movieMysteryDisplay = true;
				movieMysteryCounter++;

			} else if (movieAdventureDisplay == false && movieAdventureCounter == 0 && movieMysteryDisplay == false
					&& movieMysteryCounter == 0) {

				System.out.println("hey");
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Περιπέτεια");
				mc.addUserSelections("Μυστηρίου");
				mc.removeSelection("Δραματική");
				mc.removeSelection("Αστυνομική");
				if (!mc.showPreviews().contains(movie2)) {
					mc.addPreviews(movie2);
				}
				if (!mc.showPreviews().contains(movie7)) {
					mc.addPreviews(movie7);
				}

				for (Movies m : mc.showPreviews()) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						clearMovieMystery.add(hboxMoview);
						hBoxMovieSelected.getChildren().add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				mc.addUserSelections("Περιπέτεια");
				mc.removeSelection("Μυστηρίου");
				mc.removePreviews(movie7);

				for (Movies m : mc.showPreviews()) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						clearMovieAdventure.add(hboxMoview);
						hBoxMovieSelected.getChildren().add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				mc.showUserSelections();

				movieMysteryCounter++;
				movieMysteryDisplay = true;
				movieMysteryOne = true;
				movieAdventureOne = true;
				movieAdventureCounter++;
				movieAdventureDisplay = true;
				movieMysteryAndAdventure = true;
				movieAdventureAndMystery = true;

			}

		}if (choiceDrama.isSelected()) {
			if (movieDramaCounter == 0) {

				mc.addUserSelections("Δραματική");
				mc.removeSelection("Μυστηρίου");
				mc.removeSelection("Περιπέτεια");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Αστυνομική");
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");
				

				mc.showUserSelections();
				
				for (Movies m : mc.showPreviews()) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						hBoxMovieSelected.getChildren().add(hboxMoview);
						clearMovieDrama.add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				movieDramaDisplay = true;
			}

			movieDramaCounter++;

		}if (choiceCrime.isSelected()) {
			if (movieCrimeCounter == 0) {

				mc.addUserSelections("Αστυνομική");
				mc.removeSelection("Μυστηρίου");
				mc.removeSelection("Περιπέτεια");
				mc.removeSelection("Κωμωδία");
				mc.removeSelection("Δραματική");
				mc.removeSelection("Παιδικά");
				mc.removeSelection("Animation");

				mc.showUserSelections();
				
				for (Movies m : mc.showPreviews()) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader();

						fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
						HBox hboxMoview = fxmlLoader.load();
						RecentMoviesController recentMoviesController = fxmlLoader.getController();
						recentMoviesController.setData(m);
						hBoxMovieSelected.getChildren().add(hboxMoview);
						clearMovieCrime.add(hboxMoview);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				movieCrimeDisplay = true;
			}

			movieCrimeCounter++;

		}
		
		
	}
	
	
	
	
	
	
	
}

/*
 * 
 * public void getSelectedFilmGenres() {
 * 
 * if (choiceFun.isSelected() && choiceMystery.isSelected() &&
 * choiceAdventure.isSelected() && movieAdventureDisplay == false &&
 * movieMysteryDisplay == false && movieFunDisplay == false && movieFunCounter
 * == 1 && movieMysteryCounter == 1 && movieAdventureCounter == 1 &&
 * mysteryAndFunAndAdventure == 0) { mysteryAndFunAndAdventure++; Set<Movies>
 * set = new HashSet<Movies>(); for (Movies m :
 * selectedMovies.get("Περιπέτεια")) { set.add(m); } for (Movies m :
 * selectedMovies.get("Μυστηρίου")) { set.add(m); } for (Movies m :
 * selectedMovies.get("Κωμωδία")) { set.add(m); } for (Movies m : set) {
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * }
 * 
 * movieMysteryDisplay = true; movieAdventureDisplay = true; movieFunDisplay =
 * true;
 * 
 * }
 * 
 * if (choiceCrime.isSelected() && (choiceDrama.isSelected() == false) &&
 * movieCrimeCounter == 1) { for (Movies m : selectedMovies.get("Αστυνομική")) {
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * } movieCrimeDisplay = true;
 * 
 * }
 * 
 * if (choiceDrama.isSelected() && (choiceCrime.isSelected() == false) &&
 * movieDramaCounter == 1) { for (Movies m : selectedMovies.get("Δραματική")) {
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * } movieDramaDisplay = true; } if (choiceCrime.isSelected() &&
 * choiceDrama.isSelected() && dramaAndCrime == 0) { dramaAndCrime++; if
 * (choiceCrime.isSelected() && choiceDrama.isSelected() && movieCrimeDisplay ==
 * true && movieCrimeCounter > 1) {
 * 
 * for (Movies m : selectedMovies.get("Δραματική")) { for (Movies mov :
 * selectedMovies.get("Αστυνομική")) { if (m.getName().equals(mov.getName())) {
 * movieDrama = m;
 * 
 * }
 * 
 * } }
 * 
 * for (Movies m : selectedMovies.get("Δραματική")) { if
 * ((!movieDrama.getName().equals(m.getName()))) {
 * 
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } }
 * 
 * } movieCrimeDisplay = false; movieDramaDisplay = true; } else if
 * (choiceDrama.isSelected() && choiceCrime.isSelected() && movieDramaDisplay ==
 * true && movieDramaCounter > 1) {
 * 
 * for (Movies m : selectedMovies.get("Αστυνομική")) { for (Movies mov :
 * selectedMovies.get("Δραματική")) { if (m.getName().equals(mov.getName())) {
 * movieCrime = m;
 * 
 * }
 * 
 * } } for (Movies m : selectedMovies.get("Αστυνομική")) { if
 * (!movieCrime.getName().equals(m.getName())) { FXMLLoader fxmlLoader = new
 * FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } }
 * 
 * } movieDramaDisplay = false; movieCrimeDisplay = true; } else if
 * ((choiceDrama.isSelected() && choiceCrime.isSelected() && movieCrimeDisplay
 * == false && movieDramaDisplay == false && movieCrimeCounter == 1 &&
 * movieDramaCounter == 1)) {
 * 
 * Set<Movies> set = new HashSet<Movies>(); for (Movies m :
 * selectedMovies.get("Δραματική")) { set.add(m); } for (Movies m :
 * selectedMovies.get("Αστυνομική")) { set.add(m); } for (Movies m : set) {
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } }
 * 
 * movieCrimeDisplay = true; movieDramaDisplay = true;
 * 
 * }
 * 
 * }
 * 
 * if ((choiceAdventure.isSelected() && (choiceMystery.isSelected() == false))
 * && movieAdventureCounter == 1 ) {
 * 
 * for (Movies m : selectedMovies.get("Περιπέτεια")) { FXMLLoader fxmlLoader =
 * new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview);
 * clearMovieAdventure.add(hboxMoview); } catch (IOException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * 
 * }
 * 
 * movieAdventureDisplay = true; }
 * 
 * if ((choiceKids.isSelected() || choiceAnimation.isSelected()) &&
 * movieKidsCounter == 1) {
 * 
 * for (Movies m : selectedMovies.get("Παιδικά")) {
 * 
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml"));
 * 
 * try { HBox hbox = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m); hBoxMovieSelected.getChildren().add(hbox);
 * clearmovieKids.add(hbox);
 * 
 * } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * }
 * 
 * }
 * 
 * if ((choiceFun.isSelected() && (choiceMystery.isSelected() == false) &&
 * movieFunCounter == 1)) { if (choiceFun.isSelected() &&
 * choiceMystery.isSelected() == false) {
 * 
 * for (Movies m : selectedMovies.get("Κωμωδία")) {
 * 
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * } movieFunDisplay = true; } }
 * 
 * if (choiceMystery.isSelected() && (choiceFun.isSelected() == false &&
 * choiceAdventure.isSelected() == false) && movieMysteryCounter == 1) {
 * 
 * for (Movies m : selectedMovies.get("Μυστηρίου")) {
 * 
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * }
 * 
 * movieMysteryDisplay = true; }
 * 
 * if ((choiceMystery.isSelected() && choiceFun.isSelected() && funAndMystery ==
 * 0)) { funAndMystery++;
 * 
 * if (choiceMystery.isSelected() && choiceFun.isSelected() && movieFunDisplay
 * == true && movieFunCounter > 1) {
 * 
 * for (Movies m : selectedMovies.get("Μυστηρίου")) { for (Movies mov :
 * selectedMovies.get("Κωμωδία")) { if (m.getName().equals(mov.getName())) {
 * movieMystery = m;
 * 
 * }
 * 
 * } } if (movieAdventureDisplay == true) { for (Movies m :
 * selectedMovies.get("Περιπέτεια")) { for (Movies mov :
 * selectedMovies.get("Μυστηρίου")) { if (m.getName().equals(mov.getName())) {
 * movieAdventure = m; } } }
 * 
 * } for (Movies m : selectedMovies.get("Μυστηρίου")) { if
 * ((!movieMystery.getName().equals(m.getName())) && ((movieAdventure != null)
 * && (!movieAdventure.getName().equals(m.getName())))) {
 * 
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } }else
 * if(!movieMystery.getName().equals(m.getName())) { FXMLLoader fxmlLoader = new
 * FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } }
 * 
 * } movieFunDisplay = false; movieMysteryDisplay = true; } else if
 * (choiceMystery.isSelected() && choiceFun.isSelected() && movieMysteryDisplay
 * == true && movieMysteryCounter > 1) {
 * 
 * for (Movies m : selectedMovies.get("Κωμωδία")) { for (Movies mov :
 * selectedMovies.get("Μυστηρίου")) { if (m.getName().equals(mov.getName())) {
 * movieFun = m;
 * 
 * }
 * 
 * } } for (Movies m : selectedMovies.get("Κωμωδία")) { if
 * (!movieFun.getName().equals(m.getName())) { FXMLLoader fxmlLoader = new
 * FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } }
 * 
 * } movieMysteryDisplay = false; movieFunDisplay = true; } else if
 * ((choiceFun.isSelected() && choiceMystery.isSelected() && movieMysteryDisplay
 * == false && movieFunDisplay == false && movieMysteryCounter == 1 &&
 * movieFunCounter == 1)) {
 * 
 * if (choiceFun.isSelected() && choiceMystery.isSelected() &&
 * movieMysteryDisplay == false && movieFunDisplay == false &&
 * movieMysteryCounter == 1 && movieFunCounter == 1 && movieAdventureCounter ==
 * 0) { Set<Movies> set = new HashSet<Movies>(); for (Movies m :
 * selectedMovies.get("Κωμωδία")) { set.add(m); } for (Movies m :
 * selectedMovies.get("Μυστηρίου")) { set.add(m); } for (Movies m : set) {
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * }
 * 
 * }
 * 
 * } movieFunDisplay = true; movieMysteryDisplay = true; } if
 * (choiceMystery.isSelected() && choiceAdventure.isSelected() &&
 * mysteryAndAdventure == 0) {
 * 
 * mysteryAndAdventure++; if (choiceAdventure.isSelected() &&
 * choiceMystery.isSelected() && movieAdventureCounter > 1 &&
 * (movieMysteryDisplay == false)) {
 * 
 * for (Movies m : selectedMovies.get("Μυστηρίου")) { for (Movies mov :
 * selectedMovies.get("Περιπέτεια")) { if (m.getName().equals(mov.getName())) {
 * movieAdventure = m;
 * 
 * }
 * 
 * } } for (Movies m : selectedMovies.get("Μυστηρίου")) { if
 * (!movieAdventure.getName().equals(m.getName())) { FXMLLoader fxmlLoader = new
 * FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview);
 * 
 * } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }
 * 
 * } movieAdventureDisplay = true; movieMysteryDisplay = true;
 * 
 * } else if (choiceMystery.isSelected() && choiceAdventure.isSelected() &&
 * movieMysteryCounter > 1 && (movieAdventureDisplay == false)) {
 * 
 * for (Movies m : selectedMovies.get("Περιπέτεια")) { for (Movies mov :
 * selectedMovies.get("Μυστηρίου")) { if (m.getName().equals(mov.getName())) {
 * movieMystery2 = m;
 * 
 * }
 * 
 * } } for (Movies m : selectedMovies.get("Περιπέτεια")) { if
 * (!movieMystery2.getName().equals(m.getName())) { FXMLLoader fxmlLoader = new
 * FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview);
 * 
 * 
 * } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * }
 * 
 * } movieMysteryDisplay = true; movieAdventureDisplay = false;
 * 
 * }
 * 
 * else if ((choiceAdventure.isSelected() && choiceMystery.isSelected() &&
 * movieMysteryDisplay == false && movieAdventureDisplay == false &&
 * movieMysteryCounter == 1 && movieAdventureCounter == 1)) {
 * 
 * Set<Movies> set = new HashSet<Movies>(); for (Movies m :
 * selectedMovies.get("Περιπέτεια")) { set.add(m); } for (Movies m :
 * selectedMovies.get("Μυστηρίου")) { set.add(m); } for (Movies m : set) {
 * FXMLLoader fxmlLoader = new FXMLLoader();
 * 
 * fxmlLoader.setLocation(getClass().getResource("RecentMovies.fxml")); HBox
 * hboxMoview; try { hboxMoview = fxmlLoader.load(); RecentMoviesController
 * recentMoviesController = fxmlLoader.getController();
 * recentMoviesController.setData(m);
 * hBoxMovieSelected.getChildren().add(hboxMoview);
 * 
 * } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * } movieMysteryDisplay = true; movieAdventureDisplay = true;
 * 
 * }
 * 
 * }
 * 
 * }
 */

/*
 * @FXML public void mouseOver(ActionEvent event) {
 * 
 * movie1.setOnMouseEntered(new EventHandler<MouseEvent>() {
 * 
 * public void handle(MouseEvent t) {
 * movie1.setStyle("-fx-background-color:#dae7f3;"); } });
 * 
 * movie1.setOnMouseDragExited(new EventHandler<MouseEvent>() {
 * 
 * @Override public void handle(MouseEvent t) {
 * movie1.setStyle("-fx-background-color:transparent;"); } });
 * 
 * 
 * }
 */
