package org.svenehrke.checkout.java8.chainedlambda;

import java.util.function.Function;

public class C0 {

	public final String name;
	public final int age;

	public C0(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public static Function<String, Function<Integer, C0>> make() {
		return new Function<String, Function<Integer, C0>>() {

			@Override
			public Function<Integer, C0> apply(String name) {
				return new Function<Integer, C0>() {
					@Override
					public C0 apply(Integer age) {
						return new C0(name, age);
					}
				};
			}
		};
	}

	public interface B1 extends Function<String, Function<Integer, C0>> {
		default Function<Integer, C0> name(String name) {
			return apply(name);
		}
	}

}
