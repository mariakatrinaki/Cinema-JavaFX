package application;

import java.util.ArrayList;

public class Orders {
	
	private ArrayList<Products>  products;
	
	private int number ;
	
	
	
	
	
	
	
	

	public Orders(ArrayList<Products> products,int number) {
	
		this.products = products;
		this.number = number;
		
	}





	public ArrayList<Products> getProducts() {
		return products;
	}
	
	
	
	

	public void setFoods(ArrayList<Products> products) {
		this.products = products;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	
	
	
	
	
	

}
