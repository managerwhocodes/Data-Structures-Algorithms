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
	
	// Top-down
	protected int findLIS_TD(Integer dp[][], int arr[], int curr, int prev) {
		
		// Base condition
		if(curr >= arr.length)
			return 0;
		
		if(dp[prev+1][curr] != null)
			return dp[prev+1][curr];
		
		int includeCount = 0;
		if(prev < 0 || arr[curr] > arr[prev]) {
			includeCount = 1 + findLIS_TD(dp, arr, curr+1, curr);
			//dp[i] = includeCount;
		}
		
		int excludeCount = findLIS_TD(dp, arr, curr+1, prev);
		dp[prev+1][curr] = Math.max(includeCount, excludeCount);
		
		return dp[prev+1][curr];	
	}	
	
	public static void main(String[] args) {
		
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		
		int[] input = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.print("Input Array : "+Arrays.toString(input));
		
		System.out.print("\nLength of LIS using recursion : "
						+ lis.findLIS(input, 0, Integer.MIN_VALUE));
		
		
		Integer [][]dp = new Integer[input.length+1][input.length];
		
		System.out.print("\nLength of LIS using top down : "
				+ lis.findLIS_TD(dp,input, 0, -1));

	}
}
