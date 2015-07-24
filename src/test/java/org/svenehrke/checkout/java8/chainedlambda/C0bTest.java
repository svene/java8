package org.svenehrke.checkout.java8.chainedlambda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class C0bTest {

	@Test
	public void with_apply() throws Exception {
		C0b c = C0b.make().apply("sven").apply(3);
		assertEquals("sven", c.name);
		assertEquals(3, c.age);
	}

	@Test
	public void with_named_functions() throws Exception {
		C0b c = C0b.make().name("sven").age(3);
		assertEquals("sven", c.name);
		assertEquals(3, c.age);

	}

}