package au.com.dius.pactworkshop.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		LoggerFactory.getLogger(ConsumerApplication.class).info("Consumer Started");
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
