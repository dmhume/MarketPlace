
import java.util.ArrayList;
import java.io.File;

public class Marketplace {
	
	/**
	 * Instance fields
	 */
	private ArrayList<String> buyerIDs;
	private ArrayList<String> sellerIDS;
	private ArrayList<Transaction> transactions;
	private File savedFile;
	
	/**
	 * Constructor
	 */
	public Marketplace() {
		// Automatically reads saved files and assigns contents to instance variables
		
	}
	
	/**
	 * Returns search results based on a search keyword, which could be item name, categories, 
	 * item number, etc
	 * @return String search results based on the keyword
	 */
	public String search(String keyword) {}
	
	/**
	 * Buyer object purchases item, which makes Seller object sends item to Buyer object 
	 * and the item is removed from inventory
	 * @param item Item class object
	 */
	public void purchasedItem(Item item) {}
	
	/**
	 * Gives a unique random ID to a given seller and stores it, when the seller register
	 * @param seller class Seller object
	 */
	public void setSellerID(Seller seller) {}
	
	/**
	 * Stores a given buyer id in ArrayList.
	 * @param buyer String buyer ID
	 */
	public void setBuyerID(String id) {}
	
	/**
	 * Returns the message to the specific seller that a given item is out of stock 
	 * @param item class Item object
	 * @return String message 
	 */
	public String notifySeller(Item item) {}
	
	/**
	 * Returns the buyer ID which matches with a given buyer
	 * @param buyer class Buyer object
	 * @return String buyer ID
	 */
	public String getBuyerID(Buyer buyer) {}
	
	/**
	 * Returns the seller ID which matches with a given seller 
	 * @param seller class Seller object
	 * @return String seller ID
	 */
	public String getSellerID(Seller seller) {}
	
	/**
	 * Returns the transaction history for a given object such as a seller, a buyer or a item
	 * @param buyerOrSeller Seller object, Buyer object, or Item object
	 * @return String transaction history
	 */
	public String getTransaction(Object buyerOrSellerOrItem) {}
	
	/**
	 * Saved the transaction history to the ArrayList in instance fields with item, seller, and buyer
	 * @param item class Item object
	 * @param seller class Seller object
	 * @param buyer class Buyer object
	 */
	public void setTransaction(Item item, Seller seller, Buyer buyer) {}
	
	/**
	 * Updates all of information needed and saves it as a text file
	 */
	public void updateFile() {} 

}
