package application;

import application.Products;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrdersController implements Initializable {

	SpinnerValueFactory<Integer> valueChips = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valuePopCorn = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueCandy = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueCookies = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueIceCream = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueDonats = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueToast = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);

	SpinnerValueFactory<Integer> valueWater = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueLemonade = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueSprite = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueCocaCola = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueOrangeJuice = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueCherryJuice = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
	SpinnerValueFactory<Integer> valueBigWater = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);

	int i = 1;
	@FXML
	Spinner<Integer> spinnerChips;

	@FXML
	Spinner<Integer> spinnerPopcorn;

	@FXML
	Spinner<Integer> spinnerCandy;

	@FXML
	Spinner<Integer> spinnerCookies;

	@FXML
	Spinner<Integer> spinnerIceCream;

	@FXML
	Spinner<Integer> spinnerDonats;

	@FXML
	Spinner<Integer> spinnerToast;

	@FXML
	Spinner<Integer> spinnerWater;

	@FXML
	Spinner<Integer> spinnerLemonade;

	@FXML
	Spinner<Integer> spinnerSprite;

	@FXML
	Spinner<Integer> spinnerCocaCola;

	@FXML
	Spinner<Integer> spinnerOrangeJuice;

	@FXML
	Spinner<Integer> spinnerCherryJuice;

	@FXML
	Spinner<Integer> spinnerBigWater;

	@FXML
	CheckBox chips;

	@FXML
	CheckBox popCorn;

	@FXML
	CheckBox candy;

	@FXML
	CheckBox cookies;

	@FXML
	CheckBox icecream;

	@FXML
	CheckBox donats;

	@FXML
	CheckBox toast;

	@FXML
	CheckBox water;

	@FXML
	CheckBox lemonade;

	@FXML
	CheckBox sprite;

	@FXML
	CheckBox cocaCola;

	@FXML
	CheckBox orangeJuice;

	@FXML
	CheckBox cherryJuice;

	@FXML
	CheckBox bigWater;
	
	@FXML
	Label labelEmptyBasket;
	
	@FXML
	ImageView imageViewWater;
	
	@FXML
	ImageView imageViewLemonade;
	
	@FXML
	ImageView imageViewSprite;
	
	@FXML
	ImageView imageViewCocaCola;

	@FXML
	ImageView imageViewOrangeJuice;
	
	@FXML
	ImageView imageViewCherryJuice;
	
	@FXML
	ImageView imageViewBigWater;
	
	@FXML
	ImageView imageViewChips;
	
	@FXML
	ImageView imageViewPopCorn;
	
	@FXML
	ImageView imageViewCandy;
	
	@FXML
	ImageView imageViewCookies;
	
	@FXML
	ImageView imageViewIceCream;
	
	@FXML
	ImageView imageViewDonats;
	
	@FXML
	ImageView imageViewToast;

	int currentValue;

	static Users user;

	static Orders order;

	ArrayList<Products> products = new ArrayList<Products>();
	HashMap<CheckBox, Spinner<Integer>> basket = new HashMap<CheckBox, Spinner<Integer>>();
	ArrayList<Orders> orders;

	public void getUserSelection(ActionEvent event) {

		if (water.isSelected() && spinnerWater.getValue() > 0) {
			Products.Water.setProduct(water.getText());
			Products.Water.setQuantite(spinnerWater.getValue());
			Products.Water.setChoosen(water.isSelected());
			Products.Water.setNumberOfOrder(i);
			products.add(Products.Water);
			water.setSelected(false);
			water.setDisable(false);
			spinnerWater.getValueFactory().setValue(0);

		}
		if (lemonade.isSelected() && spinnerLemonade.getValue() > 0) {
			Products.Lemonade.setProduct(lemonade.getText());
			Products.Lemonade.setQuantite(spinnerLemonade.getValue());
			Products.Lemonade.setChoosen(lemonade.isSelected());
			Products.Lemonade.setNumberOfOrder(i);
			products.add(Products.Lemonade);
			lemonade.setSelected(false);
			lemonade.setDisable(false);
			spinnerLemonade.getValueFactory().setValue(0);

		}
		if (sprite.isSelected() && spinnerSprite.getValue() > 0) {
			Products.Sprite.setProduct(sprite.getText());
			Products.Sprite.setQuantite(spinnerSprite.getValue());
			Products.Sprite.setChoosen(sprite.isSelected());
			Products.Sprite.setNumberOfOrder(i);
			products.add(Products.Sprite);
			sprite.setSelected(false);
			sprite.setDisable(false);
			spinnerSprite.getValueFactory().setValue(0);

		}
		if (cocaCola.isSelected() && spinnerCocaCola.getValue() > 0) {
			Products.CocaCola.setProduct(cocaCola.getText());
			Products.CocaCola.setQuantite(spinnerCocaCola.getValue());
			Products.CocaCola.setChoosen(cocaCola.isSelected());
			Products.CocaCola.setNumberOfOrder(i);
			products.add(Products.CocaCola);
			cocaCola.setSelected(false);
			cocaCola.setDisable(false);
			spinnerCocaCola.getValueFactory().setValue(0);

		}
		if (orangeJuice.isSelected() && spinnerOrangeJuice.getValue() > 0) {
			Products.OrangeJuice.setProduct(orangeJuice.getText());
			Products.OrangeJuice.setQuantite(spinnerOrangeJuice.getValue());
			Products.OrangeJuice.setChoosen(orangeJuice.isSelected());
			Products.OrangeJuice.setNumberOfOrder(i);
			products.add(Products.OrangeJuice);
			orangeJuice.setSelected(false);
			orangeJuice.setDisable(false);
			spinnerOrangeJuice.getValueFactory().setValue(0);

		}
		if (cherryJuice.isSelected() && spinnerCherryJuice.getValue() > 0) {
			Products.CherryJuice.setProduct(cherryJuice.getText());
			Products.CherryJuice.setQuantite(spinnerCherryJuice.getValue());
			Products.CherryJuice.setChoosen(cherryJuice.isSelected());
			Products.CherryJuice.setNumberOfOrder(i);
			products.add(Products.CherryJuice);
			cherryJuice.setSelected(false);
			cherryJuice.setDisable(false);
			spinnerCherryJuice.getValueFactory().setValue(0);

		}
		if (bigWater.isSelected() && spinnerBigWater.getValue() > 0) {
			Products.BigWater.setProduct(bigWater.getText());
			Products.BigWater.setQuantite(spinnerBigWater.getValue());
			Products.BigWater.setChoosen(bigWater.isSelected());
			Products.BigWater.setNumberOfOrder(i);
			products.add(Products.BigWater);
			bigWater.setSelected(false);
			bigWater.setDisable(false);
			spinnerBigWater.getValueFactory().setValue(0);
		}

		if (chips.isSelected() && spinnerChips.getValue() > 0) {
			Products.Chips.setProduct(chips.getText());
			Products.Chips.setQuantite(spinnerChips.getValue());
			Products.Chips.setChoosen(chips.isSelected());
			Products.Chips.setNumberOfOrder(i);
			products.add(Products.Chips);
			chips.setSelected(false);
			chips.setDisable(false);
			spinnerChips.getValueFactory().setValue(0);

		}
		if (popCorn.isSelected() && spinnerPopcorn.getValue() > 0) {
			Products.PopCorn.setProduct(popCorn.getText());
			Products.PopCorn.setQuantite(spinnerPopcorn.getValue());
			Products.PopCorn.setChoosen(popCorn.isSelected());
			Products.PopCorn.setNumberOfOrder(i);
			products.add(Products.PopCorn);
			popCorn.setSelected(false);
			popCorn.setDisable(false);
			spinnerPopcorn.getValueFactory().setValue(0);

		}
		if (candy.isSelected() && spinnerCandy.getValue() > 0) {
			Products.Candy.setProduct(candy.getText());
			Products.Candy.setQuantite(spinnerCandy.getValue());
			Products.Candy.setChoosen(candy.isSelected());
			Products.Candy.setNumberOfOrder(i);
			products.add(Products.Candy);
			candy.setSelected(false);
			candy.setDisable(false);
			spinnerCandy.getValueFactory().setValue(0);

		}
		if (cookies.isSelected() && spinnerCookies.getValue() > 0) {
			Products.Cookies.setProduct(cookies.getText());
			Products.Cookies.setQuantite(spinnerCookies.getValue());
			Products.Cookies.setChoosen(cookies.isSelected());
			Products.Cookies.setNumberOfOrder(i);
			products.add(Products.Cookies);
			cookies.setSelected(false);
			cookies.setDisable(false);
			spinnerCookies.getValueFactory().setValue(0);

		}
		if (icecream.isSelected() && spinnerIceCream.getValue() > 0) {
			Products.IceCream.setProduct(icecream.getText());
			Products.IceCream.setQuantite(spinnerIceCream.getValue());
			Products.IceCream.setChoosen(icecream.isSelected());
			Products.IceCream.setNumberOfOrder(i);
			products.add(Products.IceCream);
			icecream.setSelected(false);
			icecream.setDisable(false);
			spinnerIceCream.getValueFactory().setValue(0);

		}
		if (donats.isSelected() && spinnerDonats.getValue() > 0) {
			Products.Donats.setProduct(donats.getText());
			Products.Donats.setQuantite(spinnerDonats.getValue());
			Products.Donats.setChoosen(donats.isSelected());
			Products.Donats.setNumberOfOrder(i);
			products.add(Products.Donats);
			donats.setSelected(false);
			donats.setDisable(false);
			spinnerDonats.getValueFactory().setValue(0);

		}
		if (toast.isSelected() && spinnerToast.getValue() > 0) {
			Products.Toast.setProduct(toast.getText());
			Products.Toast.setQuantite(spinnerToast.getValue());
			Products.Toast.setChoosen(toast.isSelected());
			Products.Toast.setNumberOfOrder(i);
			products.add(Products.Toast);
			toast.setSelected(false);
			toast.setDisable(false);
			spinnerToast.getValueFactory().setValue(0);

		}
        if(products.isEmpty()== false) {
        	
        labelEmptyBasket.setVisible(false);
        	
		order = new Orders(products, i);

		orders = new ArrayList<Orders>();

		orders.add(order);

		user = new Users(ControllerLogIn.getVisitor().getPerson(), ControllerLogIn.getVisitor().getUserName(),
				ControllerLogIn.getVisitor().getPassword(), orders);

		i++;
         
		Parent root = null;
		Stage stage = new Stage();
		// ((Node)event.getSource()).getScene().getWindow().hide();
		try {
			root = FXMLLoader.load(getClass().getResource("OrdersBasket.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (root != null) {

			stage.setScene(new Scene(root, 600, 500));
			stage.initStyle(StageStyle.UNDECORATED);
			stage.initModality(Modality.APPLICATION_MODAL);
			// stage.setFullScreen(true);
			// stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
			stage.show();

		}
        }else {
        	labelEmptyBasket.setVisible(true);
        }
	}

	public void clearButton(ActionEvent event) {
		for (HashMap.Entry<CheckBox, Spinner<Integer>> entry : basket.entrySet()) {
			CheckBox key = entry.getKey();
			Spinner<Integer> value = entry.getValue();
			key.setSelected(false);
			key.setDisable(false);
			value.getValueFactory().setValue(0);

		}

	}

	public static Users getUser() {
		return user;
	}

	public static Orders getOrders() {
		return order;
	}

	@FXML
	public void choosen(ActionEvent event) {
		for (HashMap.Entry<CheckBox, Spinner<Integer>> entry : basket.entrySet()) {
			CheckBox key = entry.getKey();
			Spinner<Integer> value = entry.getValue();
			if (key.isSelected() && value.getValue()==0) {
				value.getValueFactory().setValue(1);

			}

		}
	}

	@SuppressWarnings("unchecked")
	public void spinner(Spinner spinner, CheckBox checkBox) {
		spinner.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> obs, Integer oldVal, Integer newVal) {
				if ((checkBox.isSelected() == false) && newVal > 0) {
					checkBox.setSelected(true);
					checkBox.setDisable(false);
				}
				if (checkBox.isSelected() && newVal == 0) {
					checkBox.setSelected(false);
					checkBox.setDisable(false);
				}
				if (checkBox.isSelected() && newVal > 0) {
					checkBox.setDisable(true);

				}

			}

		});
	}

	public void products() {

		List<SpinnerValueFactory<Integer>> valueFactory = new ArrayList<SpinnerValueFactory<Integer>>(Arrays.asList(
				valueChips, valuePopCorn, valueCandy, valueCookies, valueIceCream, valueDonats, valueToast, valueWater,
				valueLemonade, valueSprite, valueOrangeJuice, valueCocaCola, valueCherryJuice, valueBigWater));

		for (SpinnerValueFactory<Integer> i : valueFactory) {
			i.setValue(0);

		}
		spinnerChips.setValueFactory(valueChips);
		spinnerPopcorn.setValueFactory(valuePopCorn);
		spinnerCandy.setValueFactory(valueCandy);
		spinnerCookies.setValueFactory(valueCookies);
		spinnerIceCream.setValueFactory(valueIceCream);
		spinnerDonats.setValueFactory(valueDonats);
		spinnerToast.setValueFactory(valueToast);
		spinnerWater.setValueFactory(valueWater);
		spinnerLemonade.setValueFactory(valueLemonade);
		spinnerSprite.setValueFactory(valueSprite);
		spinnerCocaCola.setValueFactory(valueCocaCola);
		spinnerOrangeJuice.setValueFactory(valueOrangeJuice);
		spinnerCherryJuice.setValueFactory(valueCherryJuice);
		spinnerBigWater.setValueFactory(valueBigWater);

		chips.setText(Products.Chips.getProduct());
		popCorn.setText(Products.PopCorn.getProduct());
		candy.setText(Products.Candy.getProduct());
		cookies.setText(Products.Cookies.getProduct());
		icecream.setText(Products.IceCream.getProduct());
		donats.setText(Products.Donats.getProduct());
		toast.setText(Products.Toast.getProduct());
		water.setText(Products.Water.getProduct());
		lemonade.setText(Products.Lemonade.getProduct());
		sprite.setText(Products.Sprite.getProduct());
		cocaCola.setText(Products.CocaCola.getProduct());
		orangeJuice.setText(Products.OrangeJuice.getProduct());
		cherryJuice.setText(Products.CherryJuice.getProduct());
		bigWater.setText(Products.BigWater.getProduct());

		basket.put(chips, spinnerChips);
		basket.put(popCorn, spinnerPopcorn);
		basket.put(cookies, spinnerCookies);
		basket.put(icecream, spinnerIceCream);
		basket.put(candy, spinnerCandy);
		basket.put(donats, spinnerDonats);
		basket.put(toast, spinnerToast);
		basket.put(water, spinnerWater);
		basket.put(lemonade, spinnerLemonade);
		basket.put(sprite, spinnerSprite);
		basket.put(cocaCola, spinnerCocaCola);
		basket.put(orangeJuice, spinnerOrangeJuice);
		basket.put(cherryJuice, spinnerCherryJuice);
		basket.put(bigWater, spinnerBigWater);

		spinner(spinnerChips, chips);
		spinner(spinnerPopcorn, popCorn);
		spinner(spinnerCookies, cookies);
		spinner(spinnerIceCream, icecream);
		spinner(spinnerCandy, candy);
		spinner(spinnerDonats, donats);
		spinner(spinnerToast, toast);
		spinner(spinnerWater, water);
		spinner(spinnerLemonade, lemonade);
		spinner(spinnerSprite, sprite);
		spinner(spinnerCocaCola, cocaCola);
		spinner(spinnerOrangeJuice, orangeJuice);
		spinner(spinnerCherryJuice, cherryJuice);
		spinner(spinnerBigWater, bigWater);

	}
	
	public void setFoodImages() {
		Image imageWater = new Image("water.png");
		Image imageLemonade = new Image("lemonade.png");
		Image imageSprite = new Image("sprite.png");
		Image imageCocaCola = new Image("cocaCola.png");
		Image imageOrangeJuice = new Image("orangeJuice.png");
		Image imageCherryJuice = new Image("cherryJuice.png");
		Image imageBigWater = new Image("bigWater.png");
		Image imageChips = new Image("chips.png");
		Image imagePopCorn= new Image("popCorn.png");
		Image imageCandy = new Image("candy.png");
		Image imageCookies = new Image("cookies.png");
		Image imageIceCream = new Image("iceCream.png");
		Image imageDonats = new Image("donats.png");
		Image imageToast = new Image("toast.png");
		
		
		
		imageViewWater.setImage(imageWater);
		imageViewLemonade.setImage(imageLemonade);
		imageViewSprite.setImage(imageSprite);
		imageViewCocaCola.setImage(imageCocaCola);
		imageViewOrangeJuice.setImage(imageOrangeJuice);
		imageViewCherryJuice.setImage(imageCherryJuice);
		imageViewBigWater.setImage(imageBigWater);
		imageViewChips.setImage(imageChips);
		imageViewPopCorn.setImage(imagePopCorn);
		imageViewCandy.setImage(imageCandy);
		imageViewCookies.setImage(imageCookies);
		imageViewIceCream.setImage(imageIceCream);
	    imageViewDonats.setImage(imageDonats);
	    imageViewToast.setImage(imageToast);
		
		
		
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setFoodImages();
		
		products();

	}

}
