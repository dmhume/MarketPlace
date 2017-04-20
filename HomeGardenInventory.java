//LAST UPDATED: 4/14/2017 2:27p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories with items of category "homeGarden" to a homeGarden inventory to
 * be used by the marketplace. 
 */

import java.io.File;
import java.util.ArrayList;

public class HomeGardenInventory extends Inventory {

	private ArrayList<Item> homeGardenInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory itemsof category "homeGarden"
	private File homeGardenInventoryFile;
	
	public HomeGardenInventory(File f) {
		super(f);
		// TODO Auto-generated constructor stub
	}
	
	//This method will add the items from the sellers inventories of category "homeGarden" that haven't already been added
	//to the total inventory arraylist.
	public void addItem(){
		//TO-DO
	}
	
	//This method will delete an item from the homeGardenInventory when a homeGarden item is sold
	public void deleteItem(){
		//TO-DO
	}
		
	//method to return the homeGardenInventory
	public ArrayList<Item> getTotalInventory(){
		return homeGardenInventory;
	}
	
	//This method will needed to be done at the end of each run of the program,
	//sets the current arraylist to the file
	public void updateFile(){
		//TO-DO
	}	
}