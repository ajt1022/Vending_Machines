
public class FoodInformation {

	//variables declared 
		double price1;
		String nutritionInfo1, typeofitem1, itemName1;

		//no-argument constructor that calls super class dispenser
		public FoodInformation(){
			super();
		}//ends FoodInformation class
		
		//constructor 
		public FoodInformation(double price1, String itemName1, String nutritionInfo1, String typeofitem1){
			super();
			this.price1 = price1;
			this.itemName1 = itemName1;
			this.nutritionInfo1 = nutritionInfo1;
			this.typeofitem1 = typeofitem1;
			
			
		}
		
		public double getPrice1(){
			return price1;
		}
		
		public void setPrice1(double price1){
			this.price1 = price1;
		}
		
		public String getItemName1(){
			return itemName1;
		}
		
		public void setItemName1(String itemName1){
			this.itemName1 = itemName1;
		}
		
		public String getNutritionInfo1(){
			return nutritionInfo1;
		}
		
		public void setNutritionInfo1(String nutritionInfo1){
			this.nutritionInfo1 = nutritionInfo1;
		}
		
		public String getTypeOfItem1(){
			return typeofitem1;
		}
		
		public void setTypeOfItem1(String typeofitem1){
			this.typeofitem1 = typeofitem1;
		}
		
		
		
		@Override
		public String toString(){
			return "FoodInformation: (price=" + price1 + ", Item Name=" + itemName1 + ", Nutrition Info=" + nutritionInfo1 + ", type of item=" + typeofitem1 + ")";
		}
		
	
}
