package org.svenehrke.checkout.java8.functional.monad;

public enum StringMonoid implements Monoid<String> {
	Append(){
		@Override
		public String empty() {
			return "";
		}

		@Override
		public String o(String t1, String t2) {
			return t1 + t2;
		}
	}
}

