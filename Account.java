
import java.util.ArrayList;

public class Account {
	
	/**
	 * Instance fields (Needs to be saved)
	 */
	public final int ID;
	private String password;
	private String emailAddress;
	private String name;
	private ArrayList<Item> history; // Needs to be saved
	
	/**
	 * Constructor
	 */
	public Account(int id, String pw, String email, String name) {}
	
	/**
	 * Returns ID
	 * @return String ID number 
	 */
	public String getID() {}
	
	/**
	 * Returns name
	 * @return String name
	 */
	public String getName() {}
	
	/**
	 * Returns password
	 * @return String password
	 */
	public String getPassword() {}
	
	/**
	 * Replaces ID with given new ID
	 * @param id Sting new ID
	 */
	public void setID(String newID) {}
	
	/**
	 * Replaces name with given new name
	 * @param newName String new name
	 */
	public void setName(String newName) {}
	
	/**
	 * Replaces password with given new password
	 * @param newPass String new password
	 */
	public void setPassword(String newPass) {}
	
	/**
	 * Returns the history of purchased items for a buyer or of sold items for a seller
	 * @return String history of items purchased or sold
	 */
	public String getHistory() {}
	
	/**
	 * Adds purchased item to history ArrayList
	 * @param purchasedItem Item object
	 */
	public void addHistory(Item purchasedItem) {}
	
	/**
	 * Returns all of account information as String
	 * @return String account information
	 */
	public String getAccountInformation() {}
	

}
