//LAST UPDATED: 4/14/2017 2:19p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories with items of category "books" to a books inventory to
 * be used by the marketplace. 
 */

import java.io.File;
import java.util.ArrayList;

public class BooksInventory extends Inventory {

	private ArrayList<Item> booksInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory itemsof category "books"
	private File booksInventoryFile;
	
	public BooksInventory(File f) {
		super(f);
		// TODO Auto-generated constructor stub
	}
	
	//This method will add the items from the sellers inventories of category "books" that haven't already been added
	//to the total inventory arraylist.
	public void addItem(){
		//TO-DO
	}
	
	//This method will delete an item from the booksInventory when a books item is sold
	public void deleteItem(){
		//TO-DO
	}
		
	//method to return the booksInventory
	public ArrayList<Item> getTotalInventory(){
		return booksInventory;
	}
	
	//This method will needed to be done at the end of each run of the program,
	//sets the current arraylist to the file
	public void updateFile(){
		//TO-DO
	}	
}