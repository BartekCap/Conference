package com.capgemini.conference;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	private final static String SEPARATOR=",";
	private String name;
	private String surname;
	private LocalDate birthDate;
	private int age;

	public Person(String name, String surName, LocalDate birthDate) {
		super();
		this.name = name;
		this.surname = surName;
		this.birthDate = birthDate;
		calculateAge();
	}
	
	@Override
	public String toString() {
		return name+SEPARATOR+surname+SEPARATOR+age+"\n";
	}
	
	public void calculateAge() {
		this.age = Period.between(birthDate, LocalDate.now()).getYears();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
