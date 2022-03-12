package inventory;

import java.util.Vector;

public class Inventory {
	private Vector<Item> v;
	
	public Inventory() {
		v = new Vector<Item>();
	}
	
	public int Find(String itemName) {
		for (int i = 0; i < v.size(); i++) {
			if (v.elementAt(i).GetItemName() == itemName)
				return i;
		}
		return -1;
	}
	
	public void AddItem(String itemName) {
		int index = Find(itemName);
		if (index == -1) {
			Item item = new Item(itemName);
			v.add(item);
		}
		else {
			v.elementAt(index).IncrementCount();
		}
	}
}
