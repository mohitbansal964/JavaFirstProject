package com.sapient.figtowords;

public class figureToWords {
	private static String[] single_digits = new String[] { "zero", "one", "two", "three", "four", "five", "six",
			"seven", "eight", "nine" };

	private static String[] two_digits = new String[] { "", "ten", "eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

	private static String[] tens_multiple = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
			"seventy", "eighty", "ninety" };


	private static String figToWordsHelper(int num) {
		if (num < 10) {
			return single_digits[num];
		} else if (num < 20) {
			return two_digits[num - 9];
		} else if (num < 100) {
			int tensPlace = num / 10;
			String word = tens_multiple[tensPlace];
			int leftNum = num % (tensPlace * 10);
			if (leftNum == 0) {
				return word;
			}
			return word + " " + figToWordsHelper(leftNum);
		} else if (num < 1000) {
			int hundredsPlace = num / 100;
			String word = single_digits[hundredsPlace] + " hundred";
			int leftNum = num % (hundredsPlace * 100);
			if (leftNum == 0) {
				return word;
			}
			return word + " " + figToWordsHelper(leftNum);
		}
		return "";
	}

	public static String fig_to_words(long num) {

		if (num < 0) {
			return "Minus " + fig_to_words(-num);
		} else if (num < 10) {
			return single_digits[(int) num] + " only";
		} else if (num < 20) {
			return two_digits[(int) num - 9] + " only";
		} else if (num < 100) {
			int tensPlace = (int) num / 10;
			String word = tens_multiple[tensPlace];
			int leftNum = (int)num % (tensPlace * 10);
			if (leftNum == 0) {
				return word + " only";
			}
			return word + " " + fig_to_words(leftNum);
		} else if (num < 1000) {
			int hundredsPlace = (int) num / 100;
			String word = single_digits[hundredsPlace] + " hundred";
			int leftNum = (int) num % (hundredsPlace * 100);
			if (leftNum == 0) {
				return word + " only";
			}
			return word + " " + fig_to_words(leftNum);
		} else if (num < 1e6) {
			int thousandsPlace = (int) num / 1000;
			String word = figToWordsHelper(thousandsPlace) + " thousand";
			int leftNum = (int) num % (thousandsPlace * 1000);
			if (leftNum == 0) {
				return word + " only";
			}
			return word + " " + fig_to_words(leftNum);
		} else if (num < 1e9) {
			int millions = (int) (num / (long) 1e6);
			String word = figToWordsHelper(millions) + " million";
			long leftNum = num % ((long) 1e6 * millions);
			if (leftNum == 0L) {
				return word + " only";
			}
			return word + " " + fig_to_words(leftNum);
		} else if (num < 1e12) {
			int billions = (int) (num / (long) 1e9);
			String word = figToWordsHelper(billions) + " billion";
			long leftNum = num % ((long) 1e9 * billions);
			if (leftNum == 0L) {
				return word + " only";
			}
			return word + " " + fig_to_words(leftNum);
		} else if (num < 1e15) {
			int trillions = (int) (num / (long) 1e12);
			String word = figToWordsHelper(trillions) + " trillion";
			long leftNum = num % ((long) 1e12 * trillions);
			if (leftNum == 0L) {
				return word + " only";
			}
			return word + " " + fig_to_words(leftNum);
		} else if (num < 1e18) {
			int quadrillions = (int) (num / (long) 1e15);
			String word = figToWordsHelper(quadrillions) + " quadrillion";
			long leftNum = num % ((long) 1e15 * quadrillions);
			if (leftNum == 0L) {
				return word + " only";
			}
			return word + " " + fig_to_words(leftNum);
		} else {
			int quintillions = (int) (num / (long) 1e18);
			String word = figToWordsHelper(quintillions) + " quintillion";
			long leftNum = num % ((long) 1e18 * quintillions);
			if (leftNum == 0L) {
				return word + " only";
			}
			return word + " " + fig_to_words(leftNum);
		}
	}

}
