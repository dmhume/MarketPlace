
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Marketplace {
	
	/**
	 * Instance fields
	 */
	private ArrayList<String> buyerIDs;
	private ArrayList<String[]> sellerIDs;
	private ArrayList<Transaction> transactions;
	private ArrayList<Seller> sellers;
	private ArrayList<Buyer> buyers;
	private ArrayList<String[]> shippingStatus;
	private File savedFileBuyerIDs;
	private File savedFileSellerIDs;
	private File savedFileTransactions;
	private File savedFileSellers;
	private File savedFileBuyers;
	private File savedFileShippingStatus;
	
	
	/**
	 * Constructor
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Marketplace() throws ClassNotFoundException, IOException {
		// Automatically reads saved files and assigns contents to instance variables
		// buyerIDs
		String buyerIDFile = "buyerIDs.txt";
		PrintWriter outputBuyerID = new PrintWriter(buyerIDFile);
		outputBuyerID.close();
		buyerIDs = new ArrayList<String>();
		savedFileBuyerIDs = new File(buyerIDFile);
		ObjectInputStream inBuyerIDs = new ObjectInputStream(new FileInputStream("buyerIDs.txt"));
		try{
			String id = null;
			while((id = (String) inBuyerIDs.readObject()) != null){
				buyerIDs.add(id);
			}
			inBuyerIDs.close();
		}
		catch(EOFException e){
			inBuyerIDs.close();
		}
		// SellerIDs
		String sellerIDFile = "sellerIDs.txt";
		PrintWriter outputSellerID = new PrintWriter(sellerIDFile);
		outputSellerID.close();
		sellerIDs = new ArrayList<String[]>();
		savedFileSellerIDs = new File(sellerIDFile);
		ObjectInputStream inSellerIDs = new ObjectInputStream(new FileInputStream("sellerIDs.txt"));
		try{
			String[] id = null;
			while((id = (String[]) inSellerIDs.readObject()) != null){
				sellerIDs.add(id);
			}
			inSellerIDs.close();
		}
		catch(EOFException e){
			inSellerIDs.close();
		}
		// Transaction
		String transactionFile = "transactions.txt";
		PrintWriter outputTransaction = new PrintWriter(transactionFile);
		outputTransaction.close();
		transactions = new ArrayList<Transaction>();
		savedFileTransactions = new File(transactionFile);
		ObjectInputStream inTransaction = new ObjectInputStream(new FileInputStream("transactions.txt"));
		try{
			Transaction transaction = null;
			while((transaction = (Transaction) inTransaction.readObject()) != null){
				transactions.add(transaction);
			}
			inTransaction.close();
		}
		catch(EOFException e){
			inTransaction.close();
		}
		//sellers
		String sellerFile = "sellers.txt";
		PrintWriter outputSellers = new PrintWriter(sellerFile);
		outputSellers.close();
		sellers = new ArrayList<Seller>();
		savedFileSellers = new File(sellerFile);
		ObjectInputStream inSeller = new ObjectInputStream(new FileInputStream("sellers.txt"));
		try{
			Seller seller = null;
			while((seller = (Seller) inSeller.readObject()) != null){
				sellers.add(seller);
			}
			inSeller.close();
		}
		catch(EOFException e){
			inSeller.close();
		}
		// buyers
		String buyerFile = "buyers.txt";
		PrintWriter outputBuyers = new PrintWriter(buyerFile);
		outputBuyers.close();
		buyers = new ArrayList<Buyer>();
		savedFileBuyers = new File(buyerFile);
		ObjectInputStream inBuyer = new ObjectInputStream(new FileInputStream("buyers.txt"));
		try{
			Buyer buyer = null;
			while((buyer = (Buyer) inBuyer.readObject()) != null){
				buyers.add(buyer);
			}
			inBuyer.close();
		}
		catch(EOFException e){
			inBuyer.close();
		}
		// shipping status
		String shippingStatusFile = "shippingStatus.txt";
		PrintWriter outputShipping = new PrintWriter(shippingStatusFile);
		outputShipping.close();
		shippingStatus = new ArrayList<String[]>();
		savedFileShippingStatus = new File(shippingStatusFile);
		ObjectInputStream inShipping = new ObjectInputStream(new FileInputStream("shippingStatus.txt"));
		try{
			String[] status = null;
			while((status = (String[]) inShipping.readObject()) != null){
				shippingStatus.add(status);
			}
			inShipping.close();
		}
		catch(EOFException e){
			inShipping.close();
		}		
	}
	
	/**
	 * Buyer object purchases item, which makes Seller object sends item to Buyer object 
	 * and the item is removed from inventory
	 * @param item Item class object
	 * @param buyer Buyer class Object
	 */
	public void purchasedItem(Item item, Buyer buyer){
		int sellerInitialID = item.getSellerID();
		Seller seller = this.getSeller(sellerInitialID);
		System.out.println(seller.notifyBuyer(item) + " to " + buyer.getAccount().getID());
		this.setTransaction(item, seller, buyer);
		String[] shippingResult = {item.getName(), Integer.toString(item.getItemNumber()), "shipped"};
		shippingStatus.add(shippingResult);
		buyer.getAccount().addHistory(item.getName());
		seller.removeItem(item);
	}
	
	/**
	 * Saves a given seller into ArrayList of seller
	 * @param seller Seller class object
	 */
	public void setSeller(Seller seller) {
		sellers.add(seller);
	}
	
	/**
	 * Saves a given buyer into ArrayList of buyer
	 * @param buyer Buyer class object
	 */
	public void setBuyer(Buyer buyer) {
		buyers.add(buyer);
	}
	
	/**
	 * Returns the seller object which match with a given seller's initial ID 
	 * @param sellerInitialID Integer of seller's initial ID
	 * @return Seller object
	 */
	public Seller getSeller(int sellerInitialID) {
		Seller result = null;
		for (Seller seller : sellers) {
			int initialID = seller.getInitialID();
			if (initialID == sellerInitialID) {
				result = seller;
			}
		}
		return result;
	}	
	
	/**
	 * Returns the buyer object which match with a given buyer's id
	 * @param buyerID String of buyer's ID
	 * @return Buyer object
	 */
	public Buyer getBuyer(String buyerID) {
		Buyer result = null;
		for (Buyer buyer : buyers) {
			String id = buyer.getAccount().getID();
			if (id == buyerID) {
				result = buyer;
			}
		}
		return result;
	}
	
	/**
	 * Returns the list of Buyer object
	 * @return ArrayList of Buyer object
	 */
	public ArrayList<Buyer> getListOfBuyer() {
		return buyers;
	}
	
	/**
	 * Returns the list of Seller object
	 * @return ArrayList of Seller object
	 */
	public ArrayList<Seller> getListofSeller() {
		return sellers;
	}
	
	/**
	 * Gives a unique random ID to a given seller and stores it, when the seller register
	 * @param seller class Seller object
	 */
	public void setSellerInitialID(Seller seller) {
		String[] ids = {Integer.toString(seller.getInitialID()), seller.getAccount().getID()};
		sellerIDs.add(ids);
	}
	
	/**
	 * Gives a unique seller initial ID, when the seller register, the number increases as the number of 
	 * seller increases
	 * @return Integer value of the length of sellerInitialIDs + 1
	 */
	public int createInitailID() {
		return sellerIDs.size() + 1;
	}
	
	/**
	 * Stores a given buyer id in ArrayList.
	 * @param buyer String buyer ID
	 */
	public void setBuyerID(Buyer buyer) {
		buyerIDs.add(buyer.getAccount().getID());
	}
	
	/**
	 * Returns the message to the specific seller that a given item is out of stock 
	 * @param item class Item object
	 * @return String message 
	 */
	public String notifySeller(Item item) {
		String result = "";
		if (item.getQuantity() == 0) {
			result += "Seller Initial ID: " + item.getSellerID() + ", " + item.getName() + "(" + item.getItemNumber() + ")" + " is out of stock!";
		}
		else {
			result += "Available";
		}
		return result;
	}
	
	/**
	 * Returns the buyer ID which matches with a given buyer
	 * @param buyer class Buyer object
	 * @return String buyer ID
	 */
	public String getBuyerID(Buyer buyer) {
		return buyer.getAccount().getID();
	}
	
	/**
	 * Returns the seller ID which matches with a given seller 
	 * @param seller class Seller object
	 * @return String seller ID
	 */
	public String getSellerID(Seller seller) {
		return seller.getAccount().getID();
	}
	
	/**
	 * Returns the transaction history for a given period option
	 * @param history option: 1. All, 2. day, 3. last week, 4. month 
	 * @return String transaction history
	 */
	public String getTransaction(int option) {
		String result = "";
		// All history
		if (option == 1) {
			for (Transaction salesHistory : transactions) {
				String time = salesHistory.getTime();
				String itemNumber = Integer.toString(salesHistory.getItem());
				String sellerInitialID = Integer.toString(salesHistory.getSeller());
				String buyerID = salesHistory.getBuyer();
				result += "Date: " + time + ", Item Number: " + itemNumber + ", Seller Initial ID: " + sellerInitialID + ", Buyer ID: " + buyerID + "\n";
			}
		}//if
		// Specific Day
		else if (option == 2) {
			Scanner userInput = new Scanner(System.in);
			System.out.print("Please enter day as MM/DD: ");
			String userInputDay = userInput.nextLine();
			for (Transaction salesHistory : transactions) {
				String time = salesHistory.getTime();
				if (time.substring(0, 5).equals(userInputDay)) {
					String itemNumber = Integer.toString(salesHistory.getItem());
					String sellerInitialID = Integer.toString(salesHistory.getSeller());
					String buyerID = salesHistory.getBuyer();
					result += "Date: " + time + ", Item Number: " + itemNumber + ", Seller Initial ID: " + sellerInitialID + ", Buyer ID: " + buyerID + "\n";					
				}
			}
		}//else if: specific day
		// Within Last week
		else if (option == 3) {
			DateFormat dfMonth = new SimpleDateFormat("MM");
			DateFormat dfDay = new SimpleDateFormat("dd");
			Date dateobj = new Date();
			int month = Integer.parseInt(dfMonth.format(dateobj));
			int day = Integer.parseInt(dfDay.format(dateobj));
			// if today is less than 8th
			if (day < 8) {
				for (Transaction salesHistory : transactions) {
					String time = salesHistory.getTime();
					int monthTransaction = Integer.parseInt(time.substring(0,2));
					int dayTransaction = Integer.parseInt(time.substring(3, 5));
					// Last month
					if (monthTransaction == month - 1) {
						// 31 day per month: 1, 3, 5, 7, 8, 10, 12
						if (monthTransaction == 1 || monthTransaction == 3 || monthTransaction == 5 || monthTransaction == 7 || monthTransaction == 8 || monthTransaction == 10 || monthTransaction ==12) {
							if (dayTransaction <= 31 && dayTransaction > 31 - (7 - day)) {
								String itemNumber = Integer.toString(salesHistory.getItem());
								String sellerInitialID = Integer.toString(salesHistory.getSeller());
								String buyerID = salesHistory.getBuyer();		
								result += "Date: " + time + ", Item Number: " + itemNumber + ", Seller Initial ID: " + sellerInitialID + ", Buyer ID: " + buyerID + "\n";
							}
						}
						// 30 day per month: 4, 6, 9, 11
						else if (monthTransaction == 4 || monthTransaction == 6 || monthTransaction == 9 || monthTransaction == 11) {
							if (dayTransaction <= 30 && dayTransaction > 30 - (7 - day)) {
								String itemNumber = Integer.toString(salesHistory.getItem());
								String sellerInitialID = Integer.toString(salesHistory.getSeller());
								String buyerID = salesHistory.getBuyer();		
								result += "Date: " + time + ", Item Number: " + itemNumber + ", Seller Initial ID: " + sellerInitialID + ", Buyer ID: " + buyerID + "\n";								
							}
						}
						// Feb.
						else {
							if (dayTransaction <= 28 && dayTransaction > 28 - ( 7- day)) {
								String itemNumber = Integer.toString(salesHistory.getItem());
								String sellerInitialID = Integer.toString(salesHistory.getSeller());
								String buyerID = salesHistory.getBuyer();		
								result += "Date: " + time + ", Item Number: " + itemNumber + ", Seller Initial ID: " + sellerInitialID + ", Buyer ID: " + buyerID + "\n";													
							}
						}
					}//if - last month
					// Same month
					else if (monthTransaction == month) {
						if (dayTransaction >= 1 && dayTransaction < 7 - day) {
							String itemNumber = Integer.toString(salesHistory.getItem());
							String sellerInitialID = Integer.toString(salesHistory.getSeller());
							String buyerID = salesHistory.getBuyer();		
							result += "Date: " + time + ", Item Number: " + itemNumber + ", Seller Initial ID: " + sellerInitialID + ", Buyer ID: " + buyerID + "\n";																			
						}
					}//else if - same month
					}//for loop
			}//if: less than 8th
			// if day is greater than or equal to 8th 
			else {
				for (Transaction salesHistory : transactions) {
					String time = salesHistory.getTime();
					int dayTransaction = Integer.parseInt(time.substring(3, 5));
					if (dayTransaction > day - 7 && dayTransaction < day) {
						String itemNumber = Integer.toString(salesHistory.getItem());
						String sellerInitialID = Integer.toString(salesHistory.getSeller());
						String buyerID = salesHistory.getBuyer();
						result += "Date: " + time + ", Item Number: " + itemNumber + ", Seller Initial ID: " + sellerInitialID + ", Buyer ID: " + buyerID + "\n";
					}
				}
			}// else: day is greater than or equal to 8th
		}// else if: Last week
		// Month
		else if (option == 4) {
			DateFormat dfMonth = new SimpleDateFormat("MM");
			Date dateobj = new Date();
			int month = Integer.parseInt(dfMonth.format(dateobj));
			for (Transaction salesHistory : transactions) {
				String time = salesHistory.getTime();
				int monthTransaction = Integer.parseInt(time.substring(0, 2));
				if (monthTransaction == month) {
					String itemNumber = Integer.toString(salesHistory.getItem());
					String sellerInitialID = Integer.toString(salesHistory.getSeller());
					String buyerID = salesHistory.getBuyer();
					result += "Date: " + time + ", Item Number: " + itemNumber + ", Seller Initial ID: " + sellerInitialID + ", Buyer ID: " + buyerID + "\n";
				}
			}
		}//else if: Month
		
		return result;
	}
	
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
		int sellerInitialID = seller.getInitialID();
		String buyerID = buyer.getAccount().getID();
		Transaction action = new Transaction(itemNumber, sellerInitialID, buyerID, time);
		transactions.add(action);
	}
	
	/**
	 * Returns string of the list of buyer as ID
	 * @return String of the list of buyer
	 */
	public String seeListOfBuyerID() {
		String result = "";
		for (String id : buyerIDs) {
			result += id + ", ";
		}
		return result.substring(0, result.length()-1);
	}
	
	/**
	 * Returns string of the list of seller as ID
	 * @return String of the list of seller
	 */
	public String seeListOfSellerID() {
		String result = "";
		for (String[] id : sellerIDs) {
			result += "Seller Initial ID: " + id[0] + ", Seller ID: " + id[1] + "\n";
		}
		return result;
	}
	
	/**
	 * Returns ArrayList<String> of buyer ID
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> getListOfBuyerID() {
		return buyerIDs;
	}
	
	/**
	 * Returns ArrayList<String[]> of seller ID
	 * @return ArrayList<String[]> of seller ID
	 */
	public ArrayList<String[]> getListofSellerID() {
		return sellerIDs;
	}
	
	/**
	 * Returns items in the inventory of a given seller
	 * @param seller Seller object
	 * @return String of items in the inventory of a given seller
	 */
	public String reportInventoryOfSeller(Seller seller) {
		String result = "";
		for (Item item : seller.getInventory()) {
			result += "Item name: " + item.getName() + ", Quantity: " + item.getQuantity() + "\n";
		}
		return result;
	}
	
	/**
	 * Returns purchased items of a given buyer
	 * @param buyer Buyer class object
	 * @return String of purchased items of a given buyer
	 */
	public String reportBuyerPurchsedHistory(Buyer buyer) {
		String result = "Purchased Items of "+ buyer.getAccount().getID() + ": " + buyer.getAccount().getHistory() + "\n";
		return result;
	}
	
	/**
	 * Creates new Item object and returns Item object
	 * @param seller Seller object 
	 * @return Itme class object
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public Item createItem(Seller seller) throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner name = new Scanner(System.in);
		System.out.print("Item Name: ");
		String ItemName = name.nextLine();
		Scanner desc = new Scanner(System.in);
		System.out.print("Item Description: ");
		String ItemDesc = desc.nextLine();
		int sellerInitialID = seller.getInitialID();
		Scanner quant = new Scanner(System.in);
		System.out.print("Quantity: ");
		int ItemQuantity = quant.nextInt();
		Scanner price = new Scanner(System.in);
		System.out.print("Item price: ");
		Double ItemPrice = price.nextDouble();
		return new Item(ItemName, ItemDesc, sellerInitialID, ItemQuantity, ItemPrice);
	}
	
	/**
	 * Updates all of information needed and saves it as a text file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void updateFile() throws FileNotFoundException, IOException {
		//ArrayList<String> buyerIDs;
		ObjectOutputStream outBuyerIDs = new ObjectOutputStream(new FileOutputStream("buyerIDs.txt"));
		outBuyerIDs.writeObject(buyerIDs);
		outBuyerIDs.close();
		//ArrayList<String[]> sellerIDs;
		ObjectOutputStream outSellerIDs = new ObjectOutputStream(new FileOutputStream("sellerIDs.txt"));
		outSellerIDs.writeObject(sellerIDs);
		outSellerIDs.close();
		//ArrayList<Transaction> transactions;
		ObjectOutputStream outTransactions = new ObjectOutputStream(new FileOutputStream("transactions.txt"));
		outTransactions.writeObject(transactions);
		outTransactions.close();
		//ArrayList<Seller> sellers;
		ObjectOutputStream outSellers = new ObjectOutputStream(new FileOutputStream("sellers.txt"));
		outSellers.writeObject(sellers);
		outSellers.close();
		//ArrayList<Buyer> buyers;
		ObjectOutputStream outBuyers = new ObjectOutputStream(new FileOutputStream("buyers.txt"));
		outBuyers.writeObject(buyers);
		outBuyers.close();
		//ArrayList<String[]> shippingStatus;
		ObjectOutputStream outShipping = new ObjectOutputStream(new FileOutputStream("buyers.txt"));
		outShipping.writeObject(shippingStatus);
		outShipping.close();
	} 
	
	/**
	 * main
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Marketplace test = new Marketplace();
	}

}
