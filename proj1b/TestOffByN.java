import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestOffByN {

	static CharacterComparator offByN = new OffByN(5);
	@Test
	public void testOffByN() {
		assertTrue(offByN.equalChars('a', 'f'));
		assertFalse(offByN.equalChars('a', 'e'));
	}
}
