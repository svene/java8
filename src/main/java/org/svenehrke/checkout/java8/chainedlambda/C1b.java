package org.svenehrke.checkout.java8.chainedlambda;

import java.util.function.Function;

public class C1b {

	public final String name;
	public final int age;

	public C1b(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public static Function<String, Function<Integer, C1b>> make() {
		return new TName();
	}

	private static class TAge implements Function<Integer, C1b> {
		private final String name;

		public TAge(String name) {
			this.name = name;
		}

		@Override
		public C1b apply(Integer age) {
			return new C1b(name, age);
		}
	}

	private static class TName implements Function<String, Function<Integer, C1b>> {

		@Override
		public Function<Integer, C1b> apply(String name) {
			return new TAge(name);
		}
	}
}
