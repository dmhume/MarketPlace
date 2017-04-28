
public class Buyer {
	
	/**
	 * Instance fields
	 */
	private Account account;
	
	/**
	 * Constructor
	 */
	public Buyer(String id, String pw, String email, String name) {
		account = new Account(id, pw, email, name);
	}
	
	/**
	 * Returns buyer's account
	 * @return Account class of this buyer
	 */
	public Account getAccount() {
		return account;
	}
	

}
