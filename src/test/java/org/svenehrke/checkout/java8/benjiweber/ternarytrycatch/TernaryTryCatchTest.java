package org.svenehrke.checkout.java8.benjiweber.ternarytrycatch;

import org.junit.Test;

/**
 * see http://benjiweber.co.uk/blog/2009/06/14/java-abuse-ternary-trycatch/
 */
public class TernaryTryCatchTest {
	@Test
	public void test1() {
		final Customer c;

		try {
			c = getCustomer("1");
		} catch (NotFoundException e) {
			// c = newCustomer("1"); // NOTE: does not compile
		}


	}

	@Test
	public void test2() throws Exception {

		final Customer c = new TryCatch<Customer,NotFoundException>(supplier1, supplier2) {

			@Override
			public Customer Try() throws NotFoundException {
				return getCustomer("1");
			}

			@Override
			public Customer Catch() {
				return newCustomer("1");
			}
		}.value();

	}

	private static Customer getCustomer(String id) throws NotFoundException {
		throw new NotFoundException();
	}

	private static Customer newCustomer(String id) {
		return null;
	}


	static class NotFoundException extends Exception {

	}
}
