package dc;

public class LongestPalindromicSubstring {
	
	protected int getLPSCount(String string) {
		
		return getLPSCountUtil(string, 0, string.length()-1);		
	}

	private int getLPSCountUtil(String string, int startIndex, int endIndex) {
				
		if(startIndex > endIndex)
			return 0;
		
		if(startIndex == endIndex)
			return 1;
		
		if(string.charAt(startIndex) == string.charAt(endIndex)) {
			int remainingLength  = endIndex - startIndex - 1;
			if(remainingLength ==  getLPSCountUtil(string, startIndex+1, endIndex-1))
				return 2 + remainingLength;
		}
			
		int moveHeadCount = getLPSCountUtil(string, startIndex+1, endIndex);
		int moveTailCount = getLPSCountUtil(string, startIndex, endIndex-1);
		
		return Math.max(moveHeadCount, moveTailCount);	
	}
	
	public static void main(String[] args) {
		
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String inputStrOne = "thistableismine";
		
		System.out.println("Length of Longest Palindromic Substring in "
							+inputStrOne
							+" : "
							+lps.getLPSCount(inputStrOne));	
		
		
		String inputStrTwo = "testthetest";
		
		System.out.println("Length of Longest Palindromic Substring in "
							+inputStrTwo
							+" : "
							+lps.getLPSCount(inputStrTwo));	
	}
}
