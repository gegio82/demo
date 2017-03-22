package uk.co.valma.service;

import java.util.stream.IntStream;

import uk.co.valma.exception.InvalidRangeException;

public class BasicPrimeCalculator implements PrimeCalculator {

	private boolean isPrime(int number) {
		int root = (int)Math.sqrt((double)number);
		return IntStream.rangeClosed(2, root).noneMatch(i -> number % i == 0);
	}
	
	public int[] compute(int limit) throws InvalidRangeException {
		if (limit < 0) {
			throw new InvalidRangeException();
		}
		return IntStream.rangeClosed(2, limit).filter(candidate -> isPrime(candidate)).toArray();	
	}

}
