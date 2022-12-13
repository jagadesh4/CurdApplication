package com.nucleus.SpringAnnotation;

import org.springframework.stereotype.Component;

/*@Component*/
public class Tyre {
	private String Brand;
	/*
	 * public Tyre(String brand) { super(); Brand = brand; }
	 */

	@Override
	public String toString() {
		return "it's Working";
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return Brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		Brand = brand;
	}

}
