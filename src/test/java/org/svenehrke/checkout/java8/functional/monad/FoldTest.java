package org.svenehrke.checkout.java8.functional.monad;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.svenehrke.checkout.java8.functional.monad.Fold.fold1;
import static org.svenehrke.checkout.java8.functional.monad.StringMonoid.Append;

public class FoldTest {

	@Test
	public void testFold1() throws Exception {
		assertEquals("EinsZweiDreiVier", fold1(Append, "Eins", "Zwei", "Drei", "Vier"));
	}

	@Test
	public void dual() throws Exception {
		assertEquals("VierDreiZweiEins", fold1(DualMonoid.dual(Append), "Eins", "Zwei", "Drei", "Vier"));
	}


}