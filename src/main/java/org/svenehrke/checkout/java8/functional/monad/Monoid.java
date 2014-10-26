package org.svenehrke.checkout.java8.functional.monad;

public interface Monoid<T> extends Semigroup<T> {
	//the neutral element regarding o
	public T empty();
}

