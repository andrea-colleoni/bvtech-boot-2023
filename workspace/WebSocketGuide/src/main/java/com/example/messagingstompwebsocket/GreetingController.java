package com.example.messagingstompwebsocket;

import java.io.File;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import jakarta.mail.internet.MimeMessage;

@Controller
public class GreetingController {

	@Autowired
    private SimpMessagingTemplate template;
	
	@Autowired
	JavaMailSender emailSender;
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		// esempio di email
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("mail@...");
		msg.setSubject("Oggetto...");
		// ...
		emailSender.send(msg);
		
		// con allegati
		MimeMessage msgAttach = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msgAttach, true);
		
		helper.setFrom("mail@...");
		helper.addAttachment("file.pdf", new File("c:/file.pdf"));
		
		emailSender.send(msgAttach);
		
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
	
	//@Scheduled(fixedRate = 2000)
	@Scheduled(cron = "*/10 8-16 * * 1-5")
	public void random() throws Exception {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    template.convertAndSend("/topic/greetings", new Greeting("Hello, " + HtmlUtils.htmlEscape(generatedString) + "!"));
	    System.out.println(HtmlUtils.htmlEscape(generatedString));
	}

}
