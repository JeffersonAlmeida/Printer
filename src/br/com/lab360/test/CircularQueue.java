package br.com.lab360.test;

import java.util.LinkedList;

public class CircularQueue implements Queue{

	private LinkedList<PrintJob> list = new LinkedList<PrintJob>();
	private int capacity;
	
	public CircularQueue(int capacity) {
		this.setCapacity(capacity);
	}
	
	public synchronized void add(PrintJob printJob) throws QueueException, InterruptedException {

		while ( getNumberOfJobs() == getCapacity() )
			wait();
		
		if( isEmpty() )
			notifyAll();

		list.addLast(printJob);
	}
	
	public synchronized PrintJob remove() throws InterruptedException {
		
		while( isEmpty() )
			wait();
		
		if( getNumberOfJobs() == getCapacity() )
			notifyAll();
		
		return list.poll();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getNumberOfJobs() {
		 return list.size();
	}

	public int getCapacity() {
		return capacity;
	}

	private void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
