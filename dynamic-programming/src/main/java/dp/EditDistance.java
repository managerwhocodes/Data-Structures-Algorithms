package dp;

public class EditDistance {
	
	// Top-Down Approach
	protected int getMinOperationstoConvert_TD(String strOne, String strTwo) {
		Integer [][]dp = new Integer[strOne.length()+1][strTwo.length()+1];
		return getMinOperationstoConvertUtil(dp, strOne, strTwo, 0, 0);		
	}

	private int getMinOperationstoConvertUtil(Integer [][]dp, String strOne, String strTwo, int indexOne, int indexTwo) {
		if(dp[indexOne][indexTwo] == null) {
			
			if(indexOne == strOne.length()) 
				dp[indexOne][indexTwo] = strTwo.length() - indexTwo;
			
			else if(indexTwo == strTwo.length())
				dp[indexOne][indexTwo] = strOne.length() - indexOne;
			
			else if(strOne.charAt(indexOne) == strTwo.charAt(indexTwo))
				dp[indexOne][indexTwo] =  getMinOperationstoConvertUtil(dp, strOne, strTwo, indexOne+1, indexTwo+1);
			
			else {
			
				int insertCount = 1	+ getMinOperationstoConvertUtil(dp, strOne, strTwo, indexOne+1, indexTwo);
				int deleteCount = 1	+ getMinOperationstoConvertUtil(dp ,strOne, strTwo, indexOne, indexTwo+1);
				int replaceCount = 1 + getMinOperationstoConvertUtil(dp, strOne, strTwo, indexOne+1, indexTwo+1);
				
				dp[indexOne][indexTwo] = Math.min(insertCount, Math.min(deleteCount, replaceCount));		
			}
		}
		return dp[indexOne][indexTwo];
	}
	
	// Bottom-Up Approach
	protected int getMinOperationstoConvert_BU(String strOne, String strTwo) {
		Integer [][]dp = new Integer[strOne.length()+1][strTwo.length()+1];
		
		for(int i = 0; i <= strOne.length(); i++) {
			dp[i][0]  = i;
		}
		
		for(int i = 0; i <= strTwo.length(); i++) {
			dp[0][i] = i;
		}
		
		for(int i = 1; i <= strOne.length(); i++) {
			for(int j = 1; j <= strTwo.length(); j++) {
				if(strOne.charAt(i-1) == strTwo.charAt(j-1)) {
					dp[i][j] =  dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]));
				}
			}
		}	
		return dp[strOne.length()][strTwo.length()];	
	}
	
	public static void main(String[] args) {
		
		EditDistance dis = new EditDistance();
		String inputStrOne = "table";
		String inputStrTwo = "tale";
		
		System.out.print("Minimum number of operations to convert "
							+inputStrTwo
							+" to "
							+inputStrOne
							+" using top down : "
							+dis.getMinOperationstoConvert_TD(inputStrOne,inputStrTwo));
		
		System.out.print("\nMinimum number of operations to convert "
				+inputStrTwo
				+" to "
				+inputStrOne
				+" using bottom up : "
				+dis.getMinOperationstoConvert_BU(inputStrOne,inputStrTwo));
	}
}
