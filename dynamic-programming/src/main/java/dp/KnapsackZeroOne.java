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

		if (dp[index][capacity] != null)
			return dp[index][capacity];
		
		int profitOne = 0;
		if(weight[index] <= capacity)
			profitOne = profit[index] + getMaxProfitUtil(dp, profit, weight, capacity - weight[index], index+1);
		
		int profitTwo = getMaxProfitUtil(dp, profit, weight, capacity, index+1);
		
		dp[index][capacity] = Math.max(profitOne, profitTwo);
		return dp[index][capacity];
	}
	
	// Using recursion
	protected boolean isSubsetSum(int []arr, int sum, int index) {
		
		// Base condition
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
	
	public static void main(String[] args) {
		
		KnapsackZeroOne ks = new KnapsackZeroOne();
		int[] profit = { 31, 26, 72, 17 };
		int[] weight = { 3, 1, 5, 2 };
		int knapsackCapacity = 7;
		
		int maxProfit = ks.getMaxProfit_TD(profit,weight,knapsackCapacity);
		
		System.out.print("Profit : ");
		for(int p : profit)
			System.out.print(p + "  ");
		
		System.out.print("\nWeight : ");
		for(int w : weight)
			System.out.print(w + "  ");
		
		System.out.println("\nCapacity of Knapsack : "+knapsackCapacity);
		
		System.out.println("Maxium profit using Recursion : "+ks.getMaxProfit(profit,weight,knapsackCapacity,0));
		
		System.out.println("Maxium profit using Top Down Approach : "+maxProfit);
		
		int []num = { 1, 2, 7, 1, 5 };
	    System.out.println(ks.isSubsetSum(num, 10, 0));
	    System.out.println(ks.isSubsetSum_TD(num, 10, 0));
		
	}
}
