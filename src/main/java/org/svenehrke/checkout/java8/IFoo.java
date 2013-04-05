package org.svenehrke.checkout.java8;

public interface IFoo {
	public String someMessage();
	public static IFoo newDefaultFoo() {
		return new IFoo() {
			@Override
			public String someMessage() {
				return "default foo";
			}
		};
	}
}
