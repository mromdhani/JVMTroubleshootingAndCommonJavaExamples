package be.bt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.bt.service.MyKafkaProducer;

@RestController
@RequestMapping(value = "/kafka")
public class ApacheKafkaRestAPI {

	@Autowired
	MyKafkaProducer kafkaSender;

	@GetMapping(value = "/publish")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.sendMessage(message);

		return "Message sent to the Kafka Topic users_topic Successfully";
	}

}

