package dp;

import java.util.Arrays;

public class LongestDecreasingSubsequence {

	// Recursion
	protected int findDIS(int arr[], int i, int prev) {
		
		// Base condition
		if(i >= arr.length)
			return 0;
		
		int includeCount = 0;
		if(arr[i] < prev) {
			includeCount = 1 + findDIS(arr, i+1, arr[i]);
		}
		
		int excludeCount = findDIS(arr, i+1, prev);
		
		return Math.max(includeCount, excludeCount);	
	}	
	
	public static void main(String[] args) {
		
		LongestDecreasingSubsequence lis = new LongestDecreasingSubsequence();
		
		int[] input = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.print("Input Array : "+Arrays.toString(input));
		
		System.out.print("\nLength of LIS using recursion : "
						+ lis.findDIS(input, 0, Integer.MAX_VALUE));

	}
}
