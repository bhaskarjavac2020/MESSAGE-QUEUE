package com.example.poc.producer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
@Component
public class MessageSender implements CommandLineRunner {

	@Autowired
	private JmsTemplate jt;
	@Value("${my.mq.desti-name}")
	private String destinationName;
	@Override
	public void run(String... args) throws Exception {
		jt.send(destinationName, 
				(session)->session.createTextMessage("Hello producer => "+new Date()));
	}
}
