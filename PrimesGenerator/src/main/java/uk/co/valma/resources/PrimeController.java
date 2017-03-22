package uk.co.valma.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import uk.co.valma.model.Result;
import uk.co.valma.service.PrimeCalculator;

@Component
@Path("/prime")
public class PrimeController {

	@Autowired
	@Qualifier("primeCalculator")
	private PrimeCalculator primeCalculator;

	@GET
	@Path("{initial}")
	public Response compute(@PathParam("initial") int initial) {
		if (initial < 0) {
			return Response.status(400).entity("Bad Request").build();
		} else {
			int[] primes = primeCalculator.compute(initial);
			Result result = new Result(initial, primes);
			return Response.status(200).entity(result).build();
		}
	}
}
