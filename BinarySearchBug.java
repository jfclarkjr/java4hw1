package org.jfclarkjr.java4hw1;

/**
 * BinarySearch is a class used to test the java.util.Collections binary search method
 * <p>
 * This version contains the binarySearch method with the binary search bug.
 * <p>
 * Java 4 Homework assignment #1
 * 
 * @author John Clark
 * @since 1.8
 *
 *
 */
public class BinarySearchBug {

	public static void main(String[] args)
	{
		// Create a test array
		int[] arrayTest = {1, 4, 16, 20, 45, 60, 120, 234, 500};
		
		// Some example output of the binarySearch method
		System.out.println(binarySearch(arrayTest,120));
		System.out.println(binarySearch(arrayTest,119));
		
	}

	/**
	 * The binarySearch method is from the java.util.Collections binary search method.
	 * This is used here to test for the binary search bug, and to test a fix for this bug.
	 * <p>
	 * This version contains the bug.
	 * 
	 * @param a An array of integers sorted in increasing order
	 * @param key The key to be looked up by the method
	 * @return An integer specifying the location in the array where the value is found.
	 *         If the value is not found in the array, a negative number is returned. 
	 */
	public static int binarySearch(int[] a, int key) { 
		int low = 0; 
		int high = a.length - 1; 

		while (low <= high) { 
			int mid = (low + high) / 2; 
			int midVal = a[mid]; 

			if (midVal < key) 
				low = mid + 1; 
			else if (midVal > key) 
				high = mid - 1; 
			else 
				return mid; // key found 
		} 
		return -(low + 1);  // key not found. 
	}

}
