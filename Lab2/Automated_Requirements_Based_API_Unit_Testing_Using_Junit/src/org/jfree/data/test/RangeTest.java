package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.*;

public class RangeTest {

	private Range range1;
	private Range range2;
	private Range rangeNull;
	private Range rangeEmpty;

	@Before
	public void setUp() throws Exception {
		range1 = new Range(-2, 5);
		range2 = new Range(4, 7);
		rangeNull = new Range(0, 0);
		rangeNull = null;
		rangeEmpty = new Range(0, 0);
	}

	@After
	public void tearDown() throws Exception {
		range1 = null;
		range2 = null;
		rangeNull = null;
		rangeEmpty = null;
	}

	@Test
	public void testIntersectsValidBounds() {
		double lower = 3;
		double upper = 12;

		assertEquals("When provided bounds intersect the specified range, " + "true should be returned",
				range1.intersects(lower, upper), true);
	}

	@Test
	public void testIntersectsInvalidUpperBounds() {
		double lower = 4;
		double upper = -8;

		assertEquals("When provided upper bound is less than the lower bound, " + "false should be returned",
				range1.intersects(lower, upper), false);
	}

	@Test
	public void testIntersectsInvalidLowerBounds() {
		double lower = 16;
		double upper = 3;

		assertEquals("When provided lower bound is greater than the upper bound, " + "false should be returned",
				range1.intersects(lower, upper), false);
	}

	@Test
	public void testIntersectsInvalidBounds() {
		double lower = 19;
		double upper = -11;

		assertEquals(
				"When the provide lower band is greater than the upper bound of the range and the provided upper bound is less than the lower bound of the ranage"
						+ "false should be returned",
				range1.intersects(lower, upper), false);
	}

	@Test
	public void testConstrainValueLessThanLowerBound() {
		double value = -5;

		assertEquals(
				"When provided value is less than the lower bound of the range, the lower bound should be returned "
						+ "-2 should be returned",
				-2.0, range1.constrain(value), 0.1d);
	}

	@Test
	public void testConstrainValueWithinRange() {
		double value = 4;

		assertEquals("When provided value is within the range, the value should be returned" + "4 should be returned",
				4.0, range1.constrain(value), 0.1d);
	}

	@Test
	public void testConstrainValueGreaterThanUpperBound() {
		double value = 15;

		assertEquals("When provided value is greater than the upper bound, the upper bound should be returned"
				+ "5 should be returned", 5.0, range1.constrain(value), 0.1d);
	}

	@Test
	public void testConstrainValueOnLowerBound() {
		double value = -2;

		assertEquals("When provided value is the same as the lower bound, the lower bound should be returned"
				+ "-2 should be returned", -2.0, range1.constrain(value), 0.1d);
	}

	@Test
	public void testConstrainValueOnUpperBound() {
		double value = 5;

		assertEquals("When provided value is the same as the upper bound, the upper bound should be returned"
				+ "5 should be returned", 5.0, range1.constrain(value), 0.1d);
	}

	@Test
	public void testExpandToIncludeRangeNotNullAndValueLessThanLowerBound() {
		double value = -5;
		Range expected = new Range(-5, 5);

		assertEquals(
				"When provided value is less than the lower bound, the range should be expanded to include the provided value"
						+ "The new range should now be -5 to 5",
				expected, Range.expandToInclude(range1, value));
	}

	@Test
	public void testExpandToIncludeRangeNotNullAndValueWithinRange() {
		double value = 3;
		Range expected = new Range(-2, 5);

		assertEquals("When provided value is within the range, the range should not change"
				+ "The range should still be -2 to 5", expected, Range.expandToInclude(range1, value));
	}

	@Test
	public void testExpandToIncludeRangeNotNullAndValueGreaterThanUpperBound() {
		double value = 10;
		Range expected = new Range(-2, 10);

		assertEquals(
				"When provided value is greater than the upper bound, the range should be expanded to include the provided value"
						+ "The new range should now be -2 to 10",
				expected, Range.expandToInclude(range1, value));
	}

	@Test
	public void testExpandToIncludeRangeIsNullAndValueLessThanLowerBound() {
		double value = -5;

		assertEquals("When the range is null, the range should be set to the value which was provided"
				+ "The new range should now be -5", (-5), Range.expandToInclude(rangeNull, value));
	}

	@Test
	public void testExpandToIncludeRangeIsNullAndValueWithinRange() {
		double value = 1;

		assertEquals("When the range is null, the range should be set to the value which was provided"
				+ "The new range should now be 1", (1), Range.expandToInclude(rangeNull, value));
	}

