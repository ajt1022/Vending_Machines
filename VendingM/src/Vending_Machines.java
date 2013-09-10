
	import java.io.File;
	import java.io.PrintWriter;
	import java.io.FileNotFoundException;
	import java.util.Scanner;
	import java.io.PrintWriter;
	import java.util.Random;
	import java.util.Date;

	public class Vending_Machines{
		
		final int SIZE = 10;
		private Dispensers[] dispenser = new Dispensers[SIZE];
		private boolean Machine_Status = true;
		private FoodInformation food;
		private String itemName;
		private double price, MoneyInserted, change;
		private String nutritionInfo;
		private String typeofitem;
		private int quantity;
		private String A1 = "Coke", A2 = "Water", A3 = "Pepsi", A4 = "Chex Mix", A5 = "Doritos", A6 = "Cheetos", A7 = "Arizona Tea", A8 = "Orange Juice", A9 = "Twix", A10 = "Sun Chips";
		Random generator = new Random();
		int client_arrival = generator.nextInt(24) + 5;
		int Vmachine = generator.nextInt(2) + 1;
		
		Date date = new Date();

		
		
		public Vending_Machines() throws NeedMoreMoneyException{
			Menu();
			Inventory();
			
		
		}

		
		private void Inventory() throws NeedMoreMoneyException{
			String fileName = "Inventory.txt";
			String fileName1 = "NewInventory.txt";
			fileName1 = date.toString().replace(':', '_');
			Scanner fileInput = null;
			PrintWriter outputStream = null;
			
			try{
				fileInput = new Scanner(new File(fileName));
				
			}catch(FileNotFoundException e){
				System.err.print("Error, can not open file.");
				System.exit(0);
			}//try and catch ends
			
			Scanner keyboard = new Scanner (System.in);
			String line[] = new String[SIZE*5];
			
			int numItem = 0;
			int i = 0, j = 0;
			while(fileInput.hasNextLine()){
				line[i] = fileInput.nextLine();
				i++;
			}
			
			
			
			numItem = ((i+1) / 5);
			
			while (numItem > 0){
				itemName = line[(5 * numItem) - 5];
				price = new Double(line[(5 * numItem) - 4]);
				nutritionInfo = line[(5 * numItem) - 3];
				typeofitem = line[(5 * numItem) - 2];
				quantity = Integer.parseInt(line[(5 * numItem) - 1]);
				food = new FoodInformation(price, itemName, nutritionInfo, typeofitem);
				dispenser[numItem - 1] = new Dispensers(quantity, food);
				System.out.println(food + " " + "Quantity: " + dispenser[numItem-1].getQuantity1());
				numItem--;
				
			}//while loop ends
			
			//purchase while machine is on
			if(Machine_Status == true)
			{
				
			
					
				
				Scanner input = new Scanner( System.in );

				System.out.print("\nWhat do you want to buy?");
				fileName = input.nextLine();
				System.out.print("How much will you be putting in?");
				MoneyInserted = input.nextDouble();
				
				//cancels transaction if not enough money
				if(price > MoneyInserted){
					 throw new NeedMoreMoneyException("Need more money, please try again");
					
				}
				System.out.printf("\nclient arrival time: %d", client_arrival);
				System.out.printf("\nMachine being used: %d", Vmachine);
				System.out.println();
				change = MoneyInserted - price;
				System.out.printf("\nReciept: \nitem name: %s, \nprice: %f, \nmoney put in: %f, \nchange: %f", itemName, price, MoneyInserted, change);
				Machine_Status = false;
				}
			
			if(Machine_Status == false){
				System.out.println("\nVending Machine is now off.");
				 try
			        {
			            outputStream = new PrintWriter (fileName1);
			        }
			        catch (FileNotFoundException e)
			        {
			        	
			            System.out.println ("Error opening the file " +
			                    fileName1);
			            System.exit (0);
			        }
			        System.out.println ("\nEnter sales total, subtotal and number of items sold:");
			        Scanner key = new Scanner (System.in);
			        for (int count = 1 ; count <= 3 ; count++)
			        {
			            String Line = key.nextLine ();
			            outputStream.println (count + " " + Line);
			        }
			        outputStream.close ();
			        System.out.println ("\nThose lines were written to " +
			                fileName1);
				
				}
			
				
			}
			
			
		//inventory method ends
		
		public void Menu(){
			System.out.printf("Vending Machine Menu is: \n1) %s \n2) %s \n3) %s \n4) %s \n5) %s \n6) %s \n7) %s \n8) %s \n9) %s \n10)  %s", A1, A2, A3, A4, A5, A6, A7, A8, A9, A10);
		}
		
		
	
}
