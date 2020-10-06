package com.userregistration.lambda;

import java.util.Scanner;

import com.userregistration.lambda.InvalidException.ExceptionType;

public class UserValidator {
	//constants
	final static String NAME_PATTERN = "^[A-Z]{1}[a-zA-Z]{2,}$";
	final static String EMAIL_PATTERN = "^abc(.[a-z0-9]{0,})?@bl.co(.in)?$";
	final static String MOBILE_PATTERN = "^[0-9]{2}[\s][0-9]{10}$";
	final static String PASSWORD_PATTERN = "^((?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%]).{8,})$";
	public static boolean validate(String firstName,String lastName,String mobile,String email,String password) throws InvalidException {
        UserEntryValidator checkingFirstName = (enteredFirstName) -> (enteredFirstName.matches(NAME_PATTERN));
		UserEntryValidator checkingLastName = (enteredLastName) -> (enteredLastName.matches(NAME_PATTERN));
		UserEntryValidator checkingMobile = (enteredMobile) -> (enteredMobile.matches(MOBILE_PATTERN));
		UserEntryValidator checkingEmail = (enteredEmail) -> (enteredEmail.matches(EMAIL_PATTERN));
		UserEntryValidator checkingPassword = (enteredPassword) -> (enteredPassword.matches(PASSWORD_PATTERN));
		if(checkingFirstName.Validate(firstName))                                                              //checking first name
			System.out.println("Valid first name");
		else
			throw new InvalidException(ExceptionType.INVALID_FIRST_NAME, "enter valid first name");
		if(checkingLastName.Validate(lastName))
			System.out.println("Valid last name");                                                            //checking last name
		else
			throw new InvalidException(ExceptionType.INVALID_LAST_NAME, "enter valid last name");
		if(checkingMobile.Validate(mobile))                                                                    //checking mobile
			System.out.println("Valid mobile");
		else
			throw new InvalidException(ExceptionType.INVALID_MOBILE, "enter valid mobile");
		if(checkingEmail.Validate(email))                                                                       //checking email
			System.out.println("Valid email");
		else
			throw new InvalidException(ExceptionType.INVALID_EMAIL, "enter valid email");
		if(checkingPassword.Validate(password))                                                                 //checking password
			System.out.println("Valid Password");
		else
			throw new InvalidException(ExceptionType.INVALID_PASSWORD,"Please Enter Valid Password");
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//taking inputs
		System.out.println("Enter The First Name");
		String firstName = sc.nextLine();
		System.out.println("Enter The Last Name");
		String lastName = sc.nextLine();
		System.out.println("Enter The Mobile Format");
		String mobile = sc.nextLine();
		System.out.println("Enter The Email");
		String email = sc.nextLine();
		System.out.println("Enter The Password");
		String password = sc.nextLine();
		//checking whether input first name is valid
		try {
			if(validate(firstName,lastName,mobile,email,password)==true) {
				System.out.println("All Details Entered are correct");
			}
		} catch (InvalidException e) {
			e.printStackTrace();
		}
		
	
	}

}
