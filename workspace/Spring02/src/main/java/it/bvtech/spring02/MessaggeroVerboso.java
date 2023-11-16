package it.bvtech.spring02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("verboso")
public class MessaggeroVerboso implements Messaggero {

	@Override
	public void stampareMessaggio(String messaggio) {
		System.out.println(messaggio + " bla bla bla.....");
		
	}
}
