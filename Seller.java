
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Seller {
	
	/**
	 * Instance fields
	 */
	private Account account;
	private int initialID; // Marketplace system will issue
	private ArrayList<Item> inventory; // Needs to be saved
	
	/**
	 * Constructor
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Seller(int initial, String id, String pw, String email, String name) throws ClassNotFoundException, IOException {
		account = new Account(id, pw, email, name);
		initialID = initial;
		inventory = new ArrayList<Item>();

	}
	
	/**
	 * Removes given item from Inventory class and inventory ArrayList of Seller class
	 * @param item Item class object
	 */
	public void removeItem(Item item) {
		inventory.remove(item);
	}
	
	/**
	 * Changes the information of item with given info. Based on the parameter 'num', parameter 'info'
	 * needs to be changed to another type such as double for price 
	 * @param info String value of information
	 */
	public void changeItemInfo(int num, String itemName, String info) {
		// 1: name/ 2: itemNumber/ 3: description/ 4: quantity/ 5: price
		for (Item item : inventory) {
			if (itemName.equals(item.getName())) {
				//name
				if (num == 1) {
					item.setName(info);
				}
				else if (num == 2) {
					item.setItemNumber(Integer.parseInt(info));
				}
				else if (num == 3) {
					item.setDescription(info);
				}
				else if (num == 4) {
					item.setQuantity(Integer.parseInt(info));
				}
				else if (num == 5) {
					item.SetPrice(Double.parseDouble(info));
				}
			}//if
		}//for
	}
	
	/**
	 * Returns the notification message that the purchased item has shipped
	 * @param item Item class object
	 * @return String notification message
	 */
	public String notifyBuyer(Item item) {
		String result = item.getName() + " has shipped!";
		return result;
	}
	
	/**
	 * Adds a given item to ArrayList of inventory of Seller
	 * @param item Item class objecct
	 */
	public void addToInventory(Item item) {
		inventory.add(item);
	}
	
	/**
	 * Returns the inventory of this seller
	 * @return ArrayList of inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	/**
	 * Returns seller's initial ID
	 * @return Integer value of initialID
	 */
	public int getInitialID() {
		return initialID;
	}
	
	/**
	 * Returns seller's account
	 * @return Account class seller's account
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * Updates all of inventory information needed and saves it as a text file
	 */
	public String inventoryToString() {
		String result = "";
		for (Item item : inventory) {
			result += item.getName() + "/" + item.getItemNumber() + "/" + item.getDescription() + "/" + item.getSellerID() + "/" + item.getQuantity() + "/" + item.getPrice() + "_";
		}
        return result;
	}

}
