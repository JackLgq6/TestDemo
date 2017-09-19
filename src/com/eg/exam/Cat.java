package com.eg.exam;

public class Cat {
	
	private Cat() {
		
	}
	
	public static Cat getInstance() {
		return new Cat();
	}

}
