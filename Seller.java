
import java.util.ArrayList;
import java.io.File;

public class Seller {
	
	/**
	 * Instance fields
	 */
	private Account account;
	private Inventory inventories;
	private int initialID; // Marketplace system will issue
	private ArrayList<Item> inventory; // Needs to be saved
	private File savedFile;
	
	/**
	 * Constructor
	 */
	public Seller(int id, String pw, String email, String name) {
		account = new Account(id, pw, email, name);
		inventories = new Inventory("fileName");
	}
	
	/**
	 * Adds a given item to Inventory class object
	 * @param item Item class object
	 */
	public void addItem(Item item) {}
	
	/**
	 * Removes given item from Inventory class and inventory ArrayList of Seller class
	 * @param item Item class object
	 */
	public void removeItem(Item item) {}
	
	/**
	 * Changes the information of item with given info. Based on the parameter, parameter 
	 * needs to be changed to another type such as double for price 
	 * @param info String value of information
	 */
	public void changeItemInfo(String info) {}
	
	/**
	 * Returns the notification message that the purchased item has shipped
	 * @param item Item class object
	 * @return String notification message
	 */
	public String notifyBuyer(Item item) {}
	
	/**
	 * Adds a given item to ArrayList of inventory of Seller
	 * @param item Item class objecct
	 */
	public void addToInventory(Item item) {}
	
	/**
	 * Updates all of inventory information needed and saves it as a text file
	 */
	public void updateFile() {}
	

}
