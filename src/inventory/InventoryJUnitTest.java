package inventory;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class InventoryJUnitTest {

	@Test
	public void checkThatItemIsAddedToInventory() 
	{
		Inventory testInventory = new Inventory();
		
		testInventory.AddItem("Long Sword", 'w', 1, 0);
		testInventory.AddItem("Fire Wand", 'w', 1, 1);
		
		assertEquals(2, testInventory.GetSize());		
	}
	
	@Test
	public void checkThatItemIsStoredProperly()
	{
		Inventory testInventory = new Inventory();		
		
		testInventory.AddItem("Long Sword", 'w', 1, 0);
		testInventory.AddItem("Fire Wand", 'w', 1, 1);
		
		assertEquals(0, testInventory.Find("Long Sword"));
		assertEquals(1, testInventory.Find("Fire Wand"));
		
	}
	
	@Test
	public void testRemovalOfItem()
	{
		Inventory testInventory = new Inventory();
		
		testInventory.AddItem("Long Sword", 'w', 1, 0);
		testInventory.AddItem("Fire Wand", 'w', 1, 1);
		testInventory.AddItem("Bow", 'w', 1, 0);
		testInventory.AddItem("Demon Blade", 'w', 10, 3);
		testInventory.AddItem("Potion", 'p', 1, 0);
		testInventory.RemoveItem(3);
		
		assertEquals(4, testInventory.GetSize());
		
	}
}
