package com.pratice.programs.java8fetures;

import java.util.Arrays;
import java.util.List;

//By default interface decleration methods will be public abstract
//we can implement methods in interface with help of default keyword:Java8
interface MotarVehicles {
	void ride();

	void stop();
	default void rest() {
		System.out.println("Java8 feature");
	}
	static void display()
	{
		System.out.println("static:display");
	}
}

interface Spareparts
{
	default void rest() {
		System.out.println("Java8 feature2");
	}
}



class Auto implements MotarVehicles,Spareparts
{

	@Override
	public void ride() {
		// TODO Auto-generated method stub
		System.out.println("Auto:Ride");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Auto:Stop");
		
	}
	
  public void rest() 
  { 
	  System.out.println("Auto:Rest"); 
	  
  }
	 
	
}

class Bike implements MotarVehicles
{

	@Override
	public void ride() {
		// TODO Auto-generated method stub
		System.out.println("Bike:Ride");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Bike:Stop");
			}
	
}
class Itrate
{
	public List<Integer> testForEach()
	{
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		return values;
	}
	
}
public class Java8Features {
	
	public static void main(String args[])
	{
		MotarVehicles.display();
		MotarVehicles objautovehicle = new Auto();
		objautovehicle.stop();
		objautovehicle.rest();
		
		Itrate objitreate = new Itrate();
		List<Integer> lst =  objitreate.testForEach();
		//internal loop
		lst.forEach(System.out::println);//lambda expression.
	}
}
