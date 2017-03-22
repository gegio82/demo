package uk.co.valma.service;

import uk.co.valma.exception.InvalidRangeException;

public interface PrimeCalculator {
	int[] compute(int limit) throws InvalidRangeException;
}
