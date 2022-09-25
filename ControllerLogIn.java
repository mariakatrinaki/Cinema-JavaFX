package application;

import javafx.scene.Node;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



import application.Users.Person;
import application.Users;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerLogIn implements Initializable {

	@FXML
	private Label logInLabel;

	@FXML
	private ChoiceBox<String> logInChoiceBox;

	@FXML
	private TextField userName;

	@FXML
	private TextField password;

	@FXML
	private Label myLabelLogIn;
	

	static Users  visitor ;
	static Users employee ;

	private ArrayList<Users> usersDetails;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		logInChoiceBox.getItems().addAll(Person.Employee.toString(), Person.Visitor.toString());
	}

	public void logIn(ActionEvent event)  {

		

		usersDetails = getUsers();

		for (Users l : usersDetails) {
			if (logInChoiceBox.getValue().equals(Person.Visitor.toString())
					&& logInChoiceBox.getValue().equals(l.getPerson().toString())
					&& userName.getText().toLowerCase().equals(l.getUserName())
					&& password.getText().toLowerCase().equals(l.getPassword())) {

				visitor = l;
				break;

			} else if (logInChoiceBox.getValue().equals(Person.Employee.toString())
					&& logInChoiceBox.getValue().equals(l.getPerson().toString())
					&& userName.getText().toLowerCase().equals(l.getUserName())
					&& password.getText().toLowerCase().equals(l.getPassword())) {
				employee = l;
				break;

			}

		}

		if (visitor!=null && visitor.getPerson().toString().equals(Person.Visitor.toString())) {
			myLabelLogIn.setTextFill(Color.BLUE);
			myLabelLogIn.setText(visitor.getUserName() + " you sucessfully log in");
			
			Parent root = null;
			Stage stage = new Stage();
			((Node)event.getSource()).getScene().getWindow().hide();
			try {
				root =FXMLLoader.load(getClass().getResource("HomeVisitor.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			stage.setScene(new Scene(root,1100,500));
		    stage.initStyle(StageStyle.UNDECORATED);
		    stage.setFullScreen(true);
		    stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
			stage.show();
			
			
	
			
		} else if (employee!=null && employee.getPerson().toString().equals(Person.Employee.toString())) {
			myLabelLogIn.setTextFill(Color.BLUE);
			myLabelLogIn.setText(employee.getUserName()+" you sucessfully  log in" );
			Parent root = null;
			Stage stage = new Stage();
			((Node)event.getSource()).getScene().getWindow().hide();
			try {
				root =FXMLLoader.load(getClass().getResource("EmployeeHomePage.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			stage.setScene(new Scene(root,1100,500));
		    stage.initStyle(StageStyle.UNDECORATED);
		    stage.setFullScreen(true);
		    stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
			stage.show();
			
			
		} else {
			myLabelLogIn.setTextFill(Color.RED);
			myLabelLogIn.setText("Invalid informations");
		}

	}

	public static ArrayList<Users> getUsers() {
		String path = "C:\\Users\\MARIA\\eclipse-workspace\\TutorialJavaFx\\src\\userLogIn\\logIn.txt";
		ArrayList<Users> usersDetails = new ArrayList<Users>();
           
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();

			while (line != null) {
				String[] metadata = line.split(",");

				Users user = createObjects(metadata);

				usersDetails.add(user);

				line = br.readLine();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usersDetails;

	}

	
	
	
	public static Users createObjects(String[] metadata) {
		Person user = Person.valueOf(metadata[0]);
		String userName = String.valueOf(metadata[1]);
		String password = String.valueOf(metadata[2]);

		return new Users(user, userName, password);
	}
	
	public static Users getVisitor() {
		return visitor;
	}
	
	public static Users getEmployee() {
		return employee;
	}

}
