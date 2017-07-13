package com.capgemini.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import com.capgemini.conference.Person;

public class PersonTest {
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Test
	public void shouldGetAgeWhenGiveDate() {
		//given
		Person p = new Person("Artur", "Kowalski",LocalDate.parse("1993-10-20",dateTimeFormatter));
		//when
		p.calculateAge();
		//then
		assertEquals(23, p.getAge());
	}
}
