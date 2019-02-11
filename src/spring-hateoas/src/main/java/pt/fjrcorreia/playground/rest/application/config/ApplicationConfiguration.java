package pt.fjrcorreia.playground.rest.application.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Francisco Correia
 */

@EnableAutoConfiguration
@ComponentScan(basePackages = "pt.fjrcorreia.playground.rest.application")
@Configuration
public class ApplicationConfiguration {
}
