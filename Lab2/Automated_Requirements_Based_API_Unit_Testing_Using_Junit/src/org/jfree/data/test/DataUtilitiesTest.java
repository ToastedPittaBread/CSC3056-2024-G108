package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;

import org.junit.*;

public class DataUtilitiesTest {
	
	private Values2D data;
	private double[] dataArray;
	private double[][] dataArray2D;
	private KeyedValues dataValues;

	@Before
	public void setUp() throws Exception {
		// Setup for testCalculateColumnTotal... and testCalculateRowTotal...
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		
		testValues.addValue(3, 4, 5);
		testValues.addValue(3, 0, 11);
		
		data = testValues;
		
		// Setup for testCreateNumberArray...
		dataArray = new double[3];
		dataArray[0] = 1.5;
		dataArray[1] = 2.5;
		dataArray[2] = 3.5;
		
		// Setup for testCreateNumberArray2D...
		dataArray2D = new double[2][3];
		dataArray2D[0][0] = 1.5;
		dataArray2D[0][1] = 2.5;
		dataArray2D[0][2] = 3.5;
		dataArray2D[1][0] = 4.5;
		dataArray2D[1][1] = 5.5;
		dataArray2D[1][2] = 6.5;

		// Setup for testGetCumulativePercentages...
		DefaultKeyedValues testKeyValues = new DefaultKeyedValues();
		
		testKeyValues.addValue((Comparable<?>) 0, 5);
		testKeyValues.addValue((Comparable<?>) 1, 9);
		testKeyValues.addValue((Comparable<?>) 2, 2);
		
		dataValues = DataUtilities.getCumulativePercentages((KeyedValues) testKeyValues);
	}

	@After
	public void tearDown() throws Exception {
		data = null;
		dataArray = null;
		dataValues = null;
	}
	
	@Test
	public void testCalculateColumnTotalWithValidDataAndColumnValue() { 
		int column = 1;
		
		assertEquals("When valid 2D matrix and column value supplied, 4.0 should be returned", 
				4.0, DataUtilities.calculateColumnTotal(data, column), 0.0000001d); 
	}
	
