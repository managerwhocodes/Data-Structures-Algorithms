package dp;

public class KnapsackZeroOne {
	
	// Using recursion
	protected int getMaxProfit(int []profit, int []weights, int capacity, int index) {
		
		// Base conditions
		if(capacity <= 0 || index < 0 || index >= profit.length)
			return 0;
		
		int profitOne = 0;
		
		if(weights[index] <= capacity) 
			profitOne = profit[index] + getMaxProfit(profit, weights, capacity-weights[index], index+1);
			
		int profitTwo = getMaxProfit(profit, weights, capacity, index+1);
		
		return Math.max(profitOne, profitTwo);
	}
		
	// Top-Down Approach
	protected int getMaxProfit_TD(int []profit, int []weight, int capacity) {
		Integer[][] dp = new Integer[profit.length][capacity + 1];
		return getMaxProfitUtil(dp, profit, weight, capacity, 0);
	}

	private int getMaxProfitUtil(Integer[][] dp, int []profit, int []weight, int capacity, int index) {
		
		if(capacity <=0 || index < 0 || index >= profit.length)
			return 0;

		if (dp[index][capacity] == null) {
			int profitOne = 0;
			if(weight[index] <= capacity)
				profitOne = profit[index] + getMaxProfitUtil(dp, profit, weight, capacity - weight[index], index+1);
			
			int profitTwo = getMaxProfitUtil(dp, profit, weight, capacity, index+1);
			
			dp[index][capacity] = Math.max(profitOne, profitTwo);
		}
		return dp[index][capacity];
	}
	
	// Bottom-up Approach
	protected int getMaxProfit_BU(int []profit, int []weight, int capacity) {
		
		if(capacity <=0 || profit.length ==0 || weight.length != profit.length )
			return 0;
		
		int dp[][] = new int[profit.length][capacity+1];
		
		for(int i=0; i < profit.length; i++)
		      dp[i][0] = 0;
		
	    for(int c=0; c <= capacity; c++) {
		      if(weight[0] <= c)
		        dp[0][c] = profit[0];
		}
		
		for(int i=1;i<profit.length;i++) {
			for(int j=1;j<=capacity;j++) {
				int profitOne = 0 , profitTwo = 0;
				if(weight[i] <= j)
					profitOne = profit[i]  + dp[i-1][j-weight[i]];	
				
				profitTwo = dp[i-1][j];
				
				dp[i][j] = Math.max(profitOne, profitTwo);
			}
		}
		return dp[profit.length-1][capacity];		
	}
	
	
	// Using recursion
	protected boolean isSubsetSum(int []arr, int sum, int index) {
		
		if(sum == 0)
			return true;
		
		// Base condition
		if(arr.length == 0 || index >= arr.length)
			return false;
		
		if(arr[index] <= sum) {
			if(isSubsetSum(arr, sum-arr[index], index+1))
					return true;
		}
			
		return isSubsetSum(arr, sum, index+1);
	}
	
	// Top-Down Approach
	protected boolean isSubsetSum_TD(int []arr, int sum, int index) {
		Boolean[][] dp = new Boolean[arr.length][sum + 1];
		return isSubsetSumUtil(dp, arr, sum, 0);
	}
	
	protected boolean isSubsetSumUtil(Boolean [][]dp, int []arr, int sum, int index ) {
		
		if(sum == 0 )
			return true;
		
		// Base condition
		if(arr.length == 0 || index >= arr.length)
			return false;
		
		if(dp[index][sum] == null) {
			if(arr[index] <= sum) {
				if(isSubsetSumUtil(dp, arr, sum-arr[index], index+1)) {
					dp[index][sum] = true;
					return true;
				}
			}
			dp[index][sum] = isSubsetSumUtil(dp, arr, sum, index+1);
		}
		
		return dp[index][sum];	
	}
	
	
	// Using recursion
	protected boolean canPartitionEqualSubset(int []arr) {
		
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
		}
		
		if(sum % 2 != 0)
			return false;
		
