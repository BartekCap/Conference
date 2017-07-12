package com.capgemini.conference;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class GroupOfPersons {
	
	private List<Person> persons;
	
	public GroupOfPersons(String fileUrl) throws IOException, FileNotFoundException  {
		this.persons = getPersonsUsingParser(fileUrl);
	}

	private List<Person> getPersonsUsingParser(String fileUrl) throws IOException, FileNotFoundException  {
		PersonParser personParser = new PersonParser(fileUrl);
		return personParser.getPersons();
	}

	public List<Person> getPersons() {
		return persons;
	}
}
