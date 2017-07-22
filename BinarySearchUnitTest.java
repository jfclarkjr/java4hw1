package org.jfclarkjr.java4hw1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	
	/* 
	 * Test upper limits of the size of the array.
	 * This particular test can't be run on my laptop
	 * using the full Integer.MAX_VALUE due to insufficient memory.
	 * Through trial and error, I found I have enough memory to run this with
	 * an array of size [Integer.MAX_VALUE - 500000000].
	 * This is enough to trigger the known error.
	 */
	@Test
	public void testMaxSizeArray()
	{
		int maxNum = Integer.MAX_VALUE - 500000000;
		int largeArray[] = new int[maxNum];

		for (int i=0; i < maxNum; i++)
		{
			largeArray[i] = i;
		}

		// To test for the binary search bug, the key needs to be in an array element
		// higher than the mid value.  In this case, if it's 823741824 or above
		// we'll encounter the error (if bug is present in the method).
		assertEquals(823741824,BinarySearch.binarySearch(largeArray, 823741824));

	}
}
