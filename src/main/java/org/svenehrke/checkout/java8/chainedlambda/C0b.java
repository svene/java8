package org.svenehrke.checkout.java8.chainedlambda;

import java.util.function.Function;

public class C0b {

	public final String name;
	public final int age;

	public C0b(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public static B1 make() {
		return new B1() {

			@Override
			public B2 apply(String name) {
				return new B2() {
					@Override
					public C0b apply(Integer age) {
						return new C0b(name, age);
					}
				};
			}
		};
	}

	public interface B1 extends Function<String, B2> {
		default B2 name(String name) {
			return apply(name);
		}
	}
	public interface B2 extends Function<Integer, C0b> {
		default C0b age(Integer age) {
			return apply(age);
		}
	}

}
