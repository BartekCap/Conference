package com.capgemini.conference;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFileService {
	
	private List<String> listOfStrings;
	
	public ReadFileService(String fileUrl) throws IOException, FileNotFoundException  {
		readFile(fileUrl);
	}

	public void readFile(String fileUrl) throws IOException, FileNotFoundException {
		listOfStrings = new LinkedList<>();
		BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileUrl));
			listOfStrings = bufferedReader.lines().collect(Collectors.toList());
	}
	
	public List<String> getListOfStrings() {
		return listOfStrings;
	}

	public void setListOfStrings(List<String> listOfStrings) {
		this.listOfStrings = listOfStrings;
	}
}

