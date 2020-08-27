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

	public static void main(String[] args) {
		TwoPointer tp = new TwoPointer();
		
		int[] result = tp.findPairWithTargetSum(new int[] { 1, 2, 3, 4, 6 }, 6);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	}

}
