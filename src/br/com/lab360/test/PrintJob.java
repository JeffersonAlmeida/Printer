package br.com.lab360.test;

public class PrintJob {

	private String jobName;
	private int numberOfPages;
	
	public PrintJob(String jobName, int numberOfPages) {
		super();
		this.jobName = jobName;
		this.numberOfPages = numberOfPages;
	}
	
	@Override
	public String toString() {
		return " document: " + jobName + " - pages: " + numberOfPages + "";
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
}
