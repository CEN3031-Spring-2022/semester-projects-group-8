package inventory;

import java.util.Scanner;
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
		return 0;
	}
	
	public void AddItem(String itemName, char type, int level, int itemEffect) {		
			Item item = new Item(itemName, type, level, itemEffect);
			v.add(item);
	}
	
	public void RemoveItem(int sel) {
		v.remove(sel);
	}
	
	Item GetItem(int index) {
		return v.elementAt(index);
	}
	
	int GetSize() {
		return v.size();
	}
	
	public void GetInventory() {
		System.out.println("------------------------------------");
		System.out.println("Inventory");
		System.out.println("------------------------------------");
		for (int i = 0; i < v.size(); i++) {
			System.out.print(i+1 + ". ");
			
			if (GetItem(i).IsEquipped())
				System.out.print("*");
			System.out.println(GetItem(i).GetItemName() + " " + GetItem(i).GetItemLevel()); }
			System.out.println(v.size()+1 + ". Close Inventory");
	}

	public void ItemOptions(int sel) {
		
		System.out.println(GetItem(sel).GetItemName());
		System.out.println("=================");
		System.out.print(" lvl. ");
		System.out.print(GetItem(sel).GetItemLevel());
		switch (GetItem(sel).GetItemType()) {
		case 'w':
			System.out.println(" Weapon");
			System.out.println(" Damage: " + GetItem(sel).GetItemEffect());
			break;
		case 'p':
			System.out.println(" Potion");
			System.out.println(" Healing: " + GetItem(sel).GetItemEffect());
			break;
		case 'a':
			System.out.println(" Armor");
			System.out.println(" Protection: " + GetItem(sel).GetItemEffect());
			break;
		}
		
		System.out.println("=================");
		if (GetItem(sel).IsEquipped()) {
			System.out.println("1. Dequip");
			System.out.println("2. Dequip & Drop");
		}
		else {
			System.out.println("1. Equip");
			System.out.println("2. Drop");
		}
		System.out.println("3. Cancel");
		
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			if (GetItem(sel).IsEquipped()) {
				GetItem(sel).SetEquipped(false);
			}
			else {
				for (int i = 0; i < v.size(); i++) {
					if (GetItem(i).IsEquipped() && GetItem(i).GetItemType() == GetItem(sel).GetItemType())
						GetItem(i).SetEquipped(false);
					//Dequips all items of the same type before equipping (Can't use two swords)
				}
				GetItem(sel).SetEquipped(true);
			}
			break;
		case "2":
			RemoveItem(sel);
			break;
		}
		sc.close();
		
	}
	
}

