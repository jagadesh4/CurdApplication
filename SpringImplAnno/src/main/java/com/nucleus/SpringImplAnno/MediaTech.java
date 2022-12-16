package com.nucleus.SpringImplAnno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MediaTech implements MobileProcressor {

	public void procress() {
		System.out.println("2nd Best Procressor");
	}

}
