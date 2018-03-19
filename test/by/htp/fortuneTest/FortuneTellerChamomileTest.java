package by.htp.fortuneTest;

import static org.junit.Assert.*;

import org.junit.Test;

import by.pvt.fortune.model.FortuneTeller;

public class FortuneTellerChamomileTest {

	@Test
	public void testRandomNumberOfFlowers() {
		FortuneTeller ft = new FortuneTeller();
		boolean result = true;
		assertEquals(numberOfFlowers(ft), result);
	}

	@Test
	public void testDefinedNumberOfFlowers() {
		FortuneTeller ft = new FortuneTeller(10);
		int result = 10;
		assertEquals(ft.getCapacity(), result);
	}

	public boolean numberOfFlowers(FortuneTeller ft) {
		if (ft.getCapacity() >= 1 && ft.getCapacity() <= 10) {
			return true;
		}
		return false;
	}

}
