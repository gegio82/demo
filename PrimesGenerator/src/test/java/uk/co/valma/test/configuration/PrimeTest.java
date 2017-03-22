package uk.co.valma.test.configuration;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import uk.co.valma.exception.InvalidRangeException;
import uk.co.valma.service.PrimeCalculator;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class PrimeTest {

	@Autowired
	private PrimeCalculator primeCalculator;
	@Autowired
	private PrimeCalculator java7Calculator;
	@Autowired
	private PrimeCalculator advancedCalculator;
	@Test
	public void basicTest() {
		int[] primes = primeCalculator.compute(10);
		int[] expected = {2,3,5,7};
		assertArrayEquals(expected, primes);	
	}
	
	@Test(expected = InvalidRangeException.class) 
	public void testNegativeInput() {
		primeCalculator.compute(-10);
		assertTrue(false);
	}
	
	@Test
	public void zeroTest() {
		int[] primes = primeCalculator.compute(1);
		assertEquals(primes.length, 0);	
	}
	
	@Test
	public void firstPrimeTest() {
		int[] primes = primeCalculator.compute(2);
		int[] expected = {2};
		assertArrayEquals(expected, primes);	
	}
	
	@Test
	public void compareBigNumberTest() {
		int[] primes = primeCalculator.compute(100000);
		int[] others = java7Calculator.compute(100000);
		int[] advanced = advancedCalculator.compute(100000);
		assertArrayEquals(primes, others);	
		assertArrayEquals(primes, advanced);	
	}
	
}
