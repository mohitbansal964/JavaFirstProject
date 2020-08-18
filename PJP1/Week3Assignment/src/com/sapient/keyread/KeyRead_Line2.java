package com.sapient.keyread;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class AscendingOrderComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		return Integer.compare(num1, num2);
	}

}
public class KeyRead_Line2 {
	private ArrayList<Integer> arr = new ArrayList<>();

	public void read() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int n = scan.nextInt();
		System.out.println("Enter elements: ");
		for (int i = 0; i < n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
	}

	public void display() {
		System.out.println(arr);
	}

	public void sort() {
		arr.sort(new AscendingOrderComparator());
	}

	public void find(int element) {
		int idx = arr.indexOf(element) + 1;
		System.out.println("Element found at " + idx + " Position");
	}

}
