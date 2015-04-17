package com.project.exceptions;

/**
 * Checked exception which should be thrown when business logic operation failed
 * @author grigoriy
 *
 */
public class OperationFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public OperationFailedException() {
		super();
	}

	public OperationFailedException(String message) {
		super(message);
	}
	
}
