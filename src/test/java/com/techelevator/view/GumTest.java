package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

	private Gum gumTest; 
	
	@Before
	public void setup() {
		gumTest = new Gum("Little League Chew", "0.95"); 
	}
	
	
	@Test
	public void sound_return_test() {
		Assert.assertEquals( "\"Chew Chew, Yum!\"", gumTest.getSound()); 
	}
	
}


