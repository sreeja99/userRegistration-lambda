package com.userregistration.lambda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class UserValidatorTest {

	@Test
	public void allDetailsAreCorrect() { 
		boolean isValid;                                                                                      //checking whether all details are correct
		try {
			isValid = UserValidator.validate("Sreeja","Godishala","91 1234567890","abc@bl.co","jsfsY3#");
			Assert.assertEquals(true,isValid);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void firstNameIsWrong() {
		try {                                                                                                //method for first name is wrong
			UserValidator.validate("sreeja","Godishala","91 1234567890","abc@bl.co","jsfsY3#");
		} catch (InvalidException e) {
			assertEquals(InvalidException.ExceptionType.INVALID_FIRST_NAME, e.type);
		}
	}
	@Test
	public void lastNameIsWrong() {
		try {                                                                                                 //method for last name is wrong
			UserValidator.validate("Sreeja","godishala","91 1234567890","abc@bl.co","jsfsY3#");
		} catch (InvalidException e) {
			assertEquals(InvalidException.ExceptionType.INVALID_LAST_NAME, e.type);
		}
	}
	@Test
	public void mobileIsWrong() {
		try {                                                                                                   //method for  only mail is wrong
			UserValidator.validate("sreeja","Godishala","911234567890","abc@bl.co","jsfsY3#");
		} catch (InvalidException e) {
			assertEquals(InvalidException.ExceptionType.INVALID_MOBILE, e.type);
		}
	}
	@Test
	public void emailIsWrong() {
		try {                                                                                                    //method for only email is wrong
			UserValidator.validate("Sreeja","Godishala","91 1234567890","ab@bl.co","jsfsY3#");
		} catch (InvalidException e) {
			assertEquals(InvalidException.ExceptionType.INVALID_EMAIL, e.type);
		}
	}
	@Test
	public void passwordIsWrong() {
		try {                                                                                                    //method for only password is wrong
			UserValidator.validate("Sreeja","Godishala","91 1234567890","abc@bl.co","jsfsY#");
		} catch (InvalidException e) {
			assertEquals(InvalidException.ExceptionType.INVALID_PASSWORD, e.type);
		}
	}
	

}
