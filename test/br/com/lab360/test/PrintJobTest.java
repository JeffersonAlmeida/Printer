package br.com.lab360.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PrintJobTest {

	@Test
	public void test() {
		PrintJob printJob = new PrintJob("math.txt", 3);
		assertNotNull(printJob);
		assertEquals("math.txt", printJob.getJobName());
		assertEquals(3, printJob.getNumberOfPages());
		assertEquals(" document: math.txt - pages: 3", printJob.toString());
	}

}
