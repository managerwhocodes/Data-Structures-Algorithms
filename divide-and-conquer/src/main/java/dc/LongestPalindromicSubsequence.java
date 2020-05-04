package dc;

public class LongestPalindromicSubsequence {
	
	protected int getLPSCount(String string) {
		
		return getLPSCountUtil(string, 0, string.length()-1);		
	}

	private int getLPSCountUtil(String string, int startIndex, int endIndex) {
				
		if(startIndex > endIndex)
			return 0;
		
		if(startIndex == endIndex)
			return 1;
		
		if(string.charAt(startIndex) == string.charAt(endIndex))
			return 2 + getLPSCountUtil(string, startIndex+1, endIndex-1);
		
		int moveHeadCount = getLPSCountUtil(string, startIndex+1, endIndex);
		int moveTailCount = getLPSCountUtil(string, startIndex, endIndex-1);
		
		return Math.max(moveHeadCount, moveTailCount);	
	}
	
	public static void main(String[] args) {
		
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String inputString = "Thistableismine";
		
		System.out.print("Length of Longest Palindromic Subsequence in "
							+inputString
							+" : "
							+lps.getLPSCount(inputString));	
	}
}
