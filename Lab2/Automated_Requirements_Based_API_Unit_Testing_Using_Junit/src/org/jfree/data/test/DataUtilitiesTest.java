package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;

import org.junit.*;

public class DataUtilitiesTest {
	
	private Values2D values2D;
	private KeyedValues objectUnderTest;

	@Before
	public void setUp() throws Exception {
		// Setup for testValidDataAndColumnColumnTotal
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		
		// Setup for testGetCumulativePercentages
		DefaultKeyedValues testKeyValues = new DefaultKeyedValues();
		
		testKeyValues.addValue((Comparable<?>) 0.0, 6.0);
		testKeyValues.addValue((Comparable<?>) 1.0, 11.0);
		testKeyValues.addValue((Comparable<?>) 2.0, 3.0);
		
		objectUnderTest = DataUtilities.getCumulativePercentages((KeyedValues) testKeyValues);
	}

	@After
	public void tearDown() throws Exception {
		values2D = null;
		objectUnderTest = null;
	}

	@Test
	public void testValidDataAndColumnTotal() { 
		assertEquals("When valid data supplied in data table, 5.0 should be returned", 
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d); 
	}
	
	@Test
	public void testNullDataAndColumnTotal() { 
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null object is passed in, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentages() { 
		assertEquals("When valid data is supplied, the cumulative percentage should be 1.0", 
				1.0, (double) objectUnderTest.getValue(2), 0.000000001d);
	}
}
