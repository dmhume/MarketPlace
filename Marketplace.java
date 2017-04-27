
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Marketplace {
	
	/**
	 * Instance fields
	 */
	private ArrayList<String> buyerIDs;
	private ArrayList<String> sellerIDs;
	private ArrayList<Transaction> transactions;
	private File savedFileBuyerIDs;
	private File savedFileSellerIDs;
	private File savedFileTransactions;
	
	/**
	 * Constructor
	 * @throws FileNotFoundException 
	 */
	public Marketplace() throws FileNotFoundException {
		// Automatically reads saved files and assigns contents to instance variables
		// buyerIDs
		String buyerIDFile = "buyerIDs.txt";
		PrintWriter outputBuyerID = new PrintWriter(buyerIDFile);
		outputBuyerID.close();
		buyerIDs = new ArrayList<String>();
		savedFileBuyerIDs = new File(buyerIDFile);
		Scanner fileBuyerIDs = new Scanner(savedFileBuyerIDs);
		while (fileBuyerIDs.hasNext()) {
			String id = fileBuyerIDs.next();
			buyerIDs.add(id);
		}
		// SellerIDs
		String sellerIDFile = "sellerIDs.txt";
		PrintWriter outputSellerID = new PrintWriter(sellerIDFile);
		outputSellerID.close();
		sellerIDs = new ArrayList<String>();
		savedFileSellerIDs = new File(sellerIDFile);
		Scanner fileSellerIDs = new Scanner(savedFileSellerIDs);
		while (fileSellerIDs.hasNext()) {
			String id  = fileSellerIDs.next();
			sellerIDs.add(id);
		}
		// Transaction
		String transactionFile = "transactions.txt";
		PrintWriter outputTransaction = new PrintWriter(transactionFile);
		outputTransaction.close();
		transactions = new ArrayList<Transaction>();
		savedFileTransactions = new File(transactionFile);
		Scanner fileTransactions = new Scanner(savedFileTransactions);
		while (fileTransactions.hasNextLine()) {
			String line = fileTransactions.nextLine();
			// Needs to save transaction history in ArrayList transactions
		}
		
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
	public void setTransaction(Item item, Seller seller, Buyer buyer) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date dateobj = new Date();
		String time = df.format(dateobj);	
		int itemNumber = item.getItemNumber();
		int sellerID = seller.getInitialID();
		int buyerID = buyer.getAccount().getID();
		Transaction action = new Transaction(itemNumber, sellerID, buyerID, time);
		transactions.add(action);
	}
	
	/**
	 * Returns the list of buyer as ID
	 * @return String of the list of buyer
	 */
	public String getBuyerID() {
		String result = "";
		for (String id : buyerIDs) {
			result += id + ", ";
		}
		return result.substring(0, result.length()-1);
	}
	
	/**
	 * Updates all of information needed and saves it as a text file
	 */
	public void updateFile() {} 
	
	/**
	 * main
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Marketplace test = new Marketplace();
	}

}
