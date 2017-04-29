
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//LAST UPDATED: 4/14/2017 2:36p.m.

/**
 * @author David Hume, Yonghoon Park, Derrick Frasur
 *
 * This class will act as a simple menu to run when the program opens, and interact with the user
 */


public class Menu {

	private Inventory totalInventory;
	private ArrayList<Item> totalInv;
	private Marketplace newMarket;
	
	
	
	// Default Constructor
	public Menu() throws IOException, ClassNotFoundException { 
		
	}
	
	// returns the marketplace
	public Marketplace getMarket() {
		return newMarket;
	}
	
	// returns the totalInv
	public ArrayList<Item> getTotalInv() {
		return totalInv;
	}
	
	
	
	// View the current objects within the inventory
	public void viewInventory() {
		
		System.out.println("Number of items: " + totalInv.size());
		System.out.println("Name : Item Number");
		
		for (int i = 0; i < totalInv.size(); i++) { // displays the total inventory
			
			System.out.println(totalInv.get(i).getName() + " : " + totalInv.get(i).getItemNumber());
			
		}
		
	}
	
	// Introduces the total inventory to be used within the MarketPlace
	public void createInventory() throws IOException, ClassNotFoundException{
		Inventory totalInventory = new Inventory();
		totalInv = totalInventory.getTotalInventory();
	}
	
	// Search for a specific object from the inventory
	public void searchInventory() {
		
		ArrayList<Item> subInventory = new ArrayList<>(); //creates an ArrayList to hold valid search items
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Search an item by name: ");
		String input = scan.next();
		scan.close();
		
		for (int i = 0; i < totalInv.size(); i ++) { //adds all valid search items to subInventory
			
			if (totalInv.get(i).getName().contains(input)) {
				subInventory.add(totalInv.get(i));
			}			
		}
		
		System.out.println("Number of items: " + subInventory.size());
		System.out.println("Name : Item Number");
		
		for (int i = 0; i < subInventory.size(); i++) { //displays subInventory
			
			System.out.println(subInventory.get(i).getName() + " : " + subInventory.get(i).getItemNumber());
			
		}
	}
	
	// Main method :: displays the menu with all of its options
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Menu instance = new Menu();
		instance.newMarket = new Marketplace();
		instance.totalInventory = new Inventory();
		instance.totalInv = instance.totalInventory.getTotalInventory();
		
		int contRunning = 1;
		
