package com.sapient.commandline;

import java.util.ArrayList;
import java.util.Collections;

public class Command_Line1 {
	private ArrayList<Integer> arr;
	private int sum;
	private double avg;
	private int biggest, smallest;

	public void setData(ArrayList<Integer> arr) {
		this.arr = arr;
	}

	private void calSum() {
		sum = 0;
		for (Integer val : arr) {
			sum += val;
		}
	}

	public void calData() {
		calSum();
		int numberOfElements = arr.size();
		avg = (double) sum / numberOfElements;
		biggest = Collections.max(arr);
		smallest = Collections.min(arr);
	}

	public void displayData() {
		System.out.println("Data = " + arr.toString());
		System.out.println("Sum = " + sum);
		System.out.println("Average = " + avg);
		System.out.println("Biggest = " + biggest);
		System.out.println("Smallest = " + smallest);
	}

}
