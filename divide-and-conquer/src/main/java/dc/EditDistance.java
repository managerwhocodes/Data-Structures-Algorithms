package dc;

public class EditDistance {
	
	protected int getMinOperationstoConvert(String strOne, String strTwo) {
		
		return getMinOperationstoConvertUtil(strOne, strTwo, 0, 0);		
	}

	private int getMinOperationstoConvertUtil(String strOne, String strTwo, int indexOne, int indexTwo) {
				
		if(indexOne == strOne.length())
			return strTwo.length() - indexTwo;
		
		if(indexTwo == strTwo.length())
			return strOne.length() - indexOne;
		
		if(strOne.charAt(indexOne) == strTwo.charAt(indexTwo))
			return getMinOperationstoConvertUtil(strOne, strTwo, indexOne+1, indexTwo+1);
		
		int insertCount = 1	+ getMinOperationstoConvertUtil(strOne, strTwo, indexOne+1, indexTwo);
		int deleteCount = 1	+ getMinOperationstoConvertUtil(strOne, strTwo, indexOne, indexTwo+1);
		int replaceCount = 1 + getMinOperationstoConvertUtil(strOne, strTwo, indexOne+1, indexTwo+1);
		
		return Math.min(insertCount, Math.min(deleteCount, replaceCount));		
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
							+dis.getMinOperationstoConvert(inputStrOne,inputStrTwo));	
	}
}
