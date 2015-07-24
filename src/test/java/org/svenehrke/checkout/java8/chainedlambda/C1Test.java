package org.svenehrke.checkout.java8.chainedlambda;

import org.junit.Test;

import static org.junit.Assert.*;

public class C1Test {


	@Test
	public void make() throws Exception {
		C1 c = C1.make().apply("sven").apply(3);
		assertEquals("sven", c.name);
		assertEquals(3, c.age);

	}

}