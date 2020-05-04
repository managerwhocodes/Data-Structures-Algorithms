package dc;

public class LongestCommonSubsequence {
	
	protected int getLCSCount(String strOne, String strTwo) {
		
		return getLCSCountUtil(strOne, strTwo, 0, 0);		
	}

	private int getLCSCountUtil(String strOne, String strTwo, int indexOne, int indexTwo) {
				
		if(indexOne == strOne.length() || indexTwo == strTwo.length())
			return 0;
		
		if(strOne.charAt(indexOne) == strTwo.charAt(indexTwo))
			return  1 + getLCSCountUtil(strOne, strTwo, indexOne+1, indexTwo+1);
		
		int moveStrTwoCount = getLCSCountUtil(strOne, strTwo, indexOne, indexTwo+1);
		int moveStrOneCount = getLCSCountUtil(strOne, strTwo, indexOne+1, indexTwo);
		
		return Math.max(moveStrOneCount, moveStrTwoCount);	
	}
	
	public static void main(String[] args) {
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String inputStrOne = "Thistableismine";
		String inputStrTwo = "ismine";
		
		System.out.print("Length of Longest Common Subsequence in "
							+inputStrOne
							+" and "
							+inputStrTwo
							+" : "
							+lcs.getLCSCount(inputStrOne,inputStrTwo));	
	}
}
