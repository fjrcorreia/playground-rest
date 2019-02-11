package pt.fjrcorreia.playground.rest.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.fjrcorreia.playground.rest.application.config.ApplicationConfiguration;

/**
 * @author Francisco Correia
 */
@SpringBootApplication
public class PlaygroundRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfiguration.class, args);
	}
}
