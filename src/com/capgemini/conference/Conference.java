package com.capgemini.conference;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Conference {

	private String input;
	private List<Person> persons;
	private List<Person> sortedPersons;
	private SortService sortService;

	public void runConference(String fileUrl) {
		try {
			getAllPersons(fileUrl);
			this.input = getInput();
			sortListAndSaveFile(input);
		} catch (FileNotFoundException e) {
			System.out.println("Błąd przy odczycie pliku");
		} catch (IOException e) {
			System.out.println("Nie znaleziono podanego pliku!");
		}
	}

	private void getAllPersons(String fileUrl) throws IOException, FileNotFoundException {
		GroupOfPersons groupOfPersons = new GroupOfPersons(fileUrl);
		this.persons = groupOfPersons.getPersons();
	}

	private void sortListAndSaveFile(String input) {
		chooseSortType(input);
		this.sortedPersons = sortService.sort(input, persons);
		sortService.saveFile(input, sortedPersons);
	}

	private void chooseSortType(String input) {
		ValidateUtility validateUtility = new ValidateUtility();
		if (validateUtility.isLetter(input)) {
			sortService = new SortByLetterService();
		} else {
			sortService = new SortByNumberService();
		}
	}

	private String getInput() {
		OutputUtility.printStartingText();
		InputUtility inputUtility = new InputUtility();
		String input = inputUtility.getValidatedInput(persons.size());
		return input;
	}

}