		return canPartitionEqualSubsetRecusion(arr, sum/2, 0);	
		
	}
	
	protected boolean canPartitionEqualSubsetRecusion(int []arr, int sum, int index) {
		
		// Base Condition
		if (sum == 0)
			return true;
		
		// Base Condition
		if(arr.length == 0 || index>= arr.length)
			return false;
		
		if(arr[index] <= sum) {
			if(canPartitionEqualSubsetRecusion(arr, sum-arr[index], index+1)) {
				return true;
			}
		}
		
		return canPartitionEqualSubsetRecusion(arr, sum, index+1);
		
	}
	
	// Using Top-Down
	protected boolean canPartitionEqualSubset_TD(int []arr) {
		
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
		}
		
		if(sum % 2 != 0)
			return false;
		
		Boolean [][]dp = new Boolean[arr.length][sum+1];
		return canPartitionEqualSubsetRecusion_TD(dp, arr, sum/2, 0);	
		
	}
	
	protected boolean canPartitionEqualSubsetRecusion_TD(Boolean [][]dp, int []arr, int sum, int index) {
		
		// Base Condition
		if (sum == 0)
			return true;
		
		// Base Condition
		if(arr.length == 0 || index>= arr.length)
			return false;
		
		if(dp[index][sum] == null) {
			if(arr[index] <= sum) {
				if(canPartitionEqualSubsetRecusion_TD(dp, arr, sum-arr[index], index+1)) {
					dp[index][sum] = true; 
					return true;
				}
			}
			dp[index][sum] = canPartitionEqualSubsetRecusion_TD(dp, arr, sum, index+1);
		}
		
		return dp[index][sum];	
	}
	
	// Using recursion
	protected boolean canPartitionEqualKSubset(int []arr, int k) {
		
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
		}
		
		if(sum % k != 0)
			return false;
		
		int []bucket = new int[k];
		
		return canPartitionEqualKSubsetUtil(bucket, arr, sum/k, 0);	
		
	}
	
	// Using recursion
	protected boolean canPartitionEqualKSubsetUtil(int[] bucket, int []arr, int sum , int index) {
		
		// Base condition
		if(arr.length == 0 || index>= arr.length)
		{
			for(int i = 0;i<bucket.length;i++) {
				if(bucket[i] != sum)
					return false;
			}
			return true;
		}
		
		for(int i=0 ;i<bucket.length;i++) {
			if(bucket[i] + arr[index] > sum ) {
				continue;
			}
			bucket[i] = bucket[i] + arr[index];
			if(canPartitionEqualKSubsetUtil(bucket, arr, sum, index+1)) {
				return true;
			}
			bucket[i] = bucket[i] - arr[index];
		}
		return false;
	}
		
	// Using Recursion
	private int countSubsets(int[] arr, int sum, int index) {
		
		if(sum ==0)
			return 1;
		
		if(arr.length == 0 || index>= arr.length)
			return 0;
		
		int sumOne = 0;
		if(arr[index] <= sum) {
			sumOne = countSubsets(arr, sum-arr[index], index+1);
		}
		
		int sumTwo = countSubsets(arr, sum, index+1);
		
		return sumOne + sumTwo;	
		
	}
	
	// Using Top-Down
	protected int countSubsets_TD(int[] arr, int sum, int index) {
		
		Integer [][]dp = new Integer[arr.length][sum+1];
		return countSubsetsUtil_TD(dp, arr, sum, index);	
	}
	
	private int countSubsetsUtil_TD(Integer [][]dp, int[] arr, int sum, int index) {
		
		if(sum ==0)
			return 1;
		
		if(arr.length == 0 || index>= arr.length)
			return 0;
		
		if(dp[index][sum] == null) {
			int sumOne = 0;
			if(arr[index] <= sum) {
				sumOne = countSubsets(arr, sum-arr[index], index+1);
			}
			
			int sumTwo = countSubsets(arr, sum, index+1);
			dp[index][sum] = sumOne + sumTwo;
		}
		
		return dp[index][sum];
	}
	
	// Using Recursion
	protected int canPartitionMinDiffSubset(int []arr) {
		
		return canPartitionMinDiffSubsetUtil(arr , 0 , 0 , 0);
	}
		
		
	protected int canPartitionMinDiffSubsetUtil(int []arr, int sum1, int sum2, int index) {
		
		if(index >= arr.length)
			return Math.abs(sum1-sum2);
		
		int diff1 = canPartitionMinDiffSubsetUtil(arr, sum1+arr[index], sum2, index+1);
		int diff2 = canPartitionMinDiffSubsetUtil(arr, sum1, sum2+arr[index], index+1);
		
		return Math.min(diff1, diff2);
	}
	
	// Using Top-Down
	protected int canPartitionMinDiffSubset_TD(int []arr) {
		
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			sum = sum + arr[i];
		
		Integer [][]dp = new Integer[arr.length][sum+1];
		return canPartitionMinDiffSubsetUtil_TD(dp, arr , 0 , 0 , 0);
	}
		
		
	protected int canPartitionMinDiffSubsetUtil_TD(Integer [][]dp, int []arr, int sum1, int sum2, int index) {
		
		if(index >= arr.length)
			return Math.abs(sum1-sum2);
		
		if(dp[index][sum1] == null ) {
			int diff1 = canPartitionMinDiffSubsetUtil(arr, sum1+arr[index], sum2, index+1);
			int diff2 = canPartitionMinDiffSubsetUtil(arr, sum1, sum2+arr[index], index+1);
			
			dp[index][sum1] = Math.min(diff1, diff2);
		}
		
		return dp[index][sum1];
	}
	
	// Using Recursion
	protected int countSubsetsWithGivenDiff(int[] arr, int diff) {
		
		int sum = 0;
		for(int i = 0; i<arr.length ; i++)
			sum = sum + arr[i];
		
		int sumSubset = (sum + diff)/2;
		
		return countSubsets(arr, sumSubset, 0);		
	}
	
	// Using Recursion
	protected int findTargetSubsets(int[] num, int s) {
	    
		int sum = 0;
	    for(int n : num)
	        sum += n;

	    if(sum < s || (s + sum) % 2 == 1)
	        return 0;

	    return countSubsets(num, (s + sum) / 2, 0);
	  }
	
	public static void main(String[] args) {
		
		KnapsackZeroOne ks = new KnapsackZeroOne();
		int[] profit = { 31, 26, 72, 17 };
		int[] weight = { 3, 1, 5, 2 };
		int knapsackCapacity = 7;

		System.out.print("Profit : ");
		for(int p : profit)
			System.out.print(p + "  ");
		
		System.out.print("\nWeight : ");
		for(int w : weight)
			System.out.print(w + "  ");
		
		System.out.println("\nCapacity of Knapsack : "+knapsackCapacity);
		
		System.out.println("Maxium profit using Recursion : "+ks.getMaxProfit(profit,weight,knapsackCapacity,0));
		
		System.out.println("Maxium profit using Top Down Approach : "+ks.getMaxProfit_TD(profit,weight,knapsackCapacity));
		
		System.out.println("Maxium profit using Bottom Up Approach : "+ks.getMaxProfit_BU(profit,weight,knapsackCapacity));
		
		int []num = { 1, 2, 7, 1, 5 };
	    System.out.println(ks.isSubsetSum(num, 10, 0));
	    System.out.println(ks.isSubsetSum_TD(num, 10, 0));
	    
	    System.out.println(ks.canPartitionEqualSubset(num));
	    System.out.println(ks.canPartitionEqualSubset_TD(num));
	    
	    System.out.println(ks.countSubsets(num,7,0));
	    System.out.println(ks.countSubsets_TD(num,7,0));
	    
	    int []arr = {1, 2, 7, 1, 5};
	    int k = 4;	

	    System.out.println(ks.canPartitionEqualKSubset(arr,k));
	  
	    int []input = {1, 3, 100, 4};
	    System.out.println(ks.canPartitionMinDiffSubset(input));
	    System.out.println(ks.canPartitionMinDiffSubset_TD(input));
	    
	    input = new int[]{1, 1, 2, 3};
	    System.out.println(ks.countSubsetsWithGivenDiff(input,1));
	    
	    input = new int[]{1, 2, 7, 1};
	    System.out.println(ks.findTargetSubsets(input, 9));
	          
	}
}
