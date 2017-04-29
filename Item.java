<<<<<<< HEAD
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
	private int itemNumber; //id number to be given to each item
	private String description; //description of the item
	private int sellerID; //we will keep track and assign the sellers id to each item that is created
	private int quantity; //quantity of the item
	private double price; //price of the item
	
	
	//constructor for the Item class
	public Item(String n, String d, int s, int q, double p) throws FileNotFoundException, ClassNotFoundException, IOException{ //Item objects will be created by the seller class, the letters are the first letters of the variables above
		this.name = n;
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
	
	
	//testing class
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		Item testItem = new Item("Basketball", "Standard basketball", 11234, 4, 23.24);
		Item test2 = new Item("Football", "Standard football", 1123, 3, 2.23);
		Item test3 = new Item("Car", "Blue car", 1, 3, 4000);
		Item test4 = new Item("dog", "good doge", 1, 2, 33322112);
		System.out.println(testItem.getName());
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("totalInventory.txt"));
		out.writeObject(testItem);
		out.writeObject(test2);
		out.writeObject(test3);
		out.writeObject(test4);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("totalInventory.txt"));
		Item test = (Item) in.readObject();
		System.out.println(test2.getName());
		System.out.println(test3.getItemNumber());
	}
=======
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
	private int itemNumber; //id number to be given to each item
	private String description; //description of the item
	private int sellerID; //we will keep track and assign the sellers id to each item that is created
	private int quantity; //quantity of the item
	private double price; //price of the item
	
	
	//constructor for the Item class
	public Item(String n, String d, int s, int q, double p) throws FileNotFoundException, ClassNotFoundException, IOException{ //Item objects will be created by the seller class, the letters are the first letters of the variables above
		this.name = n;
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
	
	
	//testing class
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		Item testItem = new Item("Basketball", "Standard basketball", 11234, 4, 23.24);
		Item test2 = new Item("Football", "Standard football", 1123, 3, 2.23);
		Item test3 = new Item("Car", "Blue car", 1, 3, 4000);
		Item test4 = new Item("dog", "good doge", 1, 2, 33322112);
		System.out.println(testItem.getName());
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("totalInventory.txt"));
		out.writeObject(testItem);
		out.writeObject(test2);
		out.writeObject(test3);
		out.writeObject(test4);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("totalInventory.txt"));
		Item test = (Item) in.readObject();
		System.out.println(test2.getName());
		System.out.println(test3.getItemNumber());
	}
>>>>>>> 612996a1b44647df7fd3272441f1894893deff5d
}