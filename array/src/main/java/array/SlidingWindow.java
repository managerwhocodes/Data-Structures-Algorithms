package array;

import java.util.Arrays;

public class SlidingWindow {

	
	protected int[] findAvgOfSubArraySizeK(int []input, int k) {
		
		if(input.length == 0 || input.length < k)
			return new int[0];
		
		int windowSum = 0;
		int windowStart = 0;
		int []result = new int[input.length - k + 1];
		
		for(int windowEnd=0; windowEnd<input.length; windowEnd++) {
			windowSum += input[windowEnd];
			if(windowEnd >= k-1) {
				result[windowStart] = windowSum / k;
				windowSum -= input[windowStart];
				windowStart++;
			}
		}
		return result;				
	}
	
	protected int findMaxSumSubArray(int[] input, int k) {
	    
		int maxSum = Integer.MIN_VALUE;
		int windowSum = 0;
		int windowStart = 0;
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++) {
			windowSum += input[windowEnd];
			if(windowEnd >= k-1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= input[windowStart];
				windowStart++;
			}
		}
	    return maxSum;
	  }
	
	protected int findMinSubArray(int[] input, int s) {
	    
		int windowSum = 0;
		int windowStart = 0;
		int minLength = Integer.MAX_VALUE;
		
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
			windowSum += input[windowEnd];
			
			while(windowSum >=s) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				windowSum -= input[windowStart];
				windowStart++;
			}
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	  }

	public static void main(String[] args) {
		
		SlidingWindow sw = new SlidingWindow();
		
		int []input = {1, 3, 2, 6, -1, 4, 1, 8, 2};
		int k = 5;
		int []result = sw.findAvgOfSubArraySizeK(input, k);
		System.out.println("Averages of subarrays of size K: " 
				+ Arrays.toString(result));
		
		System.out.println("Maximum sum of a subarray of size K: "
		        + sw.findMaxSumSubArray(input , k));
		
		input = new int[] {3, 4, 1, 1, 6};
		int sum = 8;
		
		System.out.println("Smallest subarray length: " + sw.findMinSubArray(input, sum));
		
	}

}
