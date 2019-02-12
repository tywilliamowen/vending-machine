package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest {
	private Logger loggerTest; 
	
	@Before
	public void setup() {
		loggerTest = new Logger(); 
	}
	
	
	@Test
	public void add_to_log() {
		loggerTest.addSoundToList("TEST");
		Assert.assertEquals( "[TEST]", loggerTest.returnListOfSounds()); 
	}

	
	
	@Test
	public void add_two_items_to_log() {
		loggerTest.addSoundToList("TEST");
		loggerTest.addSoundToList("Test Again");
		Assert.assertEquals( "[TEST, Test Again]", loggerTest.returnListOfSounds()); 
	}
	
	
	@Test
	public void log_cleared_after_return () {
		loggerTest.addSoundToList("TEST");
		loggerTest.addSoundToList("Test Again");
		loggerTest.returnListOfSounds(); 
		Assert.assertEquals( "[]", loggerTest.returnListOfSounds()); 
	}
	
	@Test
	public void display_date () {
		Assert.assertEquals( "[]", loggerTest.getCurrentTime()); 
	}
	
	@Test
	public void write_to_log() {
		Assert.assertEquals( "[]", loggerTest.logEvent("Event", "test", "test")); 
	}
	
}
