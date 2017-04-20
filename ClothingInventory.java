//LAST UPDATED: 4/14/2017 2:19p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories with items of category "clothing" to a clothing inventory to
 * be used by the marketplace. 
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ClothingInventory extends Inventory {

	private ArrayList<Item> clothingInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory itemsof category "clothing"
	private File clothingInventoryFile;
	
	public ClothingInventory(String fileName) throws ClassNotFoundException, IOException {
		super(fileName);
	}
	
	//This method will add the items from the sellers inventories of category "clothing" that haven't already been added
	//to the total inventory arraylist.
	public void addItem(Item addItem){
		clothingInventory.add(addItem);
	}
	
	//This method will delete an item from the clothingInventory when a clothing item is sold
	public void deleteItem(Item deleteItem){
		clothingInventory.remove(deleteItem);
	}
		
	//method to return the clothingInventory
	public ArrayList<Item> getTotalInventory(){
		return clothingInventory;
	}
	
	//This method will needed to be done at the end of each run of the program,
	//sets the current arraylist to the file
	public void updateFile(){
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try{
			fout = new FileOutputStream("FILE NAME/LOCATION");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(clothingInventory);
			System.out.println("Completed");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(fout != null){
				try{
					fout.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			if(oos != null){
				try{
					oos.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}	
}