package br.com.lab360.test;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable{

	private static final int TOTAL = 5;

	private static final int MIN_PAGES_NUMBER = 1;
	private static final int MAX_PAGES_NUMBER = 15;
	
	private static final int MIN_SLEEP_INTERVAL = 1;
	private static final int MAX_SLEEP_INTERVAL = 5;

	private String name;
	private Queue queue;

	public Producer(String name, Queue queue) {
		super();
		this.name = name;
		this.queue = queue;
	}

	public String getName() {
		return name;
	}
	
	public void run(){
		int i = 0;
		try {
			while ( i < TOTAL ){	
				String name = new StringBuilder
						(String.valueOf(++i)).append(".doc").toString();
				PrintJob job = new PrintJob(name, randomPagesNumber());
				notifyUserJobSent( job );
				synchronized ( queue ) {
					this.queue.add(job);	
				}
				Thread.sleep(getSleepInterval());
			}
			this.queue.add(null);
		} catch (QueueException e) {
			System.out.println("Handle: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("Handle: " + e.getMessage());
		}
	}

	private void notifyUserJobSent(PrintJob job) {
		System.out.println("[ " + getName() + " ] " + job + "\n");
	}

	private int getSleepInterval() {
		int value = ThreadLocalRandom.current().
				nextInt(MIN_SLEEP_INTERVAL, MAX_SLEEP_INTERVAL + 1);
		return value * 1000;
	}

	private int randomPagesNumber(){
		return ThreadLocalRandom.current().
				nextInt(MIN_PAGES_NUMBER, MAX_PAGES_NUMBER + 1);
	}

}