	@Test
	public void testCalculateColumnTotalWithValidDataAndInvalidColumnValueLessThan0() { 
		int column = -1;
		
		assertEquals("When valid 2D matrix and invalid column value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateColumnTotal(data, column), 0.0000001d); 
	}
	
	@Test
	public void testCalculateColumnTotalWithValidDataAndInvalidColumnValueGreaterThanNumberOfColumns() { 
		int column = 13;
		
		assertEquals("When valid 2D matrix and invalid column value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateColumnTotal(data, column), 0.0000001d); 
	}
	
	@Test
	public void testCalculateColumnTotalWithEmptyDataAndValidColumnValue() { 
		int column = 1;
		
		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
		
		data = testEmpty;
		
		assertEquals("When empty 2D matrix and valid column value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateColumnTotal(data, column), 0.0000001d); 
	}
	
	@Test
	public void testCalculateColumnTotalWithEmptyDataAndInvalidColumnValueLessThan0() { 
		int column = -1;
		
		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
		
		data = testEmpty;
		
		assertEquals("When empty 2D matrix and invalid column value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateColumnTotal(data, column), 0.0000001d); 
	}
	
	@Test
	public void testCalculateColumnTotalWithEmptyDataAndInvalidColumnValueGreaterThanNumberOfColumns() { 
		int column = 13;
		
		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
		
		data = testEmpty;
		
		assertEquals("When empty 2D matrix and invalid column value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateColumnTotal(data, column), 0.0000001d); 
	}
	
	@Test
	public void testCalculateColumnTotalWithNullDataAndValidColumnValue() { 
		int column = 1;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null 2D matrix and valid column value supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotalWithNullDataAndInvalidColumnValueLessThan0() { 
		int column = -1;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null 2D matrix and invalid column value supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotalWithNullDataAndInvalidColumnValueGreaterThanNumberOfColumns() { 
		int column = 13;
		
		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null 2D matrix and invalid column value supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalWithValidDataAndRowValue() { 
		int row = 0;
		
		assertEquals("When valid 2D matrix and row value supplied, 12.0 should be returned", 
				12.0, DataUtilities.calculateRowTotal(data, row), 0.0000001d); 
	}
	
	@Test
	public void testCalculateRowTotalWithValidDataAndInvalidRowValueLessThan0() { 
		int row = -1;
		
		assertEquals("When valid 2D matrix and invalid row value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateRowTotal(data, row), 0.0000001d); 
	}
	
	@Test
	public void testCalculateRowTotalWithValidDataAndInvalidRowValueGreaterThanNumberOfRows() { 
		int row = 13;
		
		assertEquals("When valid 2D matrix and invalid row value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateRowTotal(data, row), 0.0000001d); 
	}
	
	@Test
	public void testCalculateRowTotalWithEmptyDataAndValidRowValue() { 
		int row = 0;
		
		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
		
		data = testEmpty;
		
		assertEquals("When empty 2D matrix and valid row value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateRowTotal(data, row), 0.0000001d); 
	}
	
	@Test
	public void testCalculateRowTotalWithEmptyDataAndInvalidRowValueLessThan0() { 
		int row = -1;
		
		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
		
		data = testEmpty;
		
		assertEquals("When empty 2D matrix and invalid row value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateRowTotal(data, row), 0.0000001d); 
	}
	
	@Test
	public void testCalculateRowTotalWithEmptyDataAndInvalidRowValueGreaterThanNumberOfRows() { 
		int row = 13;
		
		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
		
		data = testEmpty;
		
		assertEquals("When empty 2D matrix and invalid row value supplied, 0.0 should be returned", 
				0.0, DataUtilities.calculateRowTotal(data, row), 0.0000001d); 
	}
	
	@Test
	public void testCalculateRowTotalWithNullDataAndValidRowValue() { 
		int row = 0;
		
		try {
			DataUtilities.calculateRowTotal(null, row);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null 2D matrix and valid row value supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalWithNullDataAndInvalidRowValueLessThan0() { 
		int row = -1;
		
		try {
			DataUtilities.calculateRowTotal(null, row);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null 2D matrix and invalid row value supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalWithNullDataAndInvalidRowValueGreaterThanNumberOfRows() { 
		int row = 13;
		
		try {
			DataUtilities.calculateRowTotal(null, row);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null 2D matrix and invalid row value supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArrayWithValidDataArray() { 
		Number[] expectedOutput = {1.5, 2.5, 3.5};
		
		assertArrayEquals("When valid double array supplied, valid array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray(dataArray)); 
	}
	
	@Test
	public void testCreateNumberArrayWithEmptyDataArray() { 
		Number[] expectedOutput = {};
		
		dataArray = new double[0];
		
		assertArrayEquals("When empty double array supplied, an empty array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray(dataArray)); 
	}
	
	@Test
	public void testCreateNumberArrayWithNullDataArray() { 
		try {
			DataUtilities.createNumberArray(null);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null data array supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArrayWithValidDataArrayOfNegativeValues() { 
		Number[] expectedOutput = {-1.5, -2.5, -3.5};
		
		dataArray = new double[3];
		dataArray[0] = -1.5;
		dataArray[1] = -2.5;
		dataArray[2] = -3.5;
		
		assertArrayEquals("When valid double array supplied, valid array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray(dataArray)); 
	}
	
	@Test
	public void testCreateNumberArrayWithValidDataArrayOfZeroValues() { 
		Number[] expectedOutput = {0.0, 0.0, 0.0};
		
		dataArray = new double[3];
		dataArray[0] = 0.0;
		dataArray[1] = 0.0;
		dataArray[2] = 0.0;
		
		assertArrayEquals("When valid double array supplied, valid array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray(dataArray)); 
	}
	
	@Test
	public void testCreateNumberArrayWithValidDataArrayOfLargeValues() { 
		Number[] expectedOutput = {1000.0, 2000.0, 3000.0};
		
		dataArray = new double[3];
		dataArray[0] = 1000.0;
		dataArray[1] = 2000.0;
		dataArray[2] = 3000.0;
		
		assertArrayEquals("When valid double array supplied, valid array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray(dataArray)); 
	}
	
	@Test
	public void testCreateNumberArrayWithValidDataArrayOfMixedValues() { 
		Number[] expectedOutput = {1.5, -2.5, 0.0, 3000.0};
		
		dataArray = new double[4];
		dataArray[0] = 1.5;
		dataArray[1] = -2.5;
		dataArray[2] = 0.0;
		dataArray[3] = 3000.0;
		
		assertArrayEquals("When valid double array supplied, valid array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray(dataArray)); 
	} 
	
	@Test
	public void testCreateNumberArray2DWithValidDataArray2D() { 
		Number[][] expectedOutput = {{1.5, 2.5, 3.5}, {4.5, 5.5, 6.5}};
		
		assertArrayEquals("When valid 2D double array supplied, valid 2D array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray2D(dataArray2D)); 
	}
	
	@Test
	public void testCreateNumberArray2DWithEmptyDataArray2D() { 
		Number[][] expectedOutput = {};
		
		dataArray2D = new double[0][0];
		
		assertArrayEquals("When empty 2D double array supplied, an empty 2D array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray2D(dataArray2D)); 
	}
	
	@Test
	public void testCreateNumberArray2DWithNullDataArray2D() { 
		try {
			DataUtilities.createNumberArray2D(null);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null 2D double array supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DWithValidDataArray2DOfNegativeValues() { 
		Number[][] expectedOutput = {{-1.5, -2.5, -3.5}, {-4.5, -5.5, -6.5}};
		
		dataArray2D = new double[2][3];
		dataArray2D[0][0] = -1.5;
		dataArray2D[0][1] = -2.5;
		dataArray2D[0][2] = -3.5;
		dataArray2D[1][0] = -4.5;
		dataArray2D[1][1] = -5.5;
		dataArray2D[1][2] = -6.5;
		
		assertArrayEquals("When valid 2D double array supplied, valid 2D array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray2D(dataArray2D)); 
	}
	
	@Test
	public void testCreateNumberArray2DWithValidDataArray2DOfZeroValues() { 
		Number[][] expectedOutput = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		
		dataArray2D = new double[2][3];
		dataArray2D[0][0] = 0.0;
		dataArray2D[0][1] = 0.0;
		dataArray2D[0][2] = 0.0;
		dataArray2D[1][0] = 0.0;
		dataArray2D[1][1] = 0.0;
		dataArray2D[1][2] = 0.0;
		
		assertArrayEquals("When valid 2D double array supplied, valid 2D array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray2D(dataArray2D)); 
	}
	
	@Test
	public void testCreateNumberArray2DWithValidDataArray2DOfLargeValues() { 
		Number[][] expectedOutput = {{1000.0, 2000.0, 3000.0}, {4000.0, 5000.0, 6000.0}};
		
		dataArray2D = new double[2][3];
		dataArray2D[0][0] = 1000.0;
		dataArray2D[0][1] = 2000.0;
		dataArray2D[0][2] = 3000.0;
		dataArray2D[1][0] = 4000.0;
		dataArray2D[1][1] = 5000.0;
		dataArray2D[1][2] = 6000.0;
		
		assertArrayEquals("When valid 2D double array supplied, valid 2D array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray2D(dataArray2D)); 
	}
	
	@Test
	public void testCreateNumberArray2DWithValidDataArray2DOfMixedValues() { 
		Number[][] expectedOutput = {{1.5, -2.5, 3.5}, {0.0, 4000.0, 0.0}};
		
		dataArray2D = new double[2][3];
		dataArray2D[0][0] = 1.5;
		dataArray2D[0][1] = -2.5;
		dataArray2D[0][2] = 3.5;
		dataArray2D[1][0] = 0.0;
		dataArray2D[1][1] = 4000.0;
		dataArray2D[1][2] = 0.0;
		
		assertArrayEquals("When valid 2D double array supplied, valid 2D array of Number objects should be returned", 
				expectedOutput, DataUtilities.createNumberArray2D(dataArray2D)); 
	}
	
	@Test
	public void testGetCumulativePercentagesWithValidData() { 
		assertEquals("When valid data is supplied, the cumulative percentage should be 1.0", 
				1.0, (double) dataValues.getValue(2), 0.000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesWithEmptyData() { 
		DefaultKeyedValues testKeyValues = new DefaultKeyedValues();
		
		dataValues = DataUtilities.getCumulativePercentages((KeyedValues) testKeyValues);
		
		try {
			DataUtilities.getCumulativePercentages(dataValues);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When empty data supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentagesWithNullData() { 
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("No exception was thrown. The expected outcome was a thrown exception of"
					+ " type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("When null data supplied, should throw IllegalArgumentException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
} 
