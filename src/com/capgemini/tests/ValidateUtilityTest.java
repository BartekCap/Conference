package com.capgemini.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.conference.ValidateUtility;

public class ValidateUtilityTest {

	@Test
	public void shouldReturnTrueWhenInputIsLetter() {
		//given
		String input = "a";
		ValidateUtility validateUtility =new ValidateUtility();
		//when
		boolean isCocrrect = validateUtility.isCorrect(input);
		//then
		assertEquals(true, isCocrrect);
	}

	@Test
	public void shouldReturnFalseWhenInputIsTextMoreThenLetter() {
		//given
		String input = "an";
		ValidateUtility validateUtility =new ValidateUtility();
		//when
		boolean isCocrrect = validateUtility.isCorrect(input);
		//then
		assertEquals(false, isCocrrect);
	}
	
	@Test
	public void shouldReturnFalseWhenInputIsAnotherSign() {
		//given
		String input = ".";
		ValidateUtility validateUtility =new ValidateUtility();
		//when
		boolean isCocrrect = validateUtility.isCorrect(input);
		//then
		assertEquals(false, isCocrrect);
	}
	
	@Test
	public void shouldReturnTrueWhenInputIsNumber() {
		//given
		String input = "213";
		ValidateUtility validateUtility =new ValidateUtility();
		//when
		boolean isCocrrect = validateUtility.isCorrect(input);
		//then
		assertEquals(true, isCocrrect);
	}
	
	@Test
	public void shouldReturnFalseWhenInputIsNegativeNumber() {
		//given
		String input = "-213";
		ValidateUtility validateUtility =new ValidateUtility();
		//when
		boolean isCocrrect = validateUtility.isCorrect(input);
		//then
		assertEquals(false, isCocrrect);
	}
	
	@Test
	public void shouldReturnFalseWhenInputIsZero() {
		//given
		String input = "0";
		ValidateUtility validateUtility =new ValidateUtility();
		//when
		boolean isCocrrect = validateUtility.isCorrect(input);
		//then
		assertEquals(false, isCocrrect);
	}
	
	@Test
	public void shouldReturnTrueWhenNumberIsDivisible() {
		//given
		String input = "30";
		ValidateUtility validateUtility =new ValidateUtility(300);
		//when
		boolean isDivisible = validateUtility.isNumberAndAbleToDivide(input);
		//then
		assertEquals(true, isDivisible);
	}
	
	@Test
	public void shouldReturnFalseWhenNumberIsNoDivisible() {
		//given
		String input = "21";
		ValidateUtility validateUtility =new ValidateUtility(300);
		//when
		boolean isDivisible = validateUtility.isNumberAndAbleToDivide(input);
		//then
		assertEquals(false, isDivisible);
	}
}
