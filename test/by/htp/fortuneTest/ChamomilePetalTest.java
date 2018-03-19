package by.htp.fortuneTest;

import static org.junit.Assert.*;

import org.junit.Test;

import by.pvt.fortune.model.Chamomile;

public class ChamomilePetalTest {

	@Test
	public void testRandomPetalNumber() {
		Chamomile ch = new Chamomile();
		boolean result = true;
		assertEquals(petalNumber(ch), result);
	}

	public boolean petalNumber(Chamomile ch) {
		if (ch.size() >= 1 && ch.size() <= 10) {
			return true;
		}
		return false;
	}

	@Test
	public void testDefinedPetalNumber() {
		Chamomile ch = new Chamomile(10);
		int result = 10;
		assertEquals(ch.size(), result);
	}

}
