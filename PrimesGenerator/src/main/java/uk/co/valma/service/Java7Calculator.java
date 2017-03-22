package uk.co.valma.service;

import java.util.ArrayList;
import java.util.List;

import uk.co.valma.exception.InvalidRangeException;

public class Java7Calculator implements PrimeCalculator {

	public int[] compute(int limit) throws InvalidRangeException {
		if (limit < 0) {
			throw new InvalidRangeException();
		}
		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < limit; i++) {
			if (isPrime(i, primes)) {
				primes.add(i);
			}
		}
		int[] arr = new int[primes.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = primes.get(i);
		}
		return arr;
	}
	
	private boolean isPrime(int n, List<Integer> primes) {
		for (Integer prime : primes) {
			if (n % prime == 0) {
				return false;
			}
		}
		return true;
	}

}
