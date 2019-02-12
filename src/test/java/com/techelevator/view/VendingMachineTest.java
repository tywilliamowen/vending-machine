package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	private Inventory vendingMachineInventory;
	private CoinBox vendingMachineCoinBox;
	private FileReader vendingMachineFileReader;
	private VendingMachine vendingMachineTest;

	@Before
	public void setup() {
		vendingMachineFileReader = new FileReader();
		vendingMachineInventory = new Inventory(vendingMachineFileReader);
		vendingMachineTest = new VendingMachine(vendingMachineInventory);
		vendingMachineCoinBox = new CoinBox();
	}

	@Test
	public void check_return_for_item_not_on_map() {
		Assert.assertEquals(null, vendingMachineInventory.vendingMachineStock().get("B52"));
	}

	@Test
	public void purchase_item_not_on_map() {
		Assert.assertEquals("Please Make A Valid Selection", vendingMachineTest.purchaseItem("B52"));
	}

	@Test
	public void name_at_A2_test() {
		Assert.assertEquals("Stackers", vendingMachineInventory.vendingMachineStock().get("A2").getName());
	}

	@Test
	public void return_correct_balance() {
		vendingMachineCoinBox.addMoney(5);
		Assert.assertEquals(500, vendingMachineCoinBox.getBalanceInPennies());
	}

	@Test
	public void reutrn_correct_purchase_price() {
		Assert.assertEquals(180, vendingMachineInventory.vendingMachineStock().get("B1").getPriceAsIntInPennies());
	}

	@Test
	public void reutrn_correct_balance_in_pennies() {
		vendingMachineCoinBox.addMoney(2);
		Assert.assertEquals(200, vendingMachineCoinBox.getBalanceInPennies());
	}

//WHY CANT WE DO THIS? vendingMachineCoinBox.addMoney(2) 	
	@Test
	public void successful_purchase() {
		vendingMachineTest.feedMoney(2);
		vendingMachineInventory.vendingMachineStock().get("B1").getPriceAsIntInPennies();
		Assert.assertEquals("Thank You For Purchasing Moonpie", vendingMachineTest.purchaseItem("B1"));

	}

//WHY CANT WE DO THIS? vendingMachineCoinBox.addMoney(2) 
	@Test
	public void purchase_item_greater_than_current_balance() {
		vendingMachineTest.feedMoney(1);
		Assert.assertEquals("Please Insert Additional Funds", vendingMachineTest.purchaseItem("B1"));
	}

	@Test
	public void item_debits_correct_amount() {
		vendingMachineTest.feedMoney(2);
		vendingMachineTest.subtractMoney("B2");
		Assert.assertEquals(50, vendingMachineTest.getBalanceInPennies());
	}

	@Test
	public void inventory_is_reduced() {
		vendingMachineTest.subtractFromInventory("B1");
		Assert.assertEquals(4, vendingMachineInventory.returnCurrentInventory("B1"));
	}

	@Test
	public void inventory_is_reduced_other_way() {
		vendingMachineInventory.subtractFromInventory("B1");
		Assert.assertEquals(4, vendingMachineInventory.returnCurrentInventory("B1"));
	}

//		@Test
//		public void return_fifteen_cents_as_coins() {
//			// Arrange
//			// Act 
//			vendingMachineTest.feedMoney(1);
//			vendingMachineTest.subtractMoney("D1");
//			// Assert
//			Assert.assertEquals("Your change is 0 quarters, 1 dimes, and 1 nickels.", vendingMachineTest.returnChangeInCoins());
//		}

	@Test
	public void current_balance_to_string() {
		vendingMachineTest.feedMoney(5);
		vendingMachineTest.subtractMoney("B2");
		Assert.assertEquals("$3.50", vendingMachineTest.getBalanceAsString());
	}

	@Test
	public void item_out_of_stock() {
		vendingMachineTest.feedMoney(100);
		vendingMachineTest.purchaseItem("A1");
		vendingMachineTest.purchaseItem("A1");
		vendingMachineTest.purchaseItem("A1");
		vendingMachineTest.purchaseItem("A1");
		vendingMachineTest.purchaseItem("A1");
		vendingMachineTest.purchaseItem("A1");
		Assert.assertEquals("Sold Out", vendingMachineTest.purchaseItem("A1"));

	}

//		@Test
//		public void get_inventory() {
//			// Arrange
//			// Act 
//			vendingMachineTest.feedMoney(5); 
//			vendingMachineTest.subtractMoney("B2");
//			// Assert  
//			Assert.assertEquals("$3.50", Arrays.toString(vendingMachineTest.getInventory().toArray()));
//		}

}
