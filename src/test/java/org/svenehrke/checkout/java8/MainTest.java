package org.svenehrke.checkout.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MainTest {

	@Test
	public void test1() throws Exception {
		final List<Integer> prices = Arrays.asList(10, 15, 20, 25, 30, 45, 50);

		assertEquals(Arrays.asList(20, 30, 40, 50, 60, 90, 100), prices.stream().map((Integer price) -> price * 2).collect(Collectors.toList()));
		long result = prices.stream().map((Integer price) -> price * 2).reduce(new IntegerBinaryOperator()).get();
		assertEquals(390L, result);

	}

	private static class IntegerBinaryOperator implements BinaryOperator<Integer> {

		@Override
		public Integer apply(Integer t, Integer u) {
			return t + u;
		}
	}
}
