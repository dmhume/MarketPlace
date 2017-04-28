
//LAST UPDATED: 4/14/2017 2:34p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine keep track of all transactions through a file we will store and update in
 */


import java.io.File;

public class Transaction {

	// Instance variables
	private String buyerID;
	private int sellerInitialID;
	private int itemSold;
	private String transactionTime;
	private File transactions;
	
	
	// Default Constructor
	public Transaction(int itemNumber, int sellerid, String buyerid, String time) {
		buyerID = buyerid;
		sellerInitialID = sellerid;
		itemSold = itemNumber;
		transactionTime = time;
	}
	
	
	// Setter Methods
	public void setBuyer(String user) { 
		buyerID = user;
	}
	
	public void setSeller(int user) {
		sellerInitialID = user;
	}
	
	public void setItem(int item) {
		itemSold = item;
	}
	
	
	// Getter Methods
	public String getBuyer() {
		return buyerID;
	}
	
	public int getSeller() {
		return sellerInitialID;
	}
	
	public int getItem() {
		return itemSold;
	}
	

	
}
