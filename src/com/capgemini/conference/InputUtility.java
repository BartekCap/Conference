package com.capgemini.conference;

import java.util.Scanner;

public class InputUtility {

	private Scanner scanner;
	
	public String getValidatedInput(int personsCount) {
		ValidateUtility validateUtility = new ValidateUtility(personsCount);
		String input;
		do{
			input = getInput();
			if(validateUtility.isCorrect(input)!=true){
				System.out.println("Wprowadzono złe dane\nWprowadź literę lub liczbę: ");
			}
		}while(validateUtility.isCorrect()!=true);
		return input;	
	}

	private String getInput() {
		String input;
		scanner = new Scanner(System.in);
		input = scanner.nextLine();
		return input;
	}
}
