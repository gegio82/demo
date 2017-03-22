package uk.co.valma.test.configuration;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.valma.service.AdvancedPrimeCalculator;
import uk.co.valma.service.BasicPrimeCalculator;
import uk.co.valma.service.Java7Calculator;
import uk.co.valma.service.Java7Calculator2;
import uk.co.valma.service.PrimeCalculator;


@Configuration
public class TestConfiguration {
	
	@Bean
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	PrimeCalculator primeCalculator() {
		return new BasicPrimeCalculator();
	}	
	@Bean
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	PrimeCalculator advancedCalculator() {
		return new AdvancedPrimeCalculator();
	}
	@Bean
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	PrimeCalculator java7Calculator() {
		return new Java7Calculator2();
	}
}