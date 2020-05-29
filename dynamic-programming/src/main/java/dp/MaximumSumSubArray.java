package dp;


public class MaximumSumSubArray {
	
	// Kadane's Algorithm
    protected int maxSubArray(int[] nums) {
    	
    	int sumMax = nums[0];
    	int sumLocal = nums[0];
    	
    	for(int i=1;i<nums.length;i++) {
    		sumLocal = Math.max(nums[i], sumLocal + nums[i]);
    	    sumMax = Math.max(sumMax, sumLocal);
    	}
    	return sumMax;
    }
    	
    // Dynamic Programming Approach	
	protected int maxSubArrayDP(int[] nums) {	
		
		int [] solution = new int[nums.length+1];
	    solution[0] = 0;
	
	    for (int j = 1; j <solution.length ; j++) {
	        solution[j] = Math.max(solution[j-1]+ nums[j-1], nums[j-1]);
	    }

	    int result = solution[0];
	    for (int j = 1; j <solution.length ; j++) {
	        if(result<solution[j])
	            result = solution[j];
	    }
	    return result;        
    }
    
	public static void main(String []args) {
		
		MaximumSumSubArray ms = new MaximumSumSubArray();
		int [] input = {-2,1,-3,4,-1,2,1,-5,4};
		int output = ms.maxSubArray(input);
		System.out.println(output);		
	}
}
