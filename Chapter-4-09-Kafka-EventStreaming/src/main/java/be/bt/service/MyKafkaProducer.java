package be.bt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaProducer {
	private static final Logger logger = LoggerFactory.getLogger(MyKafkaProducer.class);
	private static final String TOPIC = "users_topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		logger.info(String.format("$$ -> Producing message --> %s", message));
		kafkaTemplate.send(TOPIC, message);
	}
}