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
	
	public static void main(String[] args) {
		
		EditDistance dis = new EditDistance();
		String inputStrOne = "table";
		String inputStrTwo = "tale";
		
		System.out.print("Minimum number of operations to convert "
							+inputStrTwo
							+" to "
							+inputStrOne
							+" : "
							+dis.getMinOperationstoConvert_TD(inputStrOne,inputStrTwo));	
	}
}
