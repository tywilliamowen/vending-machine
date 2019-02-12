package com.techelevator.view;

public class Candy extends Item {

	public Candy(String name, String price) {
		super(name, price);
	}

	@Override
	public String getSound() {
		String returnString = "\"Munch Munch, Yum!\"";
		return returnString;
	}

}