		do {
			
			System.out.println("Please type 1 for Buyer login, 2 for Seller login, 3 to create a new account, or 4 to quit: ");
			Scanner loginType = new Scanner(System.in);
			int loginSelect = loginType.nextInt();
		
			if (loginSelect == 1) { // allows buyers to log in
		
				Scanner idInput = new Scanner(System.in);
				System.out.println("Please input your user name: ");
				String username = idInput.next();
				System.out.println("Please input your password: ");
				String password = idInput.next();
				
				if (instance.newMarket.getListOfBuyerID().contains(username)) {
				
					Buyer checkBuyer = instance.newMarket.getBuyer(username);
					
					if (checkBuyer == null) {
						System.out.println("That user does not exist.");
						
					} else {
						if (checkBuyer.getAccount().getPassword() != password) {
							System.out.println("Either the username or password is incorrect.");
						} else {
							int userValue;
							do {
							
								System.out.println("Please select the number of the option you wish to perform.");
								System.out.println("1 : Buy an item by ID");
								System.out.println("2 : Browse all items");
								System.out.println("3 : Search for an item by name");
								System.out.println("4 : Update Account information");
								System.out.println("5 : View Transaction History");
								System.out.println("6 : Quit");
							
								Scanner userChoice = new Scanner(System.in);
								userValue = userChoice.nextInt();
							
								if (userValue == 1) {
								
									System.out.println("Please enter the item number of the object you wish to buy");
									Scanner buyItem = new Scanner(System.in);
									int purchaseChoice = buyItem.nextInt();
									
									// TODO
									
								} else if (userValue == 2) {
								
									instance.viewInventory();
									
								} else if (userValue == 3) {
								
									instance.searchInventory();
									
								} else if (userValue == 4) {
									
									System.out.println("What would you like to update?");
									System.out.println("1 : Name");
									System.out.println("2 : Username");
									System.out.println("3 : Password");
									System.out.println("4 : Back");
									
									Scanner userInput = new Scanner(System.in);
									int userSelect = userInput.nextInt();
									
									if (userSelect == 1) {
										
										System.out.println("What would you like to change your name to?");
										Scanner nameUpdate = new Scanner(System.in);
										String nameChange = nameUpdate.next();
										
										checkBuyer.getAccount().setName(nameChange);
										
									} else if (userSelect == 2) {
										
										System.out.println("What would you like to change your username to?");
										Scanner usernameUpdate = new Scanner(System.in);
										String usernameChange = usernameUpdate.next();
										
										checkBuyer.getAccount().setID(usernameChange);
										
									} else if (userSelect == 3) {
										
										System.out.println("What would you like to change your password to?");
										Scanner passwordUpdate = new Scanner(System.in);
										String passwordChange = passwordUpdate.next();
										
										checkBuyer.getAccount().setPassword(passwordChange);
										
									} else if (userSelect == 4) {
										
									} else {
										System.out.println("That is an invalid choice. You have returned to the previous menu.");
									}
									
									
								
								} else if (userValue == 5) {
								
									System.out.println("Select which option of Transaction history you wish to view.");
									System.out.println("1 : All transaction history");
									System.out.println("2 : Transaction history for a specific day day");
									System.out.println("3 : Transaction history for the past week");
									System.out.println("4 : Transaction History for the past month");
									Scanner transaction = new Scanner(System.in);
									int transactionChoice = transaction.nextInt();
									
									instance.newMarket.getTransaction(transactionChoice);
									
								} else if (userValue == 6) {
									
								} else {
								
									System.out.println("That is not a valid choice.");
									
								}
							
							} while (userValue != 5);	
						}
					}
					
				}
				
				
		
			} else if (loginSelect == 2) { // allows sellers to log in
				
				Scanner idInput = new Scanner(System.in);
				System.out.println("Please input your user name: ");
				int username = idInput.nextInt();
				System.out.println("Please input your password: ");
				String password = idInput.next();
				
				if (instance.newMarket.getListofSellerID().contains(username)) {
				
					Seller checkSeller = instance.newMarket.getSeller(username);
					
					if (checkSeller == null) {
						System.out.println("That user does not exist.");
						
					} else {
						if (checkSeller.getAccount().getPassword() != password) {
							System.out.println("Either the username or password is incorrect.");
						} else {
							int userValue;
							do {
							
								System.out.println("Please select the number of the option you wish to perform.");
								System.out.println("1 : Add items for sale");
								System.out.println("2 : Remove items for sale");
								System.out.println("3 : View Transaction History");
								System.out.println("4 : Update Account Information");
								System.out.println("5 : Quit");
							
								Scanner userChoice = new Scanner(System.in);
								userValue = userChoice.nextInt();
							
								if (userValue == 1) {
								
									
									
								} else if (userValue == 2) {
								
									
									
								} else if (userValue == 3) {
								
									System.out.println("Select which option of Transaction history you wish to view.");
									System.out.println("1 : All transaction history");
									System.out.println("2 : Transaction history for a specific day day");
									System.out.println("3 : Transaction history for the past week");
									System.out.println("4 : Transaction History for the past month");
									Scanner transaction = new Scanner(System.in);
									int transactionChoice = transaction.nextInt();
									
									instance.newMarket.getTransaction(transactionChoice);
									
								} else if (userValue == 4) {
									
									System.out.println("What would you like to update?");
									System.out.println("1 : Name");
									System.out.println("2 : Username");
									System.out.println("3 : Password");
									System.out.println("4 : Back");
									
									Scanner userInput = new Scanner(System.in);
									int userSelect = userInput.nextInt();
									
									if (userSelect == 1) {
										
										System.out.println("What would you like to change your name to?");
										Scanner nameUpdate = new Scanner(System.in);
										String nameChange = nameUpdate.next();
										
										checkSeller.getAccount().setName(nameChange);
										
									} else if (userSelect == 2) {
										
										System.out.println("What would you like to change your username to?");
										Scanner usernameUpdate = new Scanner(System.in);
										String usernameChange = usernameUpdate.next();
										
										checkSeller.getAccount().setID(usernameChange);
										
									} else if (userSelect == 3) {
										
										System.out.println("What would you like to change your password to?");
										Scanner passwordUpdate = new Scanner(System.in);
										String passwordChange = passwordUpdate.next();
										
										checkSeller.getAccount().setPassword(passwordChange);
										
									} else if (userSelect == 4) {
										
									} else {
										System.out.println("That is an invalid choice. You have returned to the previous menu.");
									}
									
									
								
								} else if (userValue == 5) {
								
								} else {
								
									System.out.println("That is not a valid choice.");
									
								}
							
							} while (userValue != 5);	
						}
					}
					
				}
				
			
			} else if (loginSelect == 3) { // allows for the creation of new buyer and seller accounts
				
				int accountChoice;
				
				do {
				
					Scanner accountType = new Scanner(System.in);
					System.out.println("Type 1 if you would like to create a new buyer, 2 if you would like to create a new Seller, or 3 to go back: ");
					accountChoice = accountType.nextInt();
					
					if (accountChoice == 1) {
						
						do { // creates a new buyer account
							
							Scanner accountInfo = new Scanner(System.in);
						
							System.out.println("Please input your email: ");
							String emailInput = accountInfo.next();
							System.out.println("Please input your name: ");
							String nameInput = accountInfo.next();
							System.out.println("Please select a username: ");
							String usernameInput = accountInfo.next();
							System.out.println("Please select a password");
							String passwordInput = accountInfo.next();
							
							if (instance.getMarket().getListOfBuyerID().contains(usernameInput)) {
								
								System.out.println("That username is already taken. Please choose another.");
								
							} else {
								
								Buyer newBuyer = new Buyer(usernameInput, passwordInput, emailInput, nameInput);
								instance.newMarket.setBuyer(newBuyer);
								instance.newMarket.setBuyerID(newBuyer);
								
								accountChoice = 3;
								
							}
						
						} while (accountChoice != 3);
						
					} else if (accountChoice == 2) {
						
						do { // creates a new seller account
							
							Scanner accountInfo = new Scanner(System.in);
						
							System.out.println("Please input your email: ");
							String emailInput = accountInfo.next();
							System.out.println("Please input your name: ");
							String nameInput = accountInfo.next();
							System.out.println("Please select a username: ");
							String usernameInput = accountInfo.next();
							System.out.println("Please select a password");
							String passwordInput = accountInfo.next();
							
							if (instance.getMarket().getListofSellerID().contains(usernameInput)) {
								
								System.out.println("That username is already taken. Please choose another.");
								
							} else {
								
								int newID = instance.newMarket.createInitailID();
								
								Seller newSeller = new Seller(newID, usernameInput, passwordInput, emailInput, nameInput);

								instance.getMarket().setSeller(newSeller);
								instance.getMarket().setSellerID(newSeller);
								
								accountChoice = 3;
								
							}
							
						} while (accountChoice != 3);
					
					} else if (accountChoice == 3) { // returns to the original menu
					
					} else { // forces user to repeat section with a valid choice
						System.out.println("That is an invalid choice. Please choose again.");
						loginSelect = 3;
					}
					
				} while (accountChoice != 3);
				
			} else if (loginSelect == 4) { // exits the marketplace
				
				contRunning = 0;
				
			} else { // forces a valid input from the user
				System.out.println("That is not an option, please try again.");
			}
		
		} while (contRunning != 0);
		
		
	}
	
}
