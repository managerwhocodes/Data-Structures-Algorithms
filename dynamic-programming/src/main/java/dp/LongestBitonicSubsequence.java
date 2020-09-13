package dp;

import java.util.Arrays;

public class LongestBitonicSubsequence {
	
	// Recursion
	protected int findLBSLength(int []nums) {
		int maxLength = 0;
		for(int i=0; i<nums.length; i++) {
			int length1 = findLDSLength(nums, i, -1);
			int length2 = findLDSLengthRev(nums, i, -1);
			maxLength = Math.max(maxLength, length1+length2-1);
		}
		return maxLength;
	}

	protected int findLDSLength(int []nums, int currentIndex, int previousIndex) {
		
		if(currentIndex == nums.length)
			return 0;
		
		int length1 = 0;
		if(previousIndex ==-1 || nums[currentIndex] < nums[previousIndex])
			length1 = 1 + findLDSLength(nums, currentIndex+1, currentIndex);
		
		int length2 = findLDSLength(nums, currentIndex+1, previousIndex);
		
		return Math.max(length1, length2);
			
	}
	
	protected int findLDSLengthRev(int []nums, int currentIndex, int previousIndex) {
		
		if(currentIndex < 0)
			return 0;
		
		int length1 = 0;
		if(previousIndex ==-1 || nums[currentIndex] < nums[previousIndex])
			length1 = 1 + findLDSLengthRev(nums, currentIndex-1, currentIndex);
		
		int length2 = findLDSLengthRev(nums, currentIndex-1, previousIndex);
		
		return Math.max(length1, length2);
			
	}
	
	// Using top dowm
	protected int findLBSLength_TD(int[] nums) {
	    Integer[][] lds = new Integer[nums.length][nums.length+1];
	    Integer[][] ldsRev = new Integer[nums.length][nums.length+1];

	    int maxLength = 0;
	    for(int i=0; i<nums.length; i++) {
	      int c1 = findLDSLength_TD(lds, nums, i, -1);
	      int c2 = findLDSLengthReverse_TD(ldsRev, nums, i, -1);
	      maxLength = Math.max(maxLength, c1+c2-1);
	    }

	    return maxLength;
	  }


	private int findLDSLength_TD(Integer[][] dp, int[] nums, int currentIndex, int previousIndex) {
	    if(currentIndex == nums.length)
	      return 0;
	
	    if(dp[currentIndex][previousIndex+1] == null) {
	
	      int c1 = 0;
	      if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex])
	        c1 = 1 + findLDSLength_TD(dp, nums, currentIndex+1, currentIndex);
	
	
	      int c2 = findLDSLength_TD(dp, nums, currentIndex+1, previousIndex);
	
	      dp[currentIndex][previousIndex+1] = Math.max(c1, c2);
	    }
	
	    return dp[currentIndex][previousIndex+1];
	}

	private int findLDSLengthReverse_TD(Integer[][] dp, int[] nums, int currentIndex, int previousIndex) {
	    if(currentIndex < 0)
	      return 0;
	
	    if(dp[currentIndex][previousIndex+1] == null) {
	
	      int c1 = 0;
	      if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex])
	        c1 = 1 + findLDSLengthReverse_TD(dp, nums, currentIndex-1, currentIndex);
	
	      int c2 = findLDSLengthReverse_TD(dp, nums, currentIndex-1, previousIndex);
	
	      dp[currentIndex][previousIndex+1] = Math.max(c1, c2);
	    }
	    return dp[currentIndex][previousIndex+1];
	}
	
	public static void main(String[] args) {
		
		LongestBitonicSubsequence lis = new LongestBitonicSubsequence();
		
		int[] input = { 4, 2, 3, 6, 10, 1, 12 };

		System.out.print("Input Array : "+Arrays.toString(input));
		
		System.out.print("\nLength of LBS using recursion : "
				+ lis.findLBSLength(input));
	}
}
