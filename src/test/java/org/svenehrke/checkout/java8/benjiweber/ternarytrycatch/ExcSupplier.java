package org.svenehrke.checkout.java8.benjiweber.ternarytrycatch;

@FunctionalInterface
public interface ExcSupplier<T, E extends Exception> {
	T get() throws E;
}
