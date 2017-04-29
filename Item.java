import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//LAST UPDATED: 4/13/2017 8:17p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class allows sellers to create general item objects to be added
 * to their inventory and sold on the marketplace.
 */
public class Item implements Serializable{

	private String name; //name of the item
	private String category;
	private int cNumber; //number for each category
	private int itemNumber; //id number to be given to each item
	private String description; //description of the item
	private int sellerID; //we will keep track and assign the sellers id to each item that is created
	private int quantity; //quantity of the item
	private double price; //price of the item
	
	
	//constructor for the Item class
	public Item(String n, int c, String d, int s, int q, double p) throws FileNotFoundException, ClassNotFoundException, IOException{ //Item objects will be created by the seller class, the letters are the first letters of the variables above	
		this.name = n;
		this.cNumber = c;
		switch(cNumber){
		case 1: category = "books";
		break;
		case 2: category = "clothing";
		break;
		case 3: category = "electronics";
		break;
		case 4: category = "healthFood";
		break;
		case 5: category = "homeGarden";
		break;
		case 6: category = "media";
		break;
		case 7: category = "outdoor";
		break;
		case 8: category = "toy";
		break;
		case 9: category = "miscellaneous";
		break;
		}
		setItemNumber();
		this.description = d;
		this.sellerID = s;
		this.quantity = q;
		this.price = p;
	}
	
	
	//method to return the name of the item
	public String getName(){
		return name;
	}
	
	//method to allow seller to set the name of the item
	public void setName(String n){
		name = n;
	}
	
	//method to return item category
	public String getCategory(){
		return category;
	}
	//method to return the itemNumber
	public int getItemNumber(){
		return itemNumber;
	}
	
	//method to automatically give item a number
	public void setItemNumber() throws FileNotFoundException, IOException, ClassNotFoundException{
		ArrayList<Item> items = new ArrayList<Item>();
		File itemsFile = new File("totalInventory.txt");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("totalInventory.txt"));	
		
		try{
			Item item = null;
			while((item = (Item) in.readObject()) != null){
				items.add(item);
			}
			in.close();
		}
		catch(EOFException e){
			in.close();
		}
		if(items.size() == 0)
			itemNumber = 0;
		else{
			itemNumber = items.size() + 1;
		}
	}
	
	//method to return the description of the item
	public String getDescription(){
		return description;
	}
	
	//method to allow the seller to change the description of the item
	public void setDescription(String d){
		description = d;
	}
	
	//method to return the seller's ID of the item
	public int getSellerID(){
		return sellerID;
	}
	
	//method to return the quantity of the item
	public int getQuantity(){
		return quantity;
	}
	
	//method to allow the seller to change the quantity of the item
	public void setQuantity(int q){
		quantity = q;
	}
	
	//method to return the price of the item
	public double getPrice(){
		return price;
	}
	
	//method to allow the seller to set the price of the item
	public void setPrice(double p){
		price = p;
	}
	
	
	/*testing class
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		Item testItem = new Item("Test item", 9, "This is a test item", 0, 0, 0);
		Item test2 = new Item("Shirt", 2, "Blue shirt", 123, 1, 13);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("totalInventory.txt"));
		out.writeObject(testItem);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("totalInventory.txt"));
		Item test = (Item) in.readObject();
		System.out.println(testItem.getName());
		System.out.println(testItem.getItemNumber());
	}*/
}