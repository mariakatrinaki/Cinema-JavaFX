package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class PurchaseTicketController implements Initializable {

	@FXML
	TextField cardName;

	@FXML
	TextField cardNumber;

	@FXML
	DatePicker cardDate;

	@FXML
	Label purchaseStatus;

	public void purchaseOccur(ActionEvent event) {

		if (cardName.getText() != null && cardNumber.getText() != null && cardDate.getValue() != null) {

			purchaseStatus.setText("Η αγορά ήταν επιτυχής ");
			purchaseStatus.setTextFill(Color.rgb(8, 17, 253));

		} else {

			purchaseStatus.setText("Τα στοιχεία που έδωσες δεν είναι έγκυρα");
			purchaseStatus.setTextFill(Color.color(1, 0, 0));
		}

	}

	@FXML
	public void purchaseCancel(ActionEvent event) {

		cardNumber.clear();
		cardName.clear();
		cardDate.setValue(null);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cardDate.getEditor().setDisable(true);
		cardDate.getEditor().setOpacity(1);

		cardNumber.setTextFormatter(new TextFormatter<>(change ->

		(change.getControlNewText().matches("([1-9][0-9]*)?")) ? change : null));

		cardName.setTextFormatter(new TextFormatter<>(change ->

		(change.getControlNewText().matches("[a-zA-Z]*")) ? change : null));

	}
}