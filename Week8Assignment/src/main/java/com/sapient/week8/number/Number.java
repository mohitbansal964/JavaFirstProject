package com.sapient.week8.number;

public class Number {

	public boolean checkPrime(int x) {
		if (x < 2) {
			return false;
		}
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public boolean checkArmstrong(int x) {
		int cubeSum = 0;
		int temp = x;
		while (temp != 0) {
			int digit = temp % 10;
			temp /= 10;
			cubeSum += digit * digit * digit;
		}
		if (cubeSum == x) {
			return true;
		}
		return false;
	}

	public boolean checkPalindrome(int x) {
		int reverseNumber = 0;
		int temp = x;
		while (temp != 0) {
			int digit = temp % 10;
			reverseNumber *= 10;
			reverseNumber += digit;
			temp /= 10;
		}

		if (reverseNumber == x) {
			return true;
		}
		return false;
	}

}
