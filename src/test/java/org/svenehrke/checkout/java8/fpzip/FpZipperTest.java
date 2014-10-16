package org.svenehrke.checkout.java8.fpzip;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
// see http://dgronau.wordpress.com/2014/04/19/zipwith-in-java-8/
public class FpZipperTest {

	@Test
	public void test1() throws Exception {

		List<String> strings = Arrays.asList("a", "b", "c");
		List<Integer> ints = Arrays.asList(6,9,14,32);

		String result = "";

		for(String item : FpZipper.zip(strings, ints, (s, i) -> s + i)) {
			result += item;
		}

		assertEquals("a6b9c14", result);

	}
}