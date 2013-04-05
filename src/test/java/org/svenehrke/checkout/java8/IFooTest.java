package org.svenehrke.checkout.java8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IFooTest {

	@Test
	public void staticRoutineInInterface() throws Exception {
		IFoo foo = IFoo.newDefaultFoo();
		assertEquals("default foo", foo.someMessage());
	}
}
