package com.capgemini.conference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class SaveFileService {

	private PrintWriter printWriter;

	public void saveFile(List<Person> listOfPersons, String fileName) {
		try {
			printWriter = new PrintWriter(new File(fileName));
			for (Person p : listOfPersons) {
				printWriter.write(p.toString());
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Zapisywanie pliku nie powiodło się.");
		}
	}
}