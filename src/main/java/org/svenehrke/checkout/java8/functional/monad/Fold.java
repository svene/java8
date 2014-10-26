package org.svenehrke.checkout.java8.functional.monad;

public enum Fold {
	;

	public static <T> T fold(Semigroup<T> semigroup, T start, T... ts) {
		T result = start;
		for(T t : ts) {
			result = semigroup.o(result, t);
		}
		return result;
	}

	public static <T> T fold1(Monoid<T> monoid, T... ts) {
		return fold(monoid, monoid.empty(), ts);
	}

	public static <T> T fold(Semigroup<T> semigroup, T start, Iterable<T> ts) {
		T result = start;
		for(T t : ts) {
			result = semigroup.o(result, t);
		}
		return result;
	}

	public static <T> T fold1(Monoid<T> monoid, Iterable<T> ts) {
		return fold(monoid, monoid.empty(), ts);
	}
}
