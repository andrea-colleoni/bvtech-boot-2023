package it.bvtech.spring02;

import org.springframework.stereotype.Component;


public class MessaggeroSemplice implements Messaggero {

	@Override
	public void stampareMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

}
