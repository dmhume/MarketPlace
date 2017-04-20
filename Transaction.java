
//LAST UPDATED: 4/14/2017 2:34p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine keep track of all transactions through a file we will store and update in
 */


import java.io.File;

public class Transaction {

	// Instance variables
	private int buyerID;
	private int sellerID;
	private int itemSold;
	private File transactions;
	
	
	// Default Constructor
	public Transaction(File f) { }
	
	
	// Setter Methods
	public void setBuyer(int user) { 
		buyerID = user;
	}
	
	public void setSeller(int user) {
		sellerID = user;
	}
	
	public void setItem(int item) {
		itemSold = item;
	}
	
	
	// Getter Methods
	public int getBuyer() {
		return buyerID;
	}
	
	public int getSeller() {
		return sellerID;
	}
	
	public int getItem() {
		return itemSold;
	}
	
	//method to update file containing transactions
	public void updateFile(){
		//TO-DO
	}
	
}
