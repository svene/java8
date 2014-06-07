package org.svenehrke.checkout.java8.misc;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Base64;

public class Base64Test {

	private static final Charset UTF_8 = Charset.forName("UTF-8");

	@Test
	public void test1() throws Exception {
		String input = "Hey Joe";
		byte[] encoded = Base64.getEncoder().encode(input.getBytes(UTF_8));

		Assert.assertEquals("SGV5IEpvZQ==", new String(encoded, UTF_8));

		byte[] decoded = Base64.getDecoder().decode(encoded);
		Assert.assertEquals(input, new String(decoded, UTF_8));

	}
}
