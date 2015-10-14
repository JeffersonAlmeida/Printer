package br.com.lab360.test;

public class PrinterApp {
	
	private static final int CAPACITY = 2;
	
	public static void main (String [] args) throws InterruptedException{
		
		CircularQueue circularQueue = new CircularQueue(CAPACITY);
		
		Producer producerA = new Producer("PRODUCER-A", circularQueue);
		Printer printer = new Printer("PRINTER", circularQueue);
		
		new Thread(producerA).start();
		new Thread(printer).start();
		
	}
}
