package uk.co.valma.service;

import java.util.NavigableSet;
import java.util.TreeSet;

import org.apache.commons.lang3.ArrayUtils;

import uk.co.valma.exception.InvalidRangeException;

public class Java7Calculator2 implements PrimeCalculator {

	public int[] compute(int limit) throws InvalidRangeException {
		if (limit < 0) {
			throw new InvalidRangeException();
		}
		NavigableSet<Integer> primes = new TreeSet<>();
		for (int i = 2; i < limit; i++) {
			if (isPrime(i, primes)) {
				primes.add(i);
			}
		}
		return ArrayUtils.toPrimitive(primes.toArray(new Integer[primes.size()]));
		
	}
	
	private boolean isPrime(int n, NavigableSet<Integer> primes) {
		int root = (int)Math.sqrt((double)n);
		for (Integer prime : primes.headSet(root, true)) {
			if (n % prime == 0) {
				return false;
			}
		}
		return true;
	}

}
