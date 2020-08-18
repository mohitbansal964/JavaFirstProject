package com.sapient.week8.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberTest {
	private Number num;

	@BeforeEach
	void setUp() {
		num = new Number();
	}

	@Test
	void checkPrimeNumberTwo() {
		boolean result = num.checkPrime(2);
		assertEquals(true, result);
	}

	@Test
	void checkPrimeNumber() {
		boolean result = num.checkPrime(11);
		assertEquals(true, result);
	}

	@Test
	void checkCompositeNumber() {
		boolean result = num.checkPrime(4);
		assertEquals(false, result);
	}

	@Test
	void checkPrimeResultForOne() {
		boolean result = num.checkPrime(1);
		assertEquals(false, result);
	}

	@Test
	void checkArmstrongNumber() {
		boolean result = num.checkArmstrong(153);
		assertEquals(true, result);
	}

	@Test
	void checkNotArmstrongNumber() {
		boolean result = num.checkArmstrong(163);
		assertEquals(false, result);
	}

	@Test
	void checkPalindromeNumber() {
		boolean result = num.checkPalindrome(2552);
		assertEquals(true, result);
	}

	@Test
	void checkNotPalindromeNumber() {
		boolean result = num.checkPalindrome(12552);
		assertEquals(false, result);
	}
}
