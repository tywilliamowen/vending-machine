package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
	private Drink drinkTest;

	@Before
	public void setup() {
		drinkTest = new Drink("Mountain Melter", "1.50");
	}

	@Test
	public void sound_return_test() {
		Assert.assertEquals("\"Glug Glug, Yum!\"", drinkTest.getSound());
	}

}
