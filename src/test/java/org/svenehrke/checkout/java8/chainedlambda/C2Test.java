package org.svenehrke.checkout.java8.chainedlambda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class C2Test {

	@Test
	public void make() throws Exception {
		C2 c = C2.make().name("sven").age(3);
		assertEquals("sven", c.name);
		assertEquals(3, c.age);

	}

}