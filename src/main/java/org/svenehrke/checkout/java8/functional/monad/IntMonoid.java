package org.svenehrke.checkout.java8.functional.monad;

public enum IntMonoid implements Monoid<Integer> {
	Sum(){
		@Override
		public Integer empty() {
			return 0;
		}

		@Override
		public Integer o(Integer t1, Integer t2) {
			return t1 + t2;
		}
	},
	Product(){
		@Override
		public Integer empty() {
			return 1;
		}

		@Override
		public Integer o(Integer t1, Integer t2) {
			return t1 * t2;
		}
	},
	Min(){
		@Override
		public Integer empty() {
			return Integer.MAX_VALUE;
		}

		@Override
		public Integer o(Integer t1, Integer t2) {
			return Math.min(t1, t2);
		}
	},
	Max(){
		@Override
		public Integer empty() {
			return Integer.MIN_VALUE;
		}

		@Override
		public Integer o(Integer t1, Integer t2) {
			return Math.max(t1,t2);
		}
	}
}

