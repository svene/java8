package org.svenehrke.checkout.java8.functional.monad;

public enum BoolMonoid implements Monoid<Boolean> {
	And(){
		@Override
		public Boolean empty() {
			return Boolean.TRUE;
		}

		@Override
		public Boolean o(Boolean t1, Boolean t2) {
			return t1 && t2;
		}
	},
	Or(){
		@Override
		public Boolean empty() {
			return Boolean.FALSE;
		}

		@Override
		public Boolean o(Boolean t1, Boolean t2) {
			return t1 || t2;
		}
	}
}

