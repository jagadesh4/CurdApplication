package com.nucleus.SpringImplAnno;

import org.springframework.stereotype.Component;

@Component
public class SnapDragon implements MobileProcressor {

	public void procress() {
		System.out.println("World Best Procressor");

	}
}
