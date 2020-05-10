package dp;

public class LongestCommonSubsequence {
	
	// Top-Down Approach
	protected int getLCSCount_TD(String strOne, String strTwo) {
		
		int dp[][] =  new int[strOne.length()][strTwo.length()];
		for (int i = 0; i < strOne.length(); i++)
			for (int j = 0; j < strTwo.length(); j++)
				dp[i][j] = -1;
		return getLCSCountUtil(dp, strOne, strTwo, 0, 0);
	}

	private int getLCSCountUtil(int [][]dp, String strOne, String strTwo, int indexOne, int indexTwo) {
				
		if(indexOne == strOne.length() || indexTwo == strTwo.length())
			return 0;
		
		if(dp[indexOne][indexTwo] == -1) {
			if(strOne.charAt(indexOne) == strTwo.charAt(indexTwo)) {
				dp[indexOne][indexTwo] = 1 + getLCSCountUtil(dp, strOne, strTwo, indexOne+1, indexTwo+1);
				return dp[indexOne][indexTwo];	
			} else {
				int moveStrTwoCount = getLCSCountUtil(dp, strOne, strTwo, indexOne, indexTwo+1);
				int moveStrOneCount = getLCSCountUtil(dp, strOne, strTwo, indexOne+1, indexTwo);
				dp[indexOne][indexTwo] =  Math.max(moveStrOneCount, moveStrTwoCount);	
			}
		}
		return dp[indexOne][indexTwo];	
	}
	
	// Bottom-Up Approach
	protected int getLCSCount_BU(String strOne, String strTwo) {
		
		int dp[][] =  new int[strOne.length()+1][strTwo.length()+1];
		for (int i = strOne.length(); i >= 1; i--) {
			for (int j = strTwo.length(); j >= 1; j--) {
				if(strOne.charAt(i-1) == strTwo.charAt(j-1)) {
					dp[i-1][j-1] = Math.max((1+ dp[i][j]), Math.max(dp[i][j-1], dp[i-1][j]));
				} else {
					dp[i-1][j-1] = Math.max(dp[i][j-1], dp[i-1][j]);
				}			
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String inputStrOne = "Thistableismine";
		String inputStrTwo = "ismine";
		
		System.out.print("Length of Longest Common Subsequence in "
							+inputStrOne
							+" and "
							+inputStrTwo
							+" using Top Down : "
							+lcs.getLCSCount_TD(inputStrOne,inputStrTwo));	
		
		System.out.print("\nLength of Longest Common Subsequence in "
				+inputStrOne
				+" and "
				+inputStrTwo
				+" using Bottom Up : "
				+lcs.getLCSCount_BU(inputStrOne,inputStrTwo));
	}
}
