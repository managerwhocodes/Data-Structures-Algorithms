package dp;

public class MaximumProductSubarray {
	
    protected int maxProduct(int[] nums) {
    	int prodMax = nums[0];
    	int prodLocal = nums[0];
    	
    	for(int i=1;i<nums.length;i++) {
    		prodLocal = Math.max(nums[i], prodLocal * nums[i]);
    		prodMax = Math.max(prodMax, prodLocal);
    	}	
    	return prodMax;      
    }
    
	public static void main(String []args) {
		MaximumProductSubarray mp = new MaximumProductSubarray();
		int [] input = {-2,0,-1};
		int output = mp.maxProduct(input);
		System.out.println(" Maximum product of subarray : "+output);	
	}
}
