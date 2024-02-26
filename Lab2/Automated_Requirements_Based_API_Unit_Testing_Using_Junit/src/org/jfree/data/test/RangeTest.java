package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.*;

public class RangeTest {
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("When the range is between -1 and 1, the central value should be 0", 0, 
				rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testGetLengthWithEqualPositiveValues() {
		Range r1 = new Range(2, 2);
		
		assertEquals("When provided range is between equal, positive values, length should "
				+ "be 0", 0.0, r1.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthWithNonEqualPositiveValues() {
		Range r2 = new Range(4, 9);
		
		assertEquals("When provided range is between non equal, positive values, length should "
				+ "be 5", 5.0, r2.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthWithEqualNegativeValues() {
		Range r3 = new Range(-99, -99);
		
		assertEquals("When provided range is between equal, negative values, length should "
				+ "be 0", 0.0, r3.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthWithNonEqualNegativeValues() {
		Range r4 = new Range(-11, -4);
		
		assertEquals("When provided range is between non equal, negative values, length should "
				+ "be 7", 7.0, r4.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthWithOnePositiveOneNegativeValues() {
		Range r5 = new Range(-5, 3);
		
		assertEquals("When provided range is between one positive and one negative values, "
				+ "length should be 8", 8.0, r5.getLength(), 0.0000001d);
	}
}
