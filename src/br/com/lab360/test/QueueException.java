package br.com.lab360.test;

public class QueueException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "No Free Space Exception";
	
	public QueueException() {
		super(MESSAGE);
	}
}
