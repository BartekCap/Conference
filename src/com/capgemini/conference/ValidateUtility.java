package com.capgemini.conference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtility {
	private static Pattern inputLetterPattern = Pattern.compile("[a-zA-Z]");
	private static Pattern inputNumberPattern = Pattern.compile("\\d+");
	private int personsCount;
	private Boolean isCorrect;
	
	public ValidateUtility(int personsCount) {
		this.personsCount = personsCount;
	}
	
	public ValidateUtility() {
	}
	
	public boolean isCorrect()
	{
		return isCorrect;
	}
	
	public boolean isCorrect(String input) {
		isCorrect=false;
		if(isLetter(input)||isNumberAndAbleToDivide(input))
		{
			isCorrect=true;
		}
		return isCorrect;
	}
	boolean isNumberAndAbleToDivide(String input) {
		Boolean isNumber=false;
		Matcher matcher = inputNumberPattern.matcher(input);
		if(matcher.matches()){
			if(checkDivisibility(input)){
				isNumber=true;
				}
			else{
				System.out.println("Liczba nie jest podzielna "
						+ "przez liczbę uczestników wynoszącą: "+personsCount);
			}
		}
		return isNumber;
	}
	
	boolean isLetter(String input) {
		Matcher matcher = inputLetterPattern.matcher(input);
		return matcher.matches();
	}

	private Boolean checkDivisibility(String input) {
		int devider = Integer.parseInt(input);
		Boolean isDivisibility=false;
		if((personsCount% devider)==0)
		{
			isDivisibility=true;
		}
		return isDivisibility;
	}
	
}
