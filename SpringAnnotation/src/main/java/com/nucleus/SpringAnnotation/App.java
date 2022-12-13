package com.nucleus.SpringAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nucleus.SpringAnnotation.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//getBeen() method is implementing two  been factory and application context
    	//For xml files no need to recompile all the file configure the class name and save the xml
    	ApplicationContext objcontext = new ClassPathXmlApplicationContext("dependency.xml");
    	
//Bean name should be exact class name with all small letters	
    	
		/* Tyre objtyre = (Tyre)objcontext.getBean("tyre"); */
    	
		  Vehicle objbike = (Bike)objcontext.getBean("bike");
		  
		  objbike.drive();
		  
		  Vehicle objcar = (Car)objcontext.getBean("car");
		  
		  objcar.drive();
		 
		
		  
		 
    	
    }
}
