
public class Dispensers {
	
	final int MAX = 100;
	int quantity1, amountSold;
	FoodInformation foodInfo;
	
	//no argument constructor
	public Dispensers(){
		super();
	}
	
	public Dispensers(int quantity1, FoodInformation foodInfo){
		super();
		this.quantity1 = quantity1;
		this.foodInfo = foodInfo;
	}
	
	public int getQuantity1(){
		return quantity1;
	}
	
	public void setQuantity1(int quantity1){
		this.quantity1--;
	}
	
	public int getAmountSold(){
		return amountSold;
	}
	
	public void setAmountSold(int amountSold){
		this.amountSold++;
	}
	
	public FoodInformation getFoodInfo(){
		return foodInfo;
	}
	
	public void setFoodInfo(FoodInformation foodInfo){
		this.foodInfo = foodInfo;
	}
	
	
	@Override
	public String toString(){
		return "Dispensers: (quantity=" + quantity1 + ", amount of items sold=" + amountSold + ", food info=" + foodInfo + ")";
	}
}
