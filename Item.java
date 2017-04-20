//LAST UPDATED: 4/13/2017 8:17p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class allows sellers to create general item objects to be added
 * to their inventory and sold on the marketplace.
 */
public class Item {

	private String name; //name of the item
	private int itemNumber; //id number to be given to each item
	private String description; //description of the item
	private int sellerID; //we will keep track and assign the sellers id to each item that is created
	private int quantity; //quantity of the item
	private double price; //price of the item
	
	
	//constructor for the Item class
	public Item(String n, int i, String d, int s, int q, double p){ //Item objects will be created by the seller class, the letters are the first letters of the variables above
		//set all variables to the respective parameters
		//TO-DO
	}
	
	
	//method to return the name of the item
	public String getName(){
		return name;
	}
	
	//method to return the itemNumber
	public int getItemNumber(){
		return itemNumber;
	}
	
	//method to return the description of the item
	public String getDescription(){
		return description;
	}
	
	//method to return the seller's ID of the item
	public int getSellerID(){
		return sellerID;
	}
	
	//method to return the quantity of the item
	public int getQuantity(){
		return quantity;
	}
	
	//method to return the price of the item
	public double getPrice(){
		return price;
	}
	
	
	
	
}
