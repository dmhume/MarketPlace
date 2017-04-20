//LAST UPDATED: 4/14/2017 2:17p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories with items of category "toy" to a toy inventory to
 * be used by the marketplace. 
 */

import java.io.File;
import java.util.ArrayList;

public class ToyInventory extends Inventory {

	private ArrayList<Item> toyInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory items of category "toy"
	private File toyInventoryFile;
	
	public ToyInventory(File f) {
		super(f);
		// TODO Auto-generated constructor stub
	}
	
	//This method will add the items from the sellers inventories of category toy that haven't already been added
	//to the total inventory arraylist.
	public void addItem(){
		//TO-DO
	}
	
	//This method will delete an item from the toy inventory when a toy item is sold
	public void deleteItem(){
		//TO-DO
	}
		
	//method to return the toyInventory
	public ArrayList<Item> getTotalInventory(){
		return toyInventory;
	}
	
	//This method will needed to be done at the end of each run of the program,
	//sets the current arraylist to the file
	public void updateFile(){
		//TO-DO
	}	
}
