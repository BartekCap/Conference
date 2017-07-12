package com.capgemini.conference;

import java.util.List;

public interface SortService {
	
	public List<Person> sort(String input, List<Person> persons);
	public void saveFile(String input, List<Person> persons);
}
