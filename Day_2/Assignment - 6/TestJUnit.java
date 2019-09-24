/**
 * This is JUnit that tests the in1020 method that is available in InTenTwenty
 * class. This contains 7 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase7).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {

	@Test
	public void testCase1() {
		assertEquals(true, InTenTwenty.in1020(12, 99));
	}

	@Test
	public void testCase2() {
		assertEquals(true, InTenTwenty.in1020(21, 12));
	}

	@Test
	public void testCase3() {
		assertEquals(false, InTenTwenty.in1020(8, 99));
	}

	@Test
	public void testCase4() {
		assertEquals(true, InTenTwenty.in1020(99, 10));
	}

	@Test
	public void testCase5() {
		assertEquals(true, InTenTwenty.in1020(20, 20));
	}

	@Test
	public void testCase6() {
		assertEquals(false, InTenTwenty.in1020(21, 21));
	}

	@Test
	public void testCase7() {
		assertEquals(false, InTenTwenty.in1020(9, 9));
	}
}