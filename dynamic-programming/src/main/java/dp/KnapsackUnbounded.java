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
			profitOne = profit[index] + getMaxProfitUtil(dp, profit, weight, capacity - weight[index], index);
		
		int profitTwo = getMaxProfitUtil(dp, profit, weight, capacity, index+1);
		
		dp[index][capacity] = Math.max(profitOne, profitTwo);
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
					profitOne = profit[i]  + dp[i][j-weight[i]];	
				
				profitTwo = dp[i-1][j];
				
				dp[i][j] = Math.max(profitOne, profitTwo);
			}
		}
		return dp[profit.length-1][capacity];		
	}
	
	// Given an infinite supply of ‘n’ coin denominations and a total money amount, 
	// find the total number of distinct ways to make up that amount
	// Using Recursion
	protected int countCoinChange(int []denominations, int total) {
		return countCoinChangeUtil(denominations, total, 0);
	}
	
	protected int countCoinChangeUtil(int []denominations, int total, int index) {
		
		if(total == 0)
			return 1;
		
		if(denominations.length == 0 || index >= denominations.length)
			return 0;
		
		int sum1 = 0;
		if(denominations[index] <= total)
			sum1 = countCoinChangeUtil(denominations, total - denominations[index], index);
		
		int sum2 = countCoinChangeUtil(denominations, total, index+1);
		
		return sum1 + sum2;
	}
	
	// Using Top-down
	protected int countCoinChange_TD(int []denominations, int total) {
		Integer [][]dp = new Integer[denominations.length][total+1];
		return countCoinChangeUtil_TD(dp, denominations, total, 0);
	}
	
	protected int countCoinChangeUtil_TD(Integer[][] dp,int []denominations, int total, int index) {
		
		if(total == 0)
			return 1;
		
		if(denominations.length == 0 || index >= denominations.length)
			return 0;
		
		if(dp[index][total] ==  null) {
			int sum1 = 0;
			if(denominations[index] <= total)
				sum1 = countCoinChangeUtil_TD(dp, denominations, total - denominations[index], index);
			
			int sum2 = countCoinChangeUtil_TD(dp, denominations, total, index+1);
			
			dp[index][total] = sum1 + sum2;
		}
		
		return dp[index][total];
	}
	
	public static void main(String[] args) {
		
		KnapsackUnbounded ks = new KnapsackUnbounded();
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
		
		int[] denominations = {1, 2, 3};
	    System.out.println(ks.countCoinChange(denominations, 5));
	    System.out.println(ks.countCoinChange_TD(denominations, 5));
	
	}
}
