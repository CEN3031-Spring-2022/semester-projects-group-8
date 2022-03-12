package inventory;

public class Item {
	private String itemName;
	private int count;
	
	public Item() {
		itemName = "";
		count = -1;
	}
	
	public Item(String itemName) {
		this.itemName = itemName;
		count = 1;
	}
	
	public void SetItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String GetItemName() {
		return itemName;
	}
	
	public void IncrementCount() {
		count++;
	}
	
	public void DecrementCount() {
		count--;
	}
	
	public int GetCount() {
		return count;
	}
}
