package uk.co.valma.exception;

public class InvalidRangeException extends PrimeException{

	private static final long serialVersionUID = 1481711814699677734L;

	@Override
	public int getStatusCode() {
		return 400;
	}
	
	@Override
	public String getMessage() {
		return "Invalid Range";
	}

}
