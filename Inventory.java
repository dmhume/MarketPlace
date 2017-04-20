//LAST UPDATED: 4/14/2017 2:08p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories to a total inventory to
 * be used by the marketplace. 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Inventory {

	private ArrayList<Item> totalInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory items
	private File totalInventoryFile;
	
	//Inventory constructor, will take in the file name that contains the inventory as the parameter
	public Inventory(String fileName) throws IOException, ClassNotFoundException{
		ObjectOutputStream oos = null;
		
	}
	
	//This method will add the items from the sellers inventories that haven't already been added
	//to the total inventory arraylist.
	public void addItem(Item addItem){
		totalInventory.add(addItem);
	}
	
	//This method will delete an item from the total inventory when an item is sold
	public void deleteItem(Item deleteItem){
		totalInventory.remove(deleteItem);
	}
	
	//method to return the totalInventory
	public ArrayList<Item> getTotalInventory(){
		return totalInventory;
	}
	
	//This method will needed to be done at the end of each run of the program,
	//sets the current arraylist to the file
	public void updateFile(){
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try{
			fout = new FileOutputStream("FILE NAME/LOCATION");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(totalInventory);
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
