package dp;

public class PartitionSet {
	
	private int sumArray(int []arr) {
		
		int sum = 0;
		
		for(int n : arr)
			sum = sum + n;
		
		return sum;
	}

	// Using recursion
	protected boolean canPartitionInTwoSubsets(int []num) {
		
		// Base condition
		if(num.length <=0)
			return false;
		
		int sum = sumArray(num);
		
		// If sum is not even then it can not be partitioned
		if(sum % 2 !=0)
			return false;
		
		return canPartition(num, sum/2, 0);	
		
	}
	
	protected boolean canPartition(int []num, int sum, int index) {
		
		// Base condition
		if(sum == 0)
			return true;
		
		// Base condition
		if(num.length == 0 || index >= num.length)
			return false;
		
		if(num[index] <= sum) {
			if(canPartition(num, sum-num[index], index+1)) {
				return true;
			}
		}		
		return canPartition(num, sum, index + 1);
	}
	
	
	// Using recursion
	protected int minDiffSubsets(int []num, int sumCalculated, int sumTotal, int index) {
		
		// Base condition
		if(num.length <= 0) {
			return 0;
		}
		
		// Base conditions
		if(index >= num.length)
			return Math.abs((sumTotal - sumCalculated) - sumCalculated);
		
		int diffOne = minDiffSubsets(num, sumCalculated+num[index], sumTotal, index+1);	
		int diffTwo = minDiffSubsets(num, sumCalculated, sumTotal, index+1);
		
		return Math.min(diffOne, diffTwo);
	}
	
	// Using recursion
	protected int noOfPartitionWithSum(int []num, int sum, int index, int count) {
		
		// Base condition
		if(num.length <= 0) {
			return 0;
		}
		
		// Base conditions
		if(index >= num.length) {
			if(sum == 0) 
				count++;
			return count;
		}
		
		count = noOfPartitionWithSum(num, sum-num[index] , index+1 , count);	
		count = noOfPartitionWithSum(num, sum , index+1, count);
		
		return count;
	}
	
	public static void main(String[] args) {
		
	    PartitionSet ps = new PartitionSet();
	    
	    int[] num = {1, 2, 3, 4};
	    System.out.println(ps.canPartitionInTwoSubsets(num));
	    
	    num = new int[]{1, 1, 3, 4, 7};
	    System.out.println(ps.canPartitionInTwoSubsets(num));
	     
	    num = new int[]{2, 3, 4, 6};
	    System.out.println(ps.canPartitionInTwoSubsets(num));
	    
	    num = new int[] {3, 1, 4, 2, 2, 1}; 
	    System.out.println(ps.minDiffSubsets(num, 0, ps.sumArray(num), 0));

	}
}
