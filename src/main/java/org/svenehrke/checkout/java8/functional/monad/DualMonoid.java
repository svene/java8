package org.svenehrke.checkout.java8.functional.monad;

public enum DualMonoid {
	;

	public static <T> Monoid<T> dual(final Monoid<T> monoid) {
		return new Monoid<T>() {
			@Override
			public T empty() {
				return monoid.empty();
			}

			@Override
			public T o(T t1, T t2) {
				return monoid.o(t2, t1);
			}
		};
	}
	public static <T> Semigroup<T> dual(final Semigroup<T> semigroup) {
		return new Semigroup<T>() {
			@Override
			public T o(T t1, T t2) {
				return semigroup.o(t2,t1);
			}
		};
	}
}
