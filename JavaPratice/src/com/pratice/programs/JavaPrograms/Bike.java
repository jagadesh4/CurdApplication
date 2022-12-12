package com.pratice.programs.JavaPrograms;

abstract public class Bike {
	abstract void run();
}

class PassionPro extends Bike {
	void run() {
		System.out.println("passion pro running successfully");
	}
}

class StartHiding {
	public static void main(String args[]) {
		/*
		 * Bike objbike = new PassionPro(); objbike.run();
		 */
		new PassionPro().run();
	}
}
