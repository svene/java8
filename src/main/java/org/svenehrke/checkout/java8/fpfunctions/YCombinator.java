package org.svenehrke.checkout.java8.fpfunctions;


import java.util.function.BiFunction;
import java.util.function.Function;

// see: http://dgronau.wordpress.com/2014/04/05/java-8-und-der-y-kombinator/
public class YCombinator {

	public static <X, Y> Function<X, Y> yCombinator(BiFunction<X, Function<X, Y>, Y> f) {
		return x -> f.apply(x, yCombinator(f));
	}

}
