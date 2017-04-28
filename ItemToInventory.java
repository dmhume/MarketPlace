/*
 * @Author David Hume, Derek Frasur, Yonghoon Park
 * This class will be instantiated immediately after an item is created, adding the item to the totalInventory file
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ItemToInventory {

	private Item item; //item instance
	
	public ItemToInventory(Item i) throws IOException{
		this.item = i;
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("totalInventory.txt"));
		out.writeObject(item);
		out.close();
	}
	
}
