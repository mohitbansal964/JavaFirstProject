package com.sapient.commandline;

import java.util.ArrayList;

public class Command_Line1Runner {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (String str : args) {
			arr.add(Integer.parseInt(str));
		}
		Command_Line1 cmd = new Command_Line1();
		cmd.setData(arr);
		cmd.calData();
		cmd.displayData();
	}

}
