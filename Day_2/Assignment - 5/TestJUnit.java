/**
 * This is JUnit that tests the icyHot method that is available 
 * in IcyHot class. This contains 6 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase4).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {

	@Test
	public void testCase1() {
		assertEquals(true, IcyHot.icyHot(120, -1));
	}

	@Test
	public void testCase2() {
		assertEquals(true, IcyHot.icyHot(-1, 120));
	}

	@Test
	public void testCase3() {
		assertEquals(false, IcyHot.icyHot(2, 120));
	}

	@Test
	public void testCase4() {
		assertEquals(false, IcyHot.icyHot(-1, 100));
	}

	@Test
	public void testCase5() {
		assertEquals(false, IcyHot.icyHot(-2, -2));
	}

	@Test
	public void testCase6() {
		assertEquals(false, IcyHot.icyHot(120, 120));
	}
}