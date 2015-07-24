package org.svenehrke.checkout.java8.chainedlambda;

import java.util.function.Function;

public class C1 {

	public final String name;
	public final int age;

	public C1(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	// like 'C0.make()' but with IntelliJ's 'replace with lambda' applied
	public static Function<String, Function<Integer, C1>> make() {
		return name1 -> age1 -> new C1(name1, age1);
	}

}
