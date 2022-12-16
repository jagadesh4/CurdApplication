package com.nucleus.SpringImplAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OnePlus {
	@Autowired
	@Qualifier("snapDragon")
	MobileProcressor processor;
	
	
	public MobileProcressor getProcessor() {
		return processor;
	}
	
	public void setProcessor(MobileProcressor processor) {
		this.processor = processor;
	}
	
	public void config() 
	{
		System.out.println("congiguration Details");
		processor.procress();
	}

}
