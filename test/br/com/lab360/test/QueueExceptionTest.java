package br.com.lab360.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class QueueExceptionTest {

	@Test
	public void test() {
		QueueException exception = new QueueException();
		assertNotNull(exception);
		assertEquals("No Free Space Exception", exception.getMessage());
	}
}
