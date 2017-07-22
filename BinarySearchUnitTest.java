package org.jfclarkjr.java4hw1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is a JUnit to test the BinarySearch.binarySearch method to find the
 * binary search bug.
 * <p>
 * The bug is an integer overflow that can occur when using very large arrays
 * (i.e. greater than (2 + 2 * (Integer.MAX_VALUE/3)) number of elements).
 * In the JUnit tests, the integer overflow triggers an ArrayIndexOutOfBoundsException.
 * <p>
 * To prevent the integer overflow, the following calculation:
 * <br>
 * int mid = (low + high)/2
 * <br>
 * Is replaced with this in the corrected version:
 * <br>
 * int mid = low + (high -low)/2
 * <p>
 * Java 4 Homework assignment #1
 * 
 * @author John Clark
 * @since 1.8
 *
 */
public class BinarySearchUnitTest
{

	@Test
	public void testPositiveArray()
	{
		// Test for valid results in a binary search for a small array
		// of positive values with 9 elements
		int[] array1 = {1, 4, 16, 20, 45, 60, 120, 234, 500};
		assertEquals(5,BinarySearch.binarySearch(array1, 60));
		assertEquals(0,BinarySearch.binarySearch(array1, 1));
		assertEquals(8,BinarySearch.binarySearch(array1, 500));

	}

	@Test
	public void testNegativeArray()
	{
		// Test for valid results in a binary search for a small array
		// of negative values with 9 elements
		int[] array2 = {-251, -144, -106, -93, -45, -23, -19, -11, -2};
		assertEquals(5,BinarySearch.binarySearch(array2, -23));
		assertEquals(0,BinarySearch.binarySearch(array2, -251));
		assertEquals(8,BinarySearch.binarySearch(array2, -2));
	}
	
	@Test
	public void testEvenArray()
	{
		// Test for valid results in a binary search for a small array
		// with 8 elements
		int[] array3 = {-251, -144, -106, -93, -45, -23, -19, -11};
		assertEquals(5,BinarySearch.binarySearch(array3, -23));
		assertEquals(0,BinarySearch.binarySearch(array3, -251));
		assertEquals(7,BinarySearch.binarySearch(array3, -11));
	}
	
	@Test
	public void testZeroValue()
	{
		// Test for valid results in a binary search for a small array
		// with 0 as a value
		int[] array4 = {-251, -144, 0, 93, 145, 20023, 30405, 100103};
		assertEquals(2,BinarySearch.binarySearch(array4, 0));
		assertEquals(0,BinarySearch.binarySearch(array4, -251));
		assertEquals(7,BinarySearch.binarySearch(array4, 100103));
	}
	
	@Test 
	public void testTwoElementArray()
	{
		// Test for valid results in a binary search for an array
		// with 2 elements
		int[] array5 = {-25, 13};
		assertEquals(0,BinarySearch.binarySearch(array5, -25));
		assertEquals(1,BinarySearch.binarySearch(array5, 13));
	}
	
	@Test
	public void testOneElementArray()
	{
		// Test for valid results in a binary search for an array
		// with 1 element
		int[] array6 = {-25};
		assertEquals(0,BinarySearch.binarySearch(array6, -25));
	}
	
	@Test
	public void testValueNotFound()
	{
		// Test for valid results if value is not present
		int[] array7 = {-251, -144, 0, 93, 145, 20023, 30405, 100103};
		assertEquals(-5,BinarySearch.binarySearch(array7, 144));
	}
	
	@Test
	public void testMaxMinValues()
	{
		// Test upper and lower limits for array element values
		int[] array8 = {-Integer.MAX_VALUE, -144, 0, 93, 145, 20023, 30405, Integer.MAX_VALUE};
		assertEquals(6,BinarySearch.binarySearch(array8, 30405));
		assertEquals(7,BinarySearch.binarySearch(array8, Integer.MAX_VALUE));
		assertEquals(0,BinarySearch.binarySearch(array8, -Integer.MAX_VALUE));
	}
	
	/** 
	 * Test upper limits of the size of the array.
	 * <p>
	 * This particular test can't be run on my laptop
	 * using the full Integer.MAX_VALUE due to insufficient memory.
	 * I found I have enough memory to run this with
	 * an array of size [2 + 2 * (Integer.MAX_VALUE/3)].
	 * This is the minimum array size needed to trigger the known error.
	 */
	@Test
	public void testMaxSizeArray()
	{
		int maxNum = 2 + 2 * (Integer.MAX_VALUE/3);
		int largeArray[] = new int[maxNum];

		// Populate the array with integer values
		for (int i=0; i < maxNum; i++)
		{
			largeArray[i] = i;
		}

		// To test for the binary search bug, the key needs to be in an array element
		// higher than the mid value.  In this case, if it's 715827883 or above
		// we'll encounter the error (if bug is present in the method).
		assertEquals(715827883,BinarySearch.binarySearch(largeArray, 715827883));

	}
}
