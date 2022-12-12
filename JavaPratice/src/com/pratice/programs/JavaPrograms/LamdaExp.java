package com.pratice.programs.JavaPrograms;

@FunctionalInterface
interface A
{
	void show();
}

class B implements A
{
	public void show()
	{
		System.out.println("Print using class");
	}
}

//Next to work with lamda expressioin.

public class LamdaExp {
	
	public static void main(String args[])
	{
		//Approach using lamda
		/*
		 * A obj = ()->System.out.println("funcitonal interface"); obj.show();
		 */
		//GeneralApprach 
		/*
		 * A obj = new B(); obj.show();
		 */
		//Annonumans class
		
		A obj = ()->
				
					{
						System.out.println("annonumus class");
						
						System.out.println("object class");
					};
			obj.show();
	}

}
