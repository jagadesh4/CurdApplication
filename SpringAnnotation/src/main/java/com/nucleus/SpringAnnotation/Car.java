package com.nucleus.SpringAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
	/* @Autowired */
	private Tyre tyre;
	public Car(Tyre tr)
	{
		this.tyre = tr;
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
	public void drive()
	{
		tyre.setBrand("MRF");
		System.out.println("Drive Car with "+ tyre.getBrand());
	}

}
