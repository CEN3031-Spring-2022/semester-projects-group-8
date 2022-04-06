package inventory;

import java.util.Scanner;

public class inventoryTest {

	public static void main(String[] args) {
		
		Inventory playIn = new Inventory();
		
		playIn.AddItem("Sword", 'w', 20, 130);
		playIn.AddItem("Long Sword", 'w', 30, 180);
		playIn.AddItem("Iron Gear", 'a', 10, 90);
		playIn.AddItem("Dragon Scale Suit", 'a', 90, 300);
		playIn.AddItem("Miracle Elixir", 'p', 70, 200);
		//List of items added from item list
		//Name, type, level, degree of effect
	
		
		playIn.GetInventory();
		//Displays list of items in inventory
		int sel = -1;
		int sizeBefore = -1;
		//size recorded prior in case item removed affects selection for next do-while loop
		Scanner sc = new Scanner(System.in);
		do {
			sizeBefore = playIn.GetSize();
			sel = 0;
			String itemSel = sc.nextLine();
			//Scanner awaits user item selection
			sel = Integer.parseInt(itemSel);
			sel--;
			//selection converted to integer
			if (sel < playIn.GetSize()) {
			playIn.ItemOptions(sel);
			playIn.GetInventory();}
			
		} while (sel < sizeBefore);
		
		sc.close();

}
	
}