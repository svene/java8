package org.svenehrke.checkout.java8.datetime;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DateTimeTest {
	@Test
	public void testName() throws Exception {

		assertEquals("1970-01-01", LocalDate.ofEpochDay(0).toString());
		assertEquals("1997-05-19", LocalDate.ofEpochDay(10_000).toString());
		assertEquals("2024-10-04", LocalDate.ofEpochDay(20_000).toString());
		assertEquals("2052-02-20", LocalDate.ofEpochDay(30_000).toString());
		assertEquals("4434-02-12", LocalDate.ofEpochDay(900_000).toString());
		assertEquals("+2739877-01-02", LocalDate.ofEpochDay(999999999).toString());

//		localDate.toEpochDay();

	}

}
