package dp;

public class LongestCommonSubstring {
	
	// Recursion 
	protected int getLCSCount(String strOne, String strTwo, int i, int j, int count) {
		
		// Base Condition
		if(i == strOne.length() || j== strTwo.length())
			return count;

		if(strOne.charAt(i) == strTwo.charAt(j))
			count = getLCSCount(strOne, strTwo, i+1, j+1, count+1);
		
		count = Math.max(count, Math.max(getLCSCount(strOne, strTwo ,i, j+1, 0), 
				getLCSCount(strOne, strTwo ,i+1, j, 0))); 
	
		return count ;
		
	}
	
	// Top-Down Approach
	protected int getLCSCount_TD(String strOne, String strTwo) {
		
		int dp[][] =  new int[strOne.length()][strTwo.length()];
		
		Integer [][][] a = new Integer[strOne.length()][strTwo.length()][strOne.length()];
		
		for (int i = 0; i < strOne.length(); i++)
			for (int j = 0; j < strTwo.length(); j++)
				dp[i][j] = -1;
		return getLCSCountUtil(a, strOne, strTwo, 0, 0, 0);
	}

	private int getLCSCountUtil( Integer [][][]dp, String strOne, String strTwo, int indexOne, int indexTwo, int count) {
				
		if(indexOne == strOne.length() || indexTwo == strTwo.length())
			return count;
		
		if(dp[indexOne][indexTwo][count] != null)
			return dp[indexOne][indexTwo][count];
		
		int countOne = count;

		if(strOne.charAt(indexOne) == strTwo.charAt(indexTwo)) {
			countOne = getLCSCountUtil(dp, strOne, strTwo, indexOne+1, indexTwo+1, count+1);	

		} 			

		int countTwo = getLCSCountUtil(dp, strOne, strTwo ,indexOne, indexTwo+1, 0);
		int countThree = getLCSCountUtil(dp, strOne, strTwo, indexOne+1, indexTwo, 0);
	
		dp[indexOne][indexTwo][count] = Math.max(countOne, Math.max(countTwo, countThree));
		return dp[indexOne][indexTwo][count];			
	}
	
	protected int findMinimumDeletions(int[] nums){
		return nums.length - findLISLength(nums);
	}

	private int findLISLength(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		
		int maxLength = 1;
		for (int i=1; i<nums.length; i++) {
		  dp[i] = 1;
		  for (int j=0; j<i; j++)
		    if (nums[i] > nums[j] && dp[i] <= dp[j] ) {
		      dp[i] = dp[j]+1;
		      maxLength = Math.max(maxLength, dp[i]);
		    }
		}
		return maxLength;
	 }
	
	public static void main(String[] args) {
		
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		String inputStrOne = "Thistableismine";
		String inputStrTwo = "ismine";

		System.out.print("Length of Longest Common Subsequence in "
				+inputStrOne
				+" and "
				+inputStrTwo
				+" using recursion : "
				+lcs.getLCSCount(inputStrOne,inputStrTwo, 0, 0, 0));	
		
		System.out.print("\nLength of Longest Common Subsequence in "
				+inputStrOne
				+" and "
				+inputStrTwo
				+" using Top Down : "
				+lcs.getLCSCount_TD(inputStrOne,inputStrTwo));	
		
	}
}
