package org.jfclarkjr.java4hw1;


public class BinarySearch {

	public static void main(String[] args)
	{
		// Create a test array
		int[] arrayTest = {1, 4, 16, 20, 45, 60, 120, 234, 500};
		
		// Some example output of the binarySearch method
		System.out.println(binarySearch(arrayTest,120));
		System.out.println(binarySearch(arrayTest,119));
		
	}

	public static int binarySearch(int[] a, int key) { 
		int low = 0; 
		int high = a.length - 1; 

		while (low <= high) { 
			//int mid = (low + high) / 2; 
			int mid = low + (high -low)/2;  // Corrected version
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
