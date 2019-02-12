package com.techelevator.view;
import org.junit.*;  


public class CoinBoxTest {

	private CoinBox coinBoxTest; 
	
	@Before
	public void setup() {
		coinBoxTest = new CoinBox(); 
	}
	
 	
	@Test
	public void correct_amount_deposited() {
		coinBoxTest.addMoney(1); 
		Assert.assertEquals(100, coinBoxTest.getBalanceInPennies());
	}
	
	@Test
	public void correct_amount_deposited_5() {
		coinBoxTest.addMoney(5); 
		Assert.assertEquals(500, coinBoxTest.getBalanceInPennies());
	}
	
	@Test
	public void correct_amount_withdraw() {
		coinBoxTest.addMoney(1); 
		coinBoxTest.withdrawMoney(25);
		Assert.assertEquals(75, coinBoxTest.getBalanceInPennies());
	}
	
	@Test
	public void balance_is_set_to_zero_by_default() {
		Assert.assertEquals(0, coinBoxTest.getBalanceInPennies());
	}
	
	@Test
	public void return_one_dollar_as_coins_zero_balance() {
		coinBoxTest.addMoney(1); 
		Assert.assertEquals("Your change is 4 quarters, 0 dimes, and 0 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
		Assert.assertEquals(0, coinBoxTest.getBalanceInPennies()); 
	}
	@Test
	public void return_one_dollar_as_coins() {
		coinBoxTest.addMoney(1); 
		Assert.assertEquals("Your change is 4 quarters, 0 dimes, and 0 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
	}
	
	
	
	@Test
	public void return_one_dollar_twenty_as_coins() {
		coinBoxTest.addMoney(2); 
		coinBoxTest.withdrawMoney(80);
		Assert.assertEquals("Your change is 4 quarters, 2 dimes, and 0 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
	}
	
	@Test
	public void return_one_thirty_five_as_coins() {
		coinBoxTest.addMoney(2); 
		coinBoxTest.withdrawMoney(65);
		Assert.assertEquals("Your change is 5 quarters, 1 dimes, and 0 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
	}

	@Test
	public void return_fifteen_cents_as_coins() {
		coinBoxTest.addMoney(1); 
		coinBoxTest.withdrawMoney(85);
		Assert.assertEquals("Your change is 0 quarters, 1 dimes, and 1 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
	}
	
	
	@Test
	public void current_balance_is_correct() {
		coinBoxTest.addMoney(1); 
		coinBoxTest.withdrawMoney(25);
		Assert.assertEquals(75, coinBoxTest.getBalanceInPennies());
	}
	
	@Test
	public void current_balance_to_string() {
		coinBoxTest.addMoney(2); 
		coinBoxTest.withdrawMoney(20);
		Assert.assertEquals("$1.80", coinBoxTest.getBalanceAsString());
	}
	
	@Test
	public void current_balance_to_string_two() {
		coinBoxTest.addMoney(1); 
		coinBoxTest.withdrawMoney(20);  
		Assert.assertEquals("$0.80", coinBoxTest.getBalanceAsString());
	}
	
	@Test
	public void current_balance_to_string_three() {
		coinBoxTest.addMoney(11); 
		coinBoxTest.withdrawMoney(20); 
		Assert.assertEquals("$10.80", coinBoxTest.getBalanceAsString());
	}
}