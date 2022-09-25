package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

public class Movies implements Initializable {
    
	
	
	private String name;
	
	private String imageSrc;
	
	private String plot;
	
	private String hoursDisplay;
	
	private String price;
	
	private String actors;
	
	private String director;
	
	private String critics;
	
	
	
	
	 private List<String> categories;

	 //--------------------------------- constructors
	 public Movies(){
	    categories = new ArrayList<String>();
	 }

	 public Movies(String name){
	    this.name = name;
	    categories = new ArrayList<String>();
	 }
	 
	 //---------------------------------
	 public boolean checkIfCategorieExist(String category){
	    return categories.contains(category);
	 }
	 
	 //---------------------------------
	 public void setCategory(String category){
	   if(!categories.contains(category)){
	       categories.add(category);
	   }
	 }

	 //---------------------------------
	 public void showCategories(){
	   for(String s:categories){
	    System.out.println(s);
	   }
	 }

	 //---------------------------------
	 public void setName(String name){
	   this.name = name;
	 }

	 //---------------------------------
	 public String getName(){
	  return name;
	 }
	 
	 //---------------------------------
	 public  void showDetails(){
		
		 
		 
		 
		 
		 
	  /*	 
	   System.out.println("Name      : " + name);
	   System.out.print("Categories: ");
	   for(String s:categories){
	     System.out.print(s + " ");
	   }
	   System.out.println("\n");
	   */
	 }
	
	


	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getHoursDisplay() {
		return hoursDisplay;
	}

	public void setHoursDisplay(String hoursDisplay) {
		this.hoursDisplay = hoursDisplay;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCritics() {
		return critics;
	}

	public void setCritics(String critics) {
		this.critics = critics;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	

}
