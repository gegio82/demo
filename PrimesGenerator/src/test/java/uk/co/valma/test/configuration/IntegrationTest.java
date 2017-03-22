package uk.co.valma.test.configuration;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import uk.co.valma.model.Result;
import uk.co.valma.resources.PrimeController;

public class IntegrationTest extends JerseyTest {
	 
    @Override
    protected Application configure() {
        return new ResourceConfig(PrimeController.class, PrimeController.class);
    }
    
    @Test
    public void testJson() {
        final Response response = target("/prime/10").request().accept(MediaType.APPLICATION_JSON).get(Response.class);
        assertEquals(200, response.getStatus());
        assertEquals("{\"Initial\":10,\"Primes\":[2,3,5,7]}", response.readEntity(String.class));
    }
    @Test
    public void testXml() {
        final Response response = target("/prime/10").request().accept(MediaType.APPLICATION_XML).get(Response.class);
        assertEquals(200, response.getStatus());
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Result><Initial>10</Initial><Primes>2</Primes><Primes>3</Primes><Primes>5</Primes><Primes>7</Primes></Result>", 
        		response.readEntity(String.class));
    }
    @Test
    public void testJsonValues() {
        final Result result = target("/prime/10").request().accept(MediaType.APPLICATION_JSON).get(Result.class);
        int[] expected = {2,3,5,7};
		assertArrayEquals(expected, result.getPrimes());
		assertEquals(10, result.getInitial());
    }
    @Test
    public void testXmlValues() {
        final Result result = target("/prime/10").request().accept(MediaType.APPLICATION_XML).get(Result.class);
        int[] expected = {2,3,5,7};
		assertArrayEquals(expected, result.getPrimes());
		assertEquals(10, result.getInitial());
    }
    @Test
    public void testBadData() {
        final Response response = target("/prime/-10").request().accept(MediaType.APPLICATION_JSON).get();
        
        assertEquals(400, response.getStatus());
    }
}