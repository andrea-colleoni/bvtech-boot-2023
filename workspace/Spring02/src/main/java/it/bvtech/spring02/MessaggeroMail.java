package it.bvtech.spring02;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MessaggeroMail implements Messaggero {

	@Override
	public void stampareMessaggio(String messaggio) {
		System.out.println(messaggio + " per email");

	}

}
