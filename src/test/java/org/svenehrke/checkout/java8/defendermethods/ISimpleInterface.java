package org.svenehrke.checkout.java8.defendermethods;

public interface ISimpleInterface {
	public String doSomeWork();

	default public String doSomeOtherWork() {
		return "ISimpleInterface.doSomeOtherWork";
	}
}
