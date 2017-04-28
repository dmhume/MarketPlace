
import java.util.ArrayList;

public class Account {
	
	/**
	 * Instance fields (Needs to be saved)
	 */
	public String ID;
	private String password;
	private String emailAddress;
	private String name;
	private ArrayList<Item> history; // Needs to be saved
	
	/**
	 * Constructor
	 */
	public Account(String id, String pw, String email, String nm) {
		ID = id;
		password = pw;
		emailAddress = email;
		name = nm;
		history = new ArrayList<Item>();
	}
	
	/**
	 * Returns ID
	 * @return Integer ID number 
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * Returns name
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns password
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Returns email address
	 * @return String email address
	 */
	public String getEmail() {
		return emailAddress;
	}
	
	/**
	 * Replaces ID with given new ID
	 * @param id Integer new ID
	 */
	public void setID(String newID) {
		ID = newID;
	}
	
	/**
	 * Replaces name with given new name
	 * @param newName String new name
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Replaces password with given new password
	 * @param newPass String new password
	 */
	public void setPassword(String newPass) {
		password = newPass;
	}
	
	/**
	 * Replaces email with given new email
	 * @param email String new email
	 */
	public void setEmail(String email) {
		emailAddress = email;
	}
	
	/**
	 * Returns the history of purchased items for a buyer or of sold items for a seller
	 * @return String history of items purchased or sold
	 */
	public String getHistory() {
		String result = "";
		for(Item item : history) {
			result += item.getName() + "/";
		}
		return result.substring(0,  result.length()-1);
	}
	
	/**
	 * Adds purchased item to history ArrayList
	 * @param purchasedItem Item object
	 */
	public void addHistory(Item purchasedItem) {
		history.add(purchasedItem);
	}
	
	/**
	 * Prints all of account information as String
	 */
	public void getAccountInformation() {
		System.out.printf("%-15s%20s\n", "ID: ", ID);
		System.out.printf("%-15s%20s\n", "Password: ", password);
		System.out.printf("%-15s%20s\n", "Email Address: ", emailAddress);
		System.out.printf("%-15s%20s\n", "Name: ", name);
	}
	
	// test
	public static void main(String[] args) {
		
		Account test = new Account("idtest", "abc", "abc@ac.com", "Ryan");
		test.getAccountInformation();
		
	}
	
}
