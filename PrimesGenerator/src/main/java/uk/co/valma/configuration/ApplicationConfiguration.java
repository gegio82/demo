package uk.co.valma.configuration;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.valma.service.BasicPrimeCalculator;
import uk.co.valma.service.PrimeCalculator;


@Configuration
public class ApplicationConfiguration {
	
	@Bean
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	PrimeCalculator primeCalculator() {
		return new BasicPrimeCalculator();
	}
}