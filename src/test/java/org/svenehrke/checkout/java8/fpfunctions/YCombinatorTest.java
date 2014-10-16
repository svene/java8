package org.svenehrke.checkout.java8.fpfunctions;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.*;

public class YCombinatorTest {

	@Test
	public void testYCombinator() throws Exception {

		Function<Integer,Long> fac = YCombinator.yCombinator((n,f) -> n == 0 ? 1L : n * f.apply(n-1));
		assertEquals((long)3628800, (long)fac.apply(10));

	}
}