package com.sapient.intarrprocess;

import java.util.Arrays;
import java.util.Scanner;

public class IntArrProcess {
	private int[] arr;
	private int size;

	public IntArrProcess() {
		this.size = 5;
		this.arr = new int[this.size];
	}

	public IntArrProcess(int size) {
		this.size = size;
		this.arr = new int[size];
	}

	public IntArrProcess(int[] arr) {
		super();
		this.size = arr.length;
		this.arr = arr.clone();
	}

	public IntArrProcess(IntArrProcess that) {
		this.size = that.size;
		this.arr = that.arr.clone();
	}

	public void readArr() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter numbers:");
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
	}

	public void displayVertically() {
		System.out.println("Displaying numbers vertically:");
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
	}

	public void displayHorizontally() {
		System.out.println("Displaying numbers horizontally:");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void sortArray() {
		Arrays.sort(arr);
	}

	public int biggest() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	public int smallest() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

	public int sum() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public int secondBiggest() {
		int max = biggest();
		int secMax = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if (secMax < arr[i] && arr[i] != max) {
				secMax = arr[i];
			}
		}
		return secMax;
	}
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}
