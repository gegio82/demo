package uk.co.valma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import uk.co.valma.exception.InvalidRangeException;

public class AdvancedPrimeCalculator implements PrimeCalculator {

	private boolean isPrime(List<Integer> primes, int number) {
		return primes.parallelStream().noneMatch(i -> number % i == 0);
	}
	
	public int[] compute(int limit) throws InvalidRangeException {
		if (limit < 0) {
			throw new InvalidRangeException();
		}
		return IntStream.rangeClosed(2, limit).boxed().
				collect(
					()->new ArrayList<Integer>(),
					(acc, candidate) -> {
							if (isPrime(acc, candidate)) {
								acc.add(candidate);
							}
						},
					(list1, list2) -> {list1.addAll(list2);}
				).stream().mapToInt(Integer::intValue).toArray();
	}
	
}


