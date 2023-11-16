package it.bvtech.boot03.componenti;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClasseA {
	
	@Autowired
	Logger logger;
	
	void metodo() {
		logger.info("Messaggio di log");
	}

}
