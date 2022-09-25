package application;

public enum Products {
	  
			Chips ("chips", 0 , false,0),
			PopCorn("popcorn",0, false,0),
			Candy ("candy",0, false,0),
			Cookies ("cookies",0,false,0),
			IceCream ("icecream",0,false,0),
			Donats ("donats",0, false,0),
			Toast ("tost",0,false,0),
	        Water ("water 50ml", 0 , false,0),
	       Lemonade("lemonade",0, false,0),
	        Sprite ("sprite",0, false,0),
	        CocaCola ("cocaCola",0,false,0),
	        OrangeJuice ("Orange juice",0,false,0),
	        CherryJuice ("Cherry juice",0, false,0),
	         BigWater ("water 100ml",0,false,0);
		   
		
			private  String product;
			
			private int quantite ;
			
			private boolean isChoosen;
			
			private int numberOfOrder;
			
			
			


			private Products( String product,int quantite, boolean isChoosen, int numberOfOrder) {
				this.product = product;
				this.quantite = quantite;
				this.isChoosen = isChoosen;
				this.numberOfOrder = numberOfOrder;
				
			}


			public String getProduct() {
				return product;
			}


			public void setProduct(String product) {
				this.product = product;
			}


			public int getQuantite() {
				return quantite;
			}


			public void setQuantite(int quantite) {
				this.quantite = quantite;
			}


			public boolean isChoosen() {
				return isChoosen;
			}


			public void setChoosen(boolean isChoosen) {
				this.isChoosen = isChoosen;
			}


			public int getNumberOfOrder() {
				return numberOfOrder;
			}


			public void setNumberOfOrder(int numberOfOrder) {
				this.numberOfOrder = numberOfOrder;
			}
			
	
		
		
		

}
