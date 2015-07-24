package org.svenehrke.checkout.java8.chainedlambda;

public class C2 {

	public final String name;
	public final int age;

	public C2(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public static B1 make() {
		return name -> age -> new C2(name, age);
	}

	public interface B1 {
		B2 name(String name);
	}

	public interface B2 {
		C2 age(int age);
	}
}
