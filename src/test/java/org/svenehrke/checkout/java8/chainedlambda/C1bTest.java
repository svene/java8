package org.svenehrke.checkout.java8.chainedlambda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class C1bTest {


	@Test
	public void make() throws Exception {
		C1b c = C1b.make().apply("sven").apply(3);
		assertEquals("sven", c.name);
		assertEquals(3, c.age);

	}

}