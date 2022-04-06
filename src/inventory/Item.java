package inventory;

public class Item {
	private String itemName;
	private char itemType;
	private int itemLevel;
	private int itemEffect;
	private Boolean equipped;
	
	public Item() {
		itemName = "";
		itemType = 'n';
		itemLevel = 0;
		itemEffect = 0;
		equipped = false;
	}
	
	public Item(String itemName, char itemType, int itemLevel, int itemEffect) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemLevel = itemLevel;
		this.itemEffect = itemEffect;
		equipped = false;
	}
	
	public void SetItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String GetItemName() {
		return itemName;
	}
	
	public void SetItemLevel(int itemLevel) {
		this.itemLevel = itemLevel;
	}
	
	public int GetItemLevel() {
		return itemLevel;
	}

	public char GetItemType() {
		return itemType;
	}

	public void SetItemType(char itemType) {
		this.itemType = itemType;
	}
	
	public void SetEquipped(Boolean equipped) {
		this.equipped = equipped;
	}
	
	public Boolean IsEquipped() {
		return equipped;
	}

	public int GetItemEffect() {
		return itemEffect;
	}

	public void SetItemEffect(int itemEffect) {
		this.itemEffect = itemEffect;
	}
}

