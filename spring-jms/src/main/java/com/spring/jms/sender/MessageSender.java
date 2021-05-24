package com.spring.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

	@Autowired
	JmsTemplate jmsTemplate;

	@Value("${spring.jms.myQueue}")
	private String queue;

	public void send(String message) {
		MessageCreator mc = s -> s.createTextMessage(message);

		jmsTemplate.send(queue, mc);

	}
}
