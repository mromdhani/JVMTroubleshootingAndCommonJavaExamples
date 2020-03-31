package be.bt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {
	private final Logger logger = LoggerFactory.getLogger(MyKafkaConsumer.class);

	@KafkaListener(topics = "users_topic", groupId = "group_id")
	public void consume(String message) {
		logger.info(String.format("$$ -> Consumed Message -> %s", message));
	}
}