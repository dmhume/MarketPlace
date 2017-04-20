//LAST UPDATED: 4/14/2017 2:08p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories to a total inventory to
 * be used by the marketplace. 
 */

import java.io.File;
import java.util.ArrayList;

public class Inventory {

	private ArrayList<Item> totalInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory items
	private File totalInventoryFile;
	
	//Inventory constructor, will take in the File that contains the inventory as the parameter
	public Inventory(File f){
		//TO-DO
	}
	
	//This method will add the items from the sellers inventories that haven't already been added
	//to the total inventory arraylist.
	public void addItem(){
		//TO-DO
	}
	
	//This method will delete an item from the total inventory when an item is sold
	public void deleteItem(){
		//TO-DO
	}
	
	//method to return the totalInventory
	public ArrayList<Item> getTotalInventory(){
		return totalInventory;
	}
	
	//This method will needed to be done at the end of each run of the program,
	//sets the current arraylist to the file
	public void updateFile(){
		//TO-DO
	}
}
