package org.svenehrke.checkout.java8.fpfunctions;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;
// see http://dgronau.wordpress.com/2014/04/19/zipwith-in-java-8/
public class FpZipperTest {

	@Test
	public void testZipIterable() throws Exception {

		List<String> strings = Arrays.asList("a", "b", "c");
		List<Integer> ints = Arrays.asList(6,9,14,32);

		String result = "";

		for(String item : FpZipper.zipIterable(strings, ints, (s, i) -> s + i)) {
			result += item + "-";
		}

		assertEquals("a6-b9-c14-", result);

	}

	@Test
	public void testZip() throws Exception {

		Stream<String> strings = Arrays.asList("a", "b", "c").stream();
		Stream<Integer> ints = Arrays.asList(6,9,14,32).stream();

		String result = FpZipper.zip(strings, ints, (s, i) -> s + String.valueOf(i)).collect(joining("-"));

		assertEquals("a6-b9-c14", result);

	}
}