	@Test
	public void testExpandToIncludeRangeIsNullAndValueGreaterThanUpperBound() {
		double value = 9;

		assertEquals("When the range is null, the range should be set to the value which was provided"
				+ "The new range should now be 9", (9), Range.expandToInclude(rangeNull, value));
	}

	@Test
	public void testExpandToIncludeRangeNotNullAndValueOnLowerBound() {
		double value = -2;
		Range expected = new Range(-2, 5);

		assertEquals("When provided value is on the lower bound, the range should not change"
				+ "The range should still be -2 to 5", expected, Range.expandToInclude(range1, value));
	}

	@Test
	public void testExpandToIncludeRangeNotNullAndValueOnUpperBound() {
		double value = 7;
		Range expected = new Range(-2, 5);

		assertEquals("When provided value is on the upper bound, the range should not change"
				+ "The range should still be -2 to 5", expected, Range.expandToInclude(range1, value));
	}

	@Test
	public void testExpandToIncludeRangeIsNullAndValueOnLowerBound() {
		double value = -2;

		assertEquals("When the range is null, the range should be set to the value which was provided"
				+ "The new range should now be -2", (-2.0), Range.expandToInclude(rangeNull, value));
	}

	@Test
	public void testExpandToIncludeRangeIsNullAndValueOnUpperBound() {
		double value = 7;

		assertEquals("When the range is null, the range should be set to the value which was provided"
				+ "The new range should now be 7", (7), Range.expandToInclude(rangeNull, value));
	}

	@Test
	public void testGetLowerBoundRangeSpecified() {

		assertEquals(
				"When provided range is specified, the lowest value should be returned, " + "lower bound should be -2",
				-2.0, range1.getLowerBound(), 0.0000001d);
	}

	@Test
	public void testGetLowerBoundRangeEmpty() {
		Range expected = new Range(0, 0);

		assertEquals("When provided range is specified, the lowest value should be returned, "
				+ "lower bound should be empty", expected, rangeEmpty.getLowerBound());
	}

	@Test
	public void testGetLowerBoundRangeNull() {

		assertEquals("When provided range is specified, the lowest value should be returned, "
				+ "lower bound should be null", null, rangeNull.getLowerBound());
		
		}

	@Test
	public void testCombineBothRangesSpecified() {
		Range expected = new Range(-2, 7);

		assertEquals("When two ranges are specified, the ranges should be combined to extend the final range, "
				+ "the range should now be -2 to 7", expected, Range.combine(range1, range2));
	}

	@Test
	public void testCombineRange2Empty() {
		Range expected = new Range(-2, 5);

		assertEquals("When only one range is specified, the final range should be the range which was specified "
				+ "the range should now be -2 to 5", expected, Range.combine(range1, rangeEmpty));
	}

	@Test
	public void testCombineRange2Null() {
		Range expected = new Range(-2, 5);

		assertEquals("When one range is null, the final range should be the range which was specified, "
				+ "the range should now be -2 to 5", expected, Range.combine(range1, rangeNull));
	}

	@Test
	public void testCombineRange1Empty() {
		Range expected = new Range(4, 7);

		assertEquals("When one range is empty, the final range should be the range which was specified, "
				+ "the range should now be 4 to 7", expected, Range.combine(rangeEmpty, range2));
	}

	@Test
	public void testCombineBothRangesEmpty() {
		Range expected = new Range(0, 0);

		assertEquals("When both ranges are empty, the final range should also be empty", expected,
				Range.combine(rangeEmpty, rangeEmpty));
	}

	@Test

	public void testCombineRange1EmptyRange2Null() {

		assertEquals("When one range is empty and the other is null, the final range should be null", null,
				Range.combine(rangeEmpty, rangeNull));
	}

	@Test
	public void testCombineRange1Null() {
		Range expected = new Range(4, 7);

		assertEquals("When one range is null, the final range should be the range which was specified, "
				+ "the range should now be 4 to 7", expected, Range.combine(rangeNull, range2));

	}

	@Test
	public void testCombineRange1NullRange2Empty() {

		assertEquals("When one range is empty and the other is null, the final range should be null", null,
				Range.combine(rangeNull, rangeEmpty));
	}

	@Test
	public void testCombineBothRangesNull() {

		assertEquals("When both ranges are null, the final range should also be null", null,
				Range.combine(rangeNull, rangeNull));
	}

}
