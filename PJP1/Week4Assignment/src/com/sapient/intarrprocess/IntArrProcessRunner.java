package com.sapient.intarrprocess;

public class IntArrProcessRunner {

	public static void main(String[] args) {
		int[] arr = { 111, 12, 31, 26, 5 };
		IntArrProcess arrProcess = new IntArrProcess(arr);
		arrProcess.displayHorizontally();
		//		arrProcess.readArr();
		arrProcess.sortArray();
		System.out.println("After Sorting");
		arrProcess.displayHorizontally();
		System.out.println("Sum = " + arrProcess.sum());
		System.out.println("Biggest = " + arrProcess.biggest());
		System.out.println("Smallest = " + arrProcess.smallest());
		System.out.println("Second Biggest = " + arrProcess.secondBiggest());


		//		IntArrProcess arrProcess1 = new IntArrProcess(arrProcess);
		//		arrProcess1.displayHorizontally();
		//		arrProcess1.displayVertically();

	}

}
