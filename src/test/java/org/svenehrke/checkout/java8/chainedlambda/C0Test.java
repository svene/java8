package org.svenehrke.checkout.java8.chainedlambda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class C0Test {

	@Test
	public void test_make_0() throws Exception {
		C0 c = C0.make().apply("sven").apply(3);
		assertEquals("sven", c.name);
		assertEquals(3, c.age);

	}

}