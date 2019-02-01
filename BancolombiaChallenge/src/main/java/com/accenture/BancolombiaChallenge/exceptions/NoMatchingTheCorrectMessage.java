package com.accenture.BancolombiaChallenge.exceptions;

public class NoMatchingTheCorrectMessage extends AssertionError{

	private static final long serialVersionUID = 1L;

	public NoMatchingTheCorrectMessage(String message, Throwable cause) {
		super(message, cause);
	}
	
	public static String getMissingMessage(String msg) {
		return String.format("The follow message's contains special characters: ", msg);
	}
}
