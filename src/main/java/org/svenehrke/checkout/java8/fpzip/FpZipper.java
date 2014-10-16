package org.svenehrke.checkout.java8.fpzip;

import java.util.Iterator;
import java.util.function.BiFunction;

public class FpZipper {

	public static <A,B,C> Iterable<C> zip(Iterable<A> iterableA, Iterable<B> iterableB, BiFunction<A,B,C> fn) {
		return () -> new Iterator<C>() {
			private Iterator<A> itA = iterableA.iterator();
			private Iterator<B> itB = iterableB.iterator();

			public boolean hasNext() {
				return itA.hasNext() && itB.hasNext();
			}

			public C next() {
				return fn.apply(itA.next(), itB.next());
			}
		};
	}
}
