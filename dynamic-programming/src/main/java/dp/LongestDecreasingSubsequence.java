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
	
	// Top-down
	protected int findDIS_TD(Integer dp[][], int arr[], int curr, int prev) {
		
		// Base condition
		if(curr >= arr.length)
			return 0;
		
		if(dp[prev+1][curr] != null)
			return dp[prev+1][curr];
		
		int includeCount = 0;
		if(prev < 0 || arr[curr] < arr[prev]) {
			includeCount = 1 + findDIS_TD(dp, arr, curr+1, curr);
		}
		
		int excludeCount = findDIS_TD(dp, arr, curr+1, prev);
		dp[prev+1][curr] = Math.max(includeCount, excludeCount);
		
		return dp[prev+1][curr];	
	}	
	
	public static void main(String[] args) {
		
		LongestDecreasingSubsequence lis = new LongestDecreasingSubsequence();
		
		int[] input = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.print("Input Array : "+Arrays.toString(input));
		
		System.out.print("\nLength of LIS using recursion : "
						+ lis.findDIS(input, 0, Integer.MAX_VALUE));
		
		
		Integer [][]dp = new Integer[input.length+1][input.length];
		
		System.out.print("\nLength of LIS using top down : "
				+ lis.findDIS_TD(dp,input, 0, -1));

	}
}
