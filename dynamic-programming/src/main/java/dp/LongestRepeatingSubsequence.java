package dp;

public class LongestRepeatingSubsequence {
	
	// Recursion 
	protected int getLRSCount(String strOne, String strTwo, int i, int j) {
		
		// Base Condition
		if(i == strOne.length() || j== strTwo.length())
			return 0;
		
		int c1 = 0;
		if((strOne.charAt(i) == strTwo.charAt(j)) && (i != j))
			c1 = 1 + getLRSCount(strOne, strTwo, i+1, j+1);
		
		int c2 = getLRSCount(strOne, strTwo, i+1, j);
		int c3 = getLRSCount(strOne, strTwo, i, j+1);
		
		return Math.max(c1, Math.max(c2, c3));
		
	}
	
	// Top Down Approach 
	protected int getLRSCount_TD(Integer [][]dp, String strOne, String strTwo, int i, int j) {
		
		// Base Condition
		if(i == strOne.length() || j== strTwo.length())
			return 0;
		
		if(dp[i][j] != null)
			return dp[i][j];
		
		int c1 = 0;
		if((strOne.charAt(i) == strTwo.charAt(j)) && (i != j))
			c1 = 1 + getLRSCount_TD(dp,strOne, strTwo, i+1, j+1);
		
		int c2 = getLRSCount_TD(dp,strOne, strTwo, i+1, j);
		int c3 = getLRSCount_TD(dp,strOne, strTwo, i, j+1);
		
		dp[i][j] = Math.max(c1, Math.max(c2, c3));
		return dp[i][j];
		
	}
	
	public static void main(String[] args) {
		
		LongestRepeatingSubsequence lcs = new LongestRepeatingSubsequence();
		String inputStrOne = "ATACTCGGAATACTCG";
		Integer [][]dp = new Integer[inputStrOne.length()][inputStrOne.length()];
		
		System.out.print("Length of Longest Repeating Subsequence in "
				+inputStrOne
				+" using top down : "
				+lcs.getLRSCount_TD(dp, inputStrOne,inputStrOne, 0 , 0));

		System.out.print("\nLength of Longest Repeating Subsequence in "
				+inputStrOne
				+" using recursion : "
				+lcs.getLRSCount(inputStrOne,inputStrOne, 0 , 0));	
		
	}
}
