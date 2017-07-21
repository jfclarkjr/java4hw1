package org.jfclarkjr.java4hw1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchUnitTest
{
	
	@Test
	public void testBinarySearch()
	{
		int[] numbers = {1, 4, 16, 20, 45, 60, 120, 234, 500};
		
		assertEquals(5,BinarySearch.binarySearch(numbers, 60));
		
		try
		{
			//int maxNum = Integer.MAX_VALUE;
			int maxNum = 200;
			int largeArray[] = new int[maxNum];
			
			for (int i=0; i < maxNum; i++)
			{
				largeArray[i] = i;
			}
			assertEquals(60,BinarySearch.binarySearch(largeArray, 60));
		}
		catch (OverflowException e)
		{
			
		}
	}
}
