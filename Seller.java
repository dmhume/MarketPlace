
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Seller {
	
	/**
	 * Instance fields
	 */
	private Account account;
	private Inventory inventories;
	private int initialID; // Marketplace system will issue
	private ArrayList<Item> inventory; // Needs to be saved
	private File savedFile;
	
	/**
	 * Constructor
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Seller(int initial, int id, String pw, String email, String name) throws ClassNotFoundException, IOException {
		account = new Account(id, pw, email, name);
		// Creates the text file that contains inventory items
		String filename = "sellerfile.txt";
		PrintWriter output = new PrintWriter(filename);
		output.close();
		inventories = new Inventory(filename);
		initialID = initial;
		// Reads file to save items in inventory ArrayList
		inventory = new ArrayList<Item>();
		savedFile = new File(filename);
		Scanner file = new Scanner(savedFile);
		while(file.hasNextLine()) {
			String line = file.nextLine();
			String [] itemInfo = line.split(",");
			inventory.add(new Item(itemInfo[0], Integer.parseInt(itemInfo[1]), itemInfo[2], Integer.parseInt(itemInfo[3]), Integer.parseInt(itemInfo[4]), Double.parseDouble(itemInfo[5])));
		}
		file.close();
	}
	
	/**
	 * Adds a given item to Inventory class object
	 * @param item Item class object
	 */
	public void addItem(Item item) {
		inventories.addItem(item);
	}
	
	/**
	 * Removes given item from Inventory class and inventory ArrayList of Seller class
	 * @param item Item class object
	 */
	public void removeItem(Item item) {
		inventories.deleteItem(item);
		inventory.remove(item);
	}
	
	/**
	 * Changes the information of item with given info. Based on the parameter 'num', parameter 'info'
	 * needs to be changed to another type such as double for price 
	 * @param info String value of information
	 */
	public void changeItemInfo(int num, String itemName, String info) {
		// 1: name/ 2: itemNumber/ 3: description/ 4: quantity/ 5: price
		for (Item item : inventory) {
			if (itemName.equals(item.getName())) {
				//name
				if (num == 1) {
					item.setName(info);
				}
				else if (num == 2) {
					item.setItemNumber(Integer.parseInt(info));
				}
				else if (num == 3) {
					item.setDescription(info);
				}
				else if (num == 4) {
					item.setQuantity(Integer.parseInt(info));
				}
				else if (num == 5) {
					item.SetPrice(Double.parseDouble(info));
				}
			}//if
		}//for
	}
	
	/**
	 * Returns the notification message that the purchased item has shipped
	 * @param item Item class object
	 * @return String notification message
	 */
	public String notifyBuyer(Item item) {
		String result = item.getName() + " has shipped!";
		return result;
	}
	
	/**
	 * Adds a given item to ArrayList of inventory of Seller
	 * @param item Item class objecct
	 */
	public void addToInventory(Item item) {
		inventory.add(item);
	}
	
	/**
	 * Returns the inventory of this seller
	 * @return ArrayList of inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	/**
	 * Returns seller's initial ID
	 * @return Integer value of initialID
	 */
	public int getInitialID() {
		return initialID;
	}
	
	/**
	 * Updates all of inventory information needed and saves it as a text file
	 */
	public void updateFile() {
		try {
			PrintWriter out = new PrintWriter("sellerfile.txt");
			for (Item item : inventory) {
				out.print(item.getName() + ",");
				out.print(item.getItemNumber() + ",");
				out.print(item.getDescription() + ",");
				out.print(item.getSellerID() + ",");
				out.print(item.getQuantity() + ",");
				out.println(item.getPrice() + ",");
			}
			out.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	

}
