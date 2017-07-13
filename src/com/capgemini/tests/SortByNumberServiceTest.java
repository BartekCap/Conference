package com.capgemini.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.conference.Person;
import com.capgemini.conference.SortByNumberService;
import com.capgemini.conference.SortService;

public class SortByNumberServiceTest {

	private SortService sort;
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private List<Person> persons;
	
	@Before
	public void buider(){
		persons = new LinkedList<>();
		persons.add(new Person("A", "Z",LocalDate.parse("1993-10-20",dateTimeFormatter)));
		persons.add(new Person("B", "K",LocalDate.parse("1993-10-20",dateTimeFormatter)));
		persons.add(new Person("S", "N",LocalDate.parse("1993-10-20",dateTimeFormatter)));
		persons.add(new Person("V", "A",LocalDate.parse("1993-10-20",dateTimeFormatter)));
		persons.add(new Person("O", "M",LocalDate.parse("1993-10-20",dateTimeFormatter)));
		persons.add(new Person("I", "L",LocalDate.parse("1993-10-20",dateTimeFormatter)));
		sort = new SortByNumberService();
	}

	@Test
	public void shouldPersonWithSurnameStartedOnABeFirstOnChangedList() {
		//given
		List<Person> nonSortedPersons=new LinkedList<>();
		nonSortedPersons.addAll(persons);
		//when
		sort.sort("10", persons);
		//then
		assertEquals(nonSortedPersons.get(3), persons.get(0));
	}
	
	

}
