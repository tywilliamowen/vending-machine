package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipTest {
	private Chip chipTest;

	@Before
	public void setup() {
		chipTest = new Chip("Grain Waves", "2.75");
	}

	@Test
	public void sound_return_test() {
		Assert.assertEquals("\"Crunch Crunch, Yum!\"", chipTest.getSound());
	}

	@Test
	public void get_price_in_pennies() {
		Assert.assertEquals(275, chipTest.getPriceAsIntInPennies());
	}

}
