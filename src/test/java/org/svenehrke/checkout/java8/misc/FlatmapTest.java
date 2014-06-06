package org.svenehrke.checkout.java8.misc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class FlatmapTest {

	@Test
	public void test1() throws Exception {

		Stream<List<Integer>> integerListStream = Stream.of(
			Arrays.asList(1, 2),
			Arrays.asList(3, 4),
			Arrays.asList(5)
		);

		Stream<Integer> integerStream = integerListStream .flatMap((integerList) -> integerList.stream());
		List<Integer> actual = integerStream.collect(Collectors.toList());

		assertEquals(Arrays.asList(1, 2, 3, 4, 5), actual);


	}
}
