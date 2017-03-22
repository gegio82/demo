package uk.co.valma.resources;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import uk.co.valma.exception.PrimeException;
import uk.co.valma.model.ErrorMessage;

@Provider
public class PrimeExceptionMapper implements ExceptionMapper<Throwable>{

	public Response toResponse(Throwable ex) {
		if (ex instanceof PrimeException) {
			return Response.status(((PrimeException)ex).getStatusCode())
					.entity(new ErrorMessage((PrimeException)ex)).build();
		} else {
			return Response.status(500)
					.entity(ex.getMessage()).build();
		}
	}
}
