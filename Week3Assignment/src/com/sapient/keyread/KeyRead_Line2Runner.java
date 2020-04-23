package com.sapient.keyread;

public class KeyRead_Line2Runner {

	public static void main(String[] args) {
		KeyRead_Line2 keyRead = new KeyRead_Line2();
		keyRead.read();
		System.out.print("Numbers: ");
		keyRead.display();

		keyRead.sort();
		System.out.print("After sorting: ");
		keyRead.display();

		int element = 5;
		keyRead.find(element);


	}

}
