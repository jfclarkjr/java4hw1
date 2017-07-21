package com.jfclarkjr.java4hw1;

public class BinarySearch {

	public static void main(String[] args)
	{
		int[] numbers = {1, 4, 16, 20, 45, 60, 120, 234, 500};
		
		System.out.println(binarySearch(numbers,120));


	}

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
