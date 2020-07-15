package dp;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

	// Recursion
	protected int findLIS(int arr[], int i, int prev, int sum) {
		
		// Base condition
		if(i >= arr.length)
			return sum;
		
		int includeCurrentSum = sum;
		if(arr[i] > prev) {
			includeCurrentSum = findLIS(arr, i+1, arr[i], sum+arr[i]);
		}
		
		int excludeCurrentSum = findLIS(arr, i+1, prev,sum);
		
		return Math.max(includeCurrentSum, excludeCurrentSum);	
	}
	

	public static void main(String[] args) {
		
		MaximumSumIncreasingSubsequence msis = new MaximumSumIncreasingSubsequence();
		
		int[] input = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.print("Input Array : "+Arrays.toString(input));
		
		System.out.print("\nMaximum sum of increasing subsequence using recursion : "
						+ msis.findLIS(input, 0, Integer.MIN_VALUE, 0));
		
	}
}