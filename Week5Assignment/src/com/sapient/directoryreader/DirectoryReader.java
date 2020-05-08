package com.sapient.directoryreader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class DirectoryReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path currentDirectory = Paths.get(".");
		Predicate<? super Path> predicate = path -> String.valueOf(path).contains(".java");
		Files.walk(currentDirectory, 5).filter(predicate).forEach(System.out::println);
	}

}
