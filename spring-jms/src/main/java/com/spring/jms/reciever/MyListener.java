package com.spring.jms.reciever;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements MessageListener {

	@Override
	@JmsListener(destination = "${spring.jms.myQueue}")
	public void onMessage(Message message) {
		try {
			String body = message.getBody(String.class);
			System.out.println(body);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
//	@JmsListener(destination = "${spring.jms.myQueue}")
//	public void recieve(String message) {
//		System.out.println(message);
//	}
	
	
	
}
