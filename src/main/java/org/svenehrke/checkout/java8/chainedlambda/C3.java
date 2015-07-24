package org.svenehrke.checkout.java8.chainedlambda;

import java.util.Date;

public class C3 {

	public final String name;
	public final int age;
	public final Date dateOfBirth;
	public final String secondName; // optional
	public final String thirdName; // optional

	public C3(String name, Integer age, Date dateOfBirth, String secondName, String thirdName) {
		this.name = name;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.secondName = secondName;
		this.thirdName = thirdName;
	}

	public static R2 name(String name) {
		return age -> dateOfBirth -> OptionBuilder.make(name, age, dateOfBirth, null, null);
	}

	public interface R2 {
		R3 age(int age);
	}
	public interface R3 {
		OptionBuilder dateOfBirth(Date dateOfBirth);
	}

	public static class OptionBuilder {
		private final C3 acc;

		public OptionBuilder(C3 acc) {
			this.acc = acc;
		}

		public OptionBuilder secondName(String secondName) {
			return make(acc.name, acc.age, acc.dateOfBirth, secondName, acc.thirdName);
		}
		public OptionBuilder thirdName(String thirdName) {
			return make(acc.name, acc.age, acc.dateOfBirth, acc.secondName, thirdName);
		}

		public C3 build() {
			return new C3(acc.name, acc.age, acc.dateOfBirth, acc.secondName, acc.thirdName);
		}

		private static OptionBuilder make(String name, int age, Date dateOfBirth, String secondName, String thirdName) {
			return new OptionBuilder(new C3(name, age, dateOfBirth, secondName, thirdName));
		}
	}
}
