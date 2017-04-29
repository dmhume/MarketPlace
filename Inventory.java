<<<<<<< HEAD
//LAST UPDATED: 4/14/2017 2:08p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories to a total inventory to
 * be used by the marketplace. 
 */

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory implements Serializable {

	private ArrayList<Item> totalInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory items
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
		/*Scanner scan = new Scanner(totalInventoryFile);
		Item item = (Item) in.readObject();
		totalInventory.add(item);*/

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
		System.out.println(a.get(1).getItemNumber());
		System.out.println(a.get(2).getName());
	}
=======
//LAST UPDATED: 4/14/2017 2:08p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories to a total inventory to
 * be used by the marketplace. 
 */

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory implements Serializable {

	private ArrayList<Item> totalInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory items
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
		/*Scanner scan = new Scanner(totalInventoryFile);
		Item item = (Item) in.readObject();
		totalInventory.add(item);*/

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
		System.out.println(a.get(1).getItemNumber());
		System.out.println(a.get(2).getName());
	}
>>>>>>> 612996a1b44647df7fd3272441f1894893deff5d
}