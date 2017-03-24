package uk.co.valma.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import uk.co.valma.exception.InvalidRangeException;

public class CachedPrimeCalculator implements PrimeCalculator {

	private int[] lastComputed = {};
	private int lastLimit = 1;
	private boolean isPrime(List<Integer> primes, int number) {
		return primes.parallelStream().noneMatch(i -> number % i == 0);
	}
	
	public int[] compute(int limit) throws InvalidRangeException {
		if (limit < 0) {
			throw new InvalidRangeException();
		}
		int[] result;
		if (limit < lastLimit) {
			result = Arrays.stream(lastComputed).filter(x -> x <= limit).toArray();
		} else {
			final List<Integer> init = Arrays.stream(lastComputed).boxed().collect(Collectors.toList());
			result = IntStream.rangeClosed(lastLimit + 1, limit).boxed().
				collect(
					()-> init,
					(acc, candidate) -> {
							if (isPrime(acc, candidate)) {
								acc.add(candidate);
							}
						},
					(list1, list2) -> {list1.addAll(list2);}
				).stream().mapToInt(Integer::intValue).toArray();
			lastLimit = limit;
			lastComputed = result;
		}
		return result;
	}
	
}


