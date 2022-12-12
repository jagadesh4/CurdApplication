package com.pratice.programs.java8fetures;

public class Vehicle {
	public void run() {
		System.out.println("vehicle is running");
	}
	
	public void stop()
	{
		System.out.println("vehicle is stoped");
	}
}

class Car extends Vehicle
{
	public void run()
	{
		System.out.println("Car is running safely");
	}
	public void stop()
	{
		System.out.println("Car is stoped");
	}
}

class Lorry extends Vehicle
{
	public void run()
	{
		System.out.println("Bike is running safely");
	}
	public void stop()
	{
		System.out.println("Bike is stoped");
	}
}

class Execute
{
	public static void main(String []args)
	{
		Vehicle objCar = new Vehicle();
		objCar.run();
		objCar.stop();
	}
}

