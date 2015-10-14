package br.com.lab360.test;

import java.util.concurrent.atomic.AtomicBoolean;


public class Printer implements Runnable {

	private static final long MILIS_PER_PAGE = 1000;
	private AtomicBoolean running;

	private String name;
	private Queue queue;

	public Printer(String name, Queue queue) {
		super();
		this.name = name;
		this.queue = queue;
		running = new AtomicBoolean(true);
	}

	public String getName() {
		return name;
	}

	public void halt() throws InterruptedException{
		running.set(false);
	}

	public void run() {
		try {
			PrintJob job;
			synchronized ( queue ) {
				while ( running.get() && (job = queue.remove()) != null ) {
					notifyUserPrintingJobStarted(job);
					Thread.sleep( getSleepTime(job.getNumberOfPages()) );
					notifyUserPrinterFinishedJob(job);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Handle: " + e.getMessage());
		}
	}

	private long getSleepTime(int numberOfPages) {
		return numberOfPages * MILIS_PER_PAGE;
	}

	private void notifyUserPrinterFinishedJob(PrintJob job) {
		System.out.println("[ " + getName() + " ] FINISH > " + job + "\n");
	}

	private void notifyUserPrintingJobStarted(PrintJob job) {
		System.out.println("[ " + getName() + " ] START > " + job + "\n");
	}
}
