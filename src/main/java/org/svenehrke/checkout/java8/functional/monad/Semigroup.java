package org.svenehrke.checkout.java8.functional.monad;

public interface Semigroup<T> {
	//a binary associative operation
	public T o(T t1, T t2);
}

