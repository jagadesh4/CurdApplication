package com.pratice.programs.java8fetures;

@FunctionalInterface
interface A
{
	void show(String text);
}

/*
 * class B implements A { public void show() {
 * System.out.println("Show:implementation"); } }
 */
public class LambdaDemo {
	public static void main(String args[])
	{
		A obj = i->System.out.println(i+"TestShow");
		obj.show("Jagadesh");
	}
}
