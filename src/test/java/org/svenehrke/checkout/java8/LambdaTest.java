package org.svenehrke.checkout.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

// See Venkat Subramaniam's Java8 book
public class LambdaTest {
	@Test
	public void test_string() throws Exception {
		String str = "w00t";
		str.chars().forEach(ch -> System.out.println((char)ch));
//		str.chars().forEach(System.out::println);
		str.chars()
		.map(c -> Character.valueOf((char) c))
		.forEach(System.out::println);

		char cc = 's';
		System.out.println(cc);
	}

	@Test
	public void test_2() throws Exception {
		List<Person> persons = Arrays.asList(new Person("Sven"), new Person("Uli"));

		List<String> expected = Arrays.asList("Sven", "Uli");
		assertEquals(expected,
			persons.stream()
				.map(p -> p.name)
				.collect(Collectors.toList()
				)
		);
/*
		assertEquals(expected,
			persons.stream()
				.map(Person.name)
				.collect(Collectors.toList()
				)
		);
*/

	}

	private static class Person {
		final String name;

		private Person(final String name) {
			this.name = name;
		}
	}

	@Test
	public void discount() throws Exception {
		final List<Integer> prices = Arrays.asList(10, 15, 20, 25, 30, 45, 50);

		double actual = prices.stream().mapToDouble((Integer p) -> p * 0.9).reduce(0, (a, b) -> a + b);
		assertEquals(0, Double.compare(175.5, actual));
	}
}
