package org.svenehrke.checkout.java8.chainedlambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class C3Test {

	private Date dateOfBirth;

	@Before
	public void init() throws Exception {
		dateOfBirth = new Date();
	}

	@Test
	public void make() throws Exception {
		C3 c = C3.name("sven").age(3).dateOfBirth(dateOfBirth).build();
		assertEquals("sven", c.name);
		assertEquals(3, c.age);
		assertSame(dateOfBirth, c.dateOfBirth);
		assertNull(c.secondName);
		assertNull(c.thirdName);

	}

	@Test
	public void make2() throws Exception {
		C3 c = C3.name("sven").age(3).dateOfBirth(dateOfBirth).secondName("sven 2").build();
		assertEquals("sven", c.name);
		assertEquals(3, c.age);
		assertSame(dateOfBirth, c.dateOfBirth);
		assertEquals("sven 2", c.secondName);
		assertNull(c.thirdName);

	}
	@Test
	public void make3() throws Exception {
		C3 c = C3.name("sven").age(3).dateOfBirth(dateOfBirth).secondName("sven 2").thirdName("sven 3").build();
		assertEquals("sven", c.name);
		assertEquals(3, c.age);
		assertSame(dateOfBirth, c.dateOfBirth);
		assertEquals("sven 2", c.secondName);
		assertEquals("sven 3", c.thirdName);

	}

}