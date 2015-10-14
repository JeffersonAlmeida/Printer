package br.com.lab360.test;

public interface Queue {

	public void add ( PrintJob printJob ) throws QueueException, InterruptedException;
	public PrintJob remove() throws InterruptedException;
	public boolean isEmpty();
	public int getNumberOfJobs();
	
}
