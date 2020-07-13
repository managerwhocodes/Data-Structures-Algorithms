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
		
	}
}
