package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	
	protected int findLenOfLongestSubStrWithKChar(String str, int k) {
		
	    if (str == null || str.length() == 0 || str.length() < k)
	      throw new IllegalArgumentException("Invalid Input");
	    
	    int windowStart = 0;
	    int maxLength = 0;
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    
	    for(int windowEnd = 0; windowEnd<str.length(); windowEnd++) {
	    	char chRight = str.charAt(windowEnd);
	    	map.put(chRight, map.getOrDefault(chRight, 0) +1);
	    	
	    	while(map.size() > k) {
	    		char chLeft = str.charAt(windowStart);
	    		map.put(chLeft, map.get(chLeft)-1);
	    		
	    		if(map.get(chLeft) ==0)
	    			map.remove(chLeft);
	    		
	    		windowStart++;
	    	}
	    	maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
	    
	    }
	    return maxLength;
	}
	
	protected int findLenOfLongestSubstringWithoutRep(String str) {
	    
	    if (str == null || str.length() == 0)
		      throw new IllegalArgumentException("Invalid Input");
		
		int windowStart = 0;
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int windowEnd = 0; windowEnd<str.length(); windowEnd++) {
			char chRight = str.charAt(windowEnd);
			if(map.containsKey(chRight)) {
				windowStart = Math.max(windowStart, map.get(chRight)+1);
			}
			map.put(chRight, windowEnd);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1); 
		}
		return maxLength;		
	}
	
	protected int findLenOfLongestSubstringAfterReplacement(String str, int k) {
	    if (str == null || str.length() == 0)
		      throw new IllegalArgumentException("Invalid Input");
		
		int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
		Map<Character, Integer> letterFrequencyMap = new HashMap<Character, Integer>();
		
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
		    letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
		    maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));
		    
		    
		    if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
		    	 char leftChar = str.charAt(windowStart);
		         letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
		         windowStart++;
		    }
		    
		    maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		
		return maxLength;
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
		
		System.out.println("Length of the longest substring: " + sw.findLenOfLongestSubStrWithKChar("cbbebi", 3));
		
		System.out.println("Length of the longest substring: " + sw.findLenOfLongestSubstringWithoutRep("aabccbb"));
		
		System.out.println(sw.findLenOfLongestSubstringAfterReplacement("aabccbb", 2));
		
	}

}
