package com.disqo.notemanagement.exception;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
public class CustomNoteException extends RuntimeException{

	/**
	 *
	 */
	public CustomNoteException() {
		super();
	}

	/**
	 * @param message Exception message.
	 */
	public CustomNoteException(final String message) {
		super(message);
	}

	/**
	 *
	 * @param message  Exception message.
	 * @param throwable Thrown exception
	 */
	public CustomNoteException(final String message, final Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * @param throwable Thrown exception
	 */
	public CustomNoteException(final Throwable throwable) {
		super(throwable);
	}

}
