package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	// Recursion
	protected int findLIS(int arr[], int i, int prev) {
		
		// Base condition
		if(i >= arr.length)
			return 0;
		
		int includeCount = 0;
		if(arr[i] > prev) {
			includeCount = 1 + findLIS(arr, i+1, arr[i]);
		}
		
		int excludeCount = findLIS(arr, i+1, prev);
		
		return Math.max(includeCount, excludeCount);	
	}
	
	public static void main(String[] args) {
		
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		
		int[] input = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.print("Input Array : "+Arrays.toString(input));
		
		System.out.print("\nLength of LIS : "
						+ lis.findLIS(input, 0, Integer.MIN_VALUE));

	}
}
