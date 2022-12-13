package com.nucleus.SpringAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Component name by default will be bike
@Component
public class Bike implements Vehicle{
	/* @Autowired */
	private Tyre tyre;
	 public Bike(Tyre tr)
	 {
		this.tyre =tr; 
	 }

	/**
	 * @return the tyre
	 */
	public Tyre getTyre() {
		return tyre;
	}

	/**
	 * @param tyre the tyre to set
	 */
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	public void drive() {
		// TODO Auto-generated method stub
		tyre.setBrand("CEAT");
		System.out.println("Drive Bike with "+tyre.getBrand() );
		
	}
}
