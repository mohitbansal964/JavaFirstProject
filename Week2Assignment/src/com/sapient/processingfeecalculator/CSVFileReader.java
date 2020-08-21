package com.sapient.processingfeecalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader implements FileReader {

	@Override
	public ArrayList<String[]> read(String filename) {
		ArrayList<String[]> data = new ArrayList<String[]>();
		Scanner scan;
		try {
			scan = new Scanner(new File(filename));
			while (scan.hasNext()){
				String row = scan.nextLine();
				String [] values = row.split(",");
				data.add(values);
			}
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return data;
	}

}
