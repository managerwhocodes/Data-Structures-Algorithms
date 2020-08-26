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

	public static void main(String[] args) {
		
		SlidingWindow sw = new SlidingWindow();
		
		int []input = {1, 3, 2, 6, -1, 4, 1, 8, 2};
		int k = 5;
		int []result = sw.findAvgOfSubArraySizeK(input, k);
		System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
	}

}
