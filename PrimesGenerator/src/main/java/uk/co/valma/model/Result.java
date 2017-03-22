package uk.co.valma.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Result")
public class Result {
	private int initial;
	private int[] primes;
	public Result() {
		super();
	}
	public Result(int initial, int[] primes) {
		super();
		this.initial = initial;
		this.primes = primes;
	}
	@XmlElement(name = "Initial")
	public int getInitial() {
		return initial;
	}
	public void setInitial(int initial) {
		this.initial = initial;
	}
	@XmlElement(name = "Primes")
	public int[] getPrimes() {
		return primes;
	}
	public void setPrimes(int[] primes) {
		this.primes = primes;
	}
	
	
}
