package dp;

public class KnapsackUnbounded {
	
	// Using recursion
	protected int getMaxProfit(int []profit, int []weights, int capacity, int index) {
		
		// Base conditions
		if(capacity <= 0 || index < 0 || index >= profit.length)
			return 0;
		
		int profitOne = 0;
		
		if(weights[index] <= capacity) 
			profitOne = profit[index] + getMaxProfit(profit, weights, capacity-weights[index], index);
			
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
	
	public static void main(String[] args) {
		
		KnapsackUnbounded ks = new KnapsackUnbounded();
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
		
		
	}
}