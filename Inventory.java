//LAST UPDATED: 4/14/2017 2:08p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories to a total inventory to
 * be used by the marketplace. 
 */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.ArrayList;

public class Inventory implements Serializable {

	private static ArrayList<Item> totalInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory items
	private static ArrayList<Item> toyInventory = new ArrayList<Item>();  //the ArrayList to contain all inventory items of category "toy"
	private static ArrayList<Item> booksInventory = new ArrayList<Item>();  //the ArrayList to contain all inventory items of category "books"
	private static ArrayList<Item> clothingInventory = new ArrayList<Item>();  //the ArrayList to contain all inventory items of category "clothing"
	private static ArrayList<Item> electronicsInventory = new ArrayList<Item>();  //the ArrayList to contain all inventory items of category "electronics"
	private static ArrayList<Item> healthFoodInventory = new ArrayList<Item>();  //the ArrayList to contain all inventory items of category "healthFood"
	private static ArrayList<Item> homeGardenInventory = new ArrayList<Item>();  //the ArrayList to contain all inventory items of category "homeGarden"
	private static ArrayList<Item> mediaInventory = new ArrayList<Item>();  //the ArrayList to contain all inventory items of category "media"
	private static ArrayList<Item> outdoor = new ArrayList<Item>();  //the ArrayList to contain all inventory items of category "outdoor"
	private static File totalInventoryFile;
	
	//Inventory constructor, will take in the file name that contains the inventory as the parameter
	public Inventory() throws IOException, ClassNotFoundException{
		totalInventoryFile = new File("totalInventory.txt");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("totalInventory.txt"));	
		
		try{
			Item item = null;
			while((item = (Item) in.readObject()) != null){
				totalInventory.add(item);
			}
			in.close();
		}
		catch(EOFException e){
			in.close();
		}
	}
	
	//This method will add the items from the sellers inventories that haven't already been added
	//to the total inventory arraylist.
	public void addItem(Item addItem){
		totalInventory.add(addItem);
		updateFile();
	}
	
	//This method will delete an item from the total inventory when an item is sold
	public void deleteItem(Item deleteItem){
		totalInventory.remove(deleteItem);
		updateFile();
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
			fout = new FileOutputStream("inventory.txt");
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
	
	//test method
	public static void main (String[] args) throws ClassNotFoundException, IOException{
		Inventory inv = new Inventory();
		ArrayList<Item> a = inv.getTotalInventory();
		System.out.println(totalInventoryFile);
		System.out.println(a.get(1).getName());
		System.out.println(totalInventory.size());
	}
}
