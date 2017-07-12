package com.capgemini.conference;

import java.util.LinkedList;
import java.util.List;

public class SortByLetterService implements SortService {

	private List<Person> subListOfPersons;
	
	@Override
	public List<Person> sort(String input, List<Person> persons) {
		createSubListOfPersons(input, persons);
		return subListOfPersons;
	}
	
	@Override
	public void saveFile(String input, List<Person> sortedPersons) {
		SaveFileService saveFileService = new SaveFileService();
		String fileName = "uczestnicy_"+input+".csv";
		saveFileService.saveFile(sortedPersons, fileName);
		System.out.println("Zapisano!\n" + sortedPersons.toString());
	}

	private void createSubListOfPersons(String input, List<Person> persons) {
		this.subListOfPersons = new LinkedList<>();
		addPersonsWithSurnameStartetWithChar(input, persons);
		selectionSortAlgorithm();
	}

	private void selectionSortAlgorithm() {
		int size = subListOfPersons.size();
		List<Person> tempList = new LinkedList<>();
		tempList.addAll(subListOfPersons);
		subListOfPersons.clear();
		sortIterations(size, tempList);
	}

	private void sortIterations(int size, List<Person> tempList) {
		for(int sizeIterator=0; sizeIterator< size; sizeIterator++){
			int currentMinimum = 0;
			for(int tempSizeIterator=0;tempSizeIterator<tempList.size();tempSizeIterator++){
				if(tempList.get(tempSizeIterator).getName()
						.compareTo(tempList.get(currentMinimum).getName())<0){
					currentMinimum=tempSizeIterator;
				}
			}
			subListOfPersons.add(tempList.remove(currentMinimum));
		}
	}

	private void addPersonsWithSurnameStartetWithChar(String input, List<Person> persons) {
		for(Person p : persons){
			if (p.getSurname().charAt(0) == input.toLowerCase().charAt(0)
					|| p.getSurname().charAt(0) ==  input.toUpperCase().charAt(0)) {
				subListOfPersons.add(p);
			}
		}
	}
}
