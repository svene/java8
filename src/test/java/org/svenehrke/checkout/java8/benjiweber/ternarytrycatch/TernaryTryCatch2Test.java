package org.svenehrke.checkout.java8.benjiweber.ternarytrycatch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * see http://benjiweber.co.uk/blog/2009/06/14/java-abuse-ternary-trycatch/
 */
public class TernaryTryCatch2Test {

	@Test
	public void test2() throws Exception {

		Customer c = new TryCatch2<>(() -> getCustomer("1"), () -> newCustomer("5")).value();
		assertEquals("1", c.id);

		c = new TryCatch2<>(() -> getCustomer("2"), () -> newCustomer("5")).value();
		assertEquals("5", c.id);
	}

	private static Customer getCustomer(String id) throws NotFoundException {
		if ("1".equals(id)) {
			return new Customer("1");
		}
		else {
			throw new NotFoundException();
		}
	}

	private static Customer newCustomer(String id) {
		return null;
	}


	static class NotFoundException extends Exception {

	}
}
