package array;

public class TwoPointer {

	protected int[] findPairWithTargetSum(int input[], int targetSum) {
		
		if(input.length == 0)
			throw new IllegalArgumentException("Invalid input");
		
		int left = 0;
		int right = input.length-1;
		
		while(left < right) {
			int currentSum = input[left] + input[right];
			if(currentSum == targetSum) {
				return new int[] {left, right};
			}
			
			if(targetSum > currentSum)
				left++;
			else
				right--;
		}
		return new int[] {-1,-1};
	}
	
	protected int removeDuplicates(int []input) {
		
		int nextNonDuplicate = 1;
		
		for(int i=1; i<input.length; i++) {
			if (input[nextNonDuplicate-1] != input[i]) {
				input[nextNonDuplicate] = input[i];
				nextNonDuplicate++;
	    	}
		}

		return nextNonDuplicate;
	}
	
	
	protected int removeAllOccurencesOfK(int []input , int k) {
		
		int nextElement = 0;
		
		for(int i=0; i<input.length; i++) {
			if (input[i] != k) {
				input[nextElement] = input[i];
				nextElement++;
	    	}
		}
			
		return nextElement;
	}

	public static void main(String[] args) {
		TwoPointer tp = new TwoPointer();
		
		int []input = { 1, 2, 3, 4, 6 };
		
		int[] result = tp.findPairWithTargetSum(input, 6);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
		
	    System.out.println(tp.removeDuplicates(new int[] { 2, 2, 2, 11 }));
	    System.out.println(tp.removeAllOccurencesOfK(new int[] { 2, 11, 2, 2, 1}, 2));
	}

}
