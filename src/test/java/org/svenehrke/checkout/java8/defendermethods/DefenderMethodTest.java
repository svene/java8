package org.svenehrke.checkout.java8.defendermethods;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefenderMethodTest {
	@Test
	public void test1() throws Exception {
		ISimpleInterface simpleInterface = new StandardSimpleInterface();
		assertEquals("StandardSimpleInterface.doSomeWork", simpleInterface.doSomeWork());
		assertEquals("ISimpleInterface.doSomeOtherWork", simpleInterface.doSomeOtherWork());
	}
}
