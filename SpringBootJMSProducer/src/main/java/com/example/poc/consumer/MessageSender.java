package com.example.poc.consumer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender{// implements CommandLineRunner {
	
	@Autowired
	private JmsTemplate jt;
	@Value("${my.mq.desti-name}")
	private String destinationName;
//	@Override
//	public void run(String... args) throws Exception {
//		jt.send(destinationName,
//				(session)-> session.createTextMessage("Hello I am Bhaskar From producer :"+new Date())
//		);
//	}
	@Scheduled(cron = "* */2 * * * *")
	public void send() {
		jt.send(destinationName, 
				(session)->session.createTextMessage("Hello I am Bhaskar From producer second time calling :"+new Date()));
	}
}
