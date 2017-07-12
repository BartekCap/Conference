package com.capgemini.conference;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class PersonParser {

	private List<Person> persons;
	private List<String> listOfStrings;
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public PersonParser(String fileUrl) throws IOException, FileNotFoundException  {
		ReadFileService readFileService = new ReadFileService(fileUrl);
		this.listOfStrings = readFileService.getListOfStrings();
		createPersonsFromStrings();
	}

	private void createPersonsFromStrings() {
		this.persons = new LinkedList<>();
		for (int i = 0; i < listOfStrings.size(); i++) {
			listOfStrings.get(i).replace(" ", "");
			String[] stringArrayOfLine = listOfStrings.get(i).split(",");
			createSinglePerson(stringArrayOfLine);
		}
	}

	private void createSinglePerson(String[] stringArrayOfLine) {
		try {
			LocalDate birthDate = LocalDate.parse(stringArrayOfLine[2], dateTimeFormatter);
			checkBirthDate(stringArrayOfLine, birthDate);
		} catch (ArrayIndexOutOfBoundsException ex) {
			OutputUtility.printProblemWithCreatingPerson(persons.size() + 1);
		}
	}

	private void checkBirthDate(String[] stringArrayOfLine, LocalDate birthDate) {
		if (birthDate != null) {
			Person p = new Person(stringArrayOfLine[0], stringArrayOfLine[1], birthDate);
			persons.add(p);
		}
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}