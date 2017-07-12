package com.capgemini.conference;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortByNumberService implements SortService {
	private int personsDevider;
	private int numberOfFiles;

	@Override
	public List<Person> sort(String input, List<Person> persons){
		persons.sort(Comparator.comparing(Person::getSurname));
		return persons;
	}
	
	@Override
	public void saveFile(String input, List<Person> persons) {
		setPersonsDevider(input);
		setNuberOfFiles(persons);
		SaveFileService saveFileService = new SaveFileService();
		saveFilesInIteration(persons, saveFileService);
	}

	private void setNuberOfFiles(List<Person> persons) {
		this.numberOfFiles = persons.size()/personsDevider;
	}
	
	private void setPersonsDevider(String input) {
		this.personsDevider = Integer.parseInt(input);
	}
	
	private void saveFilesInIteration(List<Person> persons, SaveFileService saveFileService) {
		List<Person> tempList = new LinkedList<>();
		for(int numberFileIterator=0; numberFileIterator<numberOfFiles; numberFileIterator++){
			tempList = persons.subList(numberFileIterator*personsDevider, (numberFileIterator+1)*personsDevider);
			String fileName = "uczestnicy_"+((numberFileIterator*personsDevider)+1)+"-"+((numberFileIterator+1)*personsDevider)+".csv";
			saveFileService.saveFile(tempList, fileName);
		}
		System.out.println("Zapisano do folderu "+numberOfFiles+" plików. W kazdym pliku znajduje się "+personsDevider+" osob.");
	}
}
