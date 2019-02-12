package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

	
	private Inventory inventoryTest; 
	
	@Before
	public void setup() {	
		inventoryTest = new Inventory(new FileReader()); 
	}
	
	
	@Test
	public void check_innitial_inventory_() {
		Assert.assertEquals( 5, inventoryTest.returnCurrentInventory("A1")); 
	}
	
	@Test
	public void subtract_from_inventory_() {
		inventoryTest.subtractFromInventory("A1");
		Assert.assertEquals( 4, inventoryTest.returnCurrentInventory("A1")); 
	}
	
	
	@Test
	public void subtract_from_inventory_b3_() {
		inventoryTest.subtractFromInventory("B3");
		inventoryTest.subtractFromInventory("B3");
		Assert.assertEquals( 3, inventoryTest.returnCurrentInventory("B3")); 
	}
	
	
//	@Test
//	public void fail_with_invalid_slot() {
//		// Arrange
//		// Act  
//		inventoryTest.subtractFromInventory("B6");
//		inventoryTest.subtractFromInventory("B6");
//		// Assert
//		Assert.assertEquals( 3, inventoryTest.returnCurrentInventory("B6")); 
//	}
	

	@Test
	public void name_at_A1_test() {
		Assert.assertEquals("Potato Crisps", inventoryTest.vendingMachineStock().get("A1").getName()); 
	}
	
	
	@Test
	public void price_at_A1_test() {
		Assert.assertEquals("3.05", inventoryTest.vendingMachineStock().get("A1").getPriceAsString()); 
	}
	
	@Test
	public void price_at_B2_test() {
		Assert.assertEquals("1.50", inventoryTest.vendingMachineStock().get("B2").getPriceAsString()); 
	}
	
	@Test
	public void name_at_B2_test() {
		Assert.assertEquals("Cowtales", inventoryTest.vendingMachineStock().get("B2").getName()); 
	}
	
	
	@Test
	public void name_at_A2_test() {
		Assert.assertEquals("Stackers", inventoryTest.vendingMachineStock().get("A2").getName()); 
	}
	
	
	@Test
	public void price_at_A2_test() {
		Assert.assertEquals(145, inventoryTest.vendingMachineStock().get("A2").getPriceAsIntInPennies()); 
	}
	
	@Test
	public void string_price_at_A2_test()  {
		Assert.assertEquals("1.45", inventoryTest.vendingMachineStock().get("A2").getPriceAsString()); 
	}
	
}
