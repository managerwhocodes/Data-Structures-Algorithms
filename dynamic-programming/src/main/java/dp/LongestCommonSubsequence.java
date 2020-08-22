package dp;

public class LongestCommonSubsequence {
	
	// Recursion 
	protected int getLCSCount(String strOne, String strTwo, int i, int j) {
		
		// Base Condition
		if(i == strOne.length() || j== strTwo.length())
			return 0;
		
		int c1 = 0;
		if(strOne.charAt(i) == strTwo.charAt(j))
			c1 = 1 + getLCSCount(strOne, strTwo, i+1, j+1);
		
		int c2 = getLCSCount(strOne, strTwo, i+1, j);
		int c3 = getLCSCount(strOne, strTwo, i, j+1);
		
		return Math.max(c1, Math.max(c2, c3));
		
	}
	
	// Top-Down Approach
	protected int getLCSCount_TD(String strOne, String strTwo) {
		
		Integer dp[][] =  new Integer[strOne.length()][strTwo.length()];
		return getLCSCountUtil(dp, strOne, strTwo, 0, 0);
	}

	private int getLCSCountUtil(Integer [][]dp, String strOne, String strTwo, int indexOne, int indexTwo) {
				
		if(indexOne == strOne.length() || indexTwo == strTwo.length())
			return 0;
		
		if(dp[indexOne][indexTwo] == null) {
			if(strOne.charAt(indexOne) == strTwo.charAt(indexTwo)) {
				dp[indexOne][indexTwo] = 1 + getLCSCountUtil(dp, strOne, strTwo, indexOne+1, indexTwo+1);
			} else {
				int moveStrTwoCount = getLCSCountUtil(dp, strOne, strTwo, indexOne, indexTwo+1);
				int moveStrOneCount = getLCSCountUtil(dp, strOne, strTwo, indexOne+1, indexTwo);
				dp[indexOne][indexTwo] =  Math.max(moveStrOneCount, moveStrTwoCount);	
			}
		}
		return dp[indexOne][indexTwo];	
	}
	
	// Bottom-Up Approach
	/*
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
	*/
	
	protected int getLCSCount_BU(String strOne, String strTwo) {
		
	    int[][] dp = new int[strOne.length()+1][strTwo.length()+1];
	    for(int i=1; i <= strOne.length(); i++) {
	    	for(int j=1; j <= strTwo.length(); j++) {
	    		if(strOne.charAt(i-1) == strTwo.charAt(j-1))
	    			dp[i][j] = 1 + dp[i-1][j-1];
	    		else
	    			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	        }
	    }
	    return dp[strOne.length()][strTwo.length()];
	}
	
	protected String printLCS(String one, String two) {
		
		int dp[][] = new int[one.length()+1][two.length()+1];
		for(int i=1; i<=one.length(); i++) {
			for(int j=1; j<=two.length(); j++) {
				if(one.charAt(i-1) == two.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int i = one.length();
		int j = two.length();
		int count = dp[i][j];
		char []lcs = new char[count+1];
		
		while(i>0 && j>0) {
			
			if(one.charAt(i-1) == two.charAt(j-1)) {
				lcs[count-1] = one.charAt(i-1);	
				i--;
				j--;
				count--;
			} else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			} else {
				j--;
			}
				
		}
		
		return new String(lcs);		
	}
	
	// Recursion 
	protected int getSCSCount(String strOne, String strTwo, int i, int j) {
		
		// Base Condition
		if(i == strOne.length())
			return strTwo.length()-j;
		if(j == strTwo.length())
			return strOne.length()-i;
		
		if(strOne.charAt(i) == strTwo.charAt(j))
			return 1 + getSCSCount(strOne, strTwo, i+1, j+1);
		
		int c2 = 1 +getSCSCount(strOne, strTwo, i+1, j);
		int c3 = 1+ getSCSCount(strOne, strTwo, i, j+1);
		
		return Math.min(c2, c3);
		
	}
	
	protected int getSCSCount_BU(String strOne, String strTwo) {
		
	    int[][] dp = new int[strOne.length()+1][strTwo.length()+1];
	    
	    for(int i=0; i<=strOne.length(); i++)
	    	dp[i][0] = i;
	    
	    for(int j=0; j<=strTwo.length(); j++)
	    	dp[0][j] = j;
	    
	    for(int i=1; i <= strOne.length(); i++) {
	    	for(int j=1; j <= strTwo.length(); j++) {
	    		if(strOne.charAt(i-1) == strTwo.charAt(j-1))
	    			dp[i][j] = 1 + dp[i-1][j-1];
	    		else
	    			dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
	        }
	    }
	    return dp[strOne.length()][strTwo.length()];
	}
	
	public static void main(String[] args) {
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String inputStrOne = "Thistableismine";
		String inputStrTwo = "ismine";

		System.out.print("Length of Longest Common Subsequence in "
				+inputStrOne
				+" and "
				+inputStrTwo
				+" using recursion : "
				+lcs.getLCSCount(inputStrOne,inputStrTwo, 0 , 0));	
		
		System.out.print("\nLength of Longest Common Subsequence in "
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
		
		System.out.print("\nLongest Common Subsequence : "
				+lcs.printLCS(inputStrOne,inputStrTwo));
		
		System.out.print("\nLength of Shortest Common Supersequence using Recursion : "
				+lcs.getSCSCount("dynamic","programming", 0 , 0));
		
		System.out.print("\nLength of Shortest Common Supersequence using Bottom-up : "
				+lcs.getSCSCount_BU("dynamic","programming"));
		
	}
}
