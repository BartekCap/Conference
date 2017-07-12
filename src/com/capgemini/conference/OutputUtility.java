package com.capgemini.conference;

public class OutputUtility {
	
	public static void printStatement(String statement){
		System.out.println(statement);
	}
	
	public static void printProblemWithCreatingPerson(int numberOfRowInFile){
		System.out.println("Przy osobie w wierszu nr: " + numberOfRowInFile + 1
				+ " brakuje imienia, nazwiska lub daty. Popraw dane tej osoby i uruchom"
				+ " program jeszcze raz lub kontynuuj pomijając tą osobę.\n");
	}
	
	public static void printStartingText(){
		System.out.println("Witamy w programie konferencja.\n"
				+ "Proszę wprowadzić literkę lub liczbę\n"
				+ "(literka - Zostaną zapisani tylko uczestnicy"
				+ " z nazwiskiem zaczynającym się na podaną literkę)\n"
				+ "(liczba - Uczestnicy zostaną podzieleni na gruby o "
				+ "licznosci podanej przez Ciebie i zapisani do plików): ");
	}
}
