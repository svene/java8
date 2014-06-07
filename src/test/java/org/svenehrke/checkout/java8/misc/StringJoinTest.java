package org.svenehrke.checkout.java8.misc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StringJoinTest {

	@Test
	public void test1() throws Exception {

		List<String> strings = Arrays.asList("one", "two", "three");

		assertEquals("one-two-three", strings.stream().collect(Collectors.joining("-")));

		assertEquals("one-two-three", String.join("-", strings));


	}
}
