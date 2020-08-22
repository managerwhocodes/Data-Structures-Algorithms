package dp;

import java.util.HashSet;
import java.util.Set;

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
		return getMaxProfitUtil_TD(dp, profit, weight, capacity, 0);
	}

	private int getMaxProfitUtil_TD(Integer[][] dp, int []profit, int []weight, int capacity, int index) {
		
		if(capacity <=0 || index < 0 || index >= profit.length)
			return 0;

		if (dp[index][capacity] != null)
			return dp[index][capacity];
		
		int profitOne = 0;
		if(weight[index] <= capacity)
			profitOne = profit[index] + getMaxProfitUtil_TD(dp, profit, weight, capacity - weight[index], index);
		
		int profitTwo = getMaxProfitUtil_TD(dp, profit, weight, capacity, index+1);
		
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
				
		for(int i=0; i<profit.length; i++) {
			for(int j=1; j<=capacity; j++) {
				int profitOne = 0 , profitTwo = 0;
				
				if(weight[i] <= j)
					profitOne = profit[i]  + dp[i][j-weight[i]];	
				
				if( i > 0 )
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
	
	// Bottom-up Approach
	protected int countCoinChange_BU(int []denominations, int total) {
		
		int n = denominations.length;
		int [][]dp = new int[n][total+1];
		
		for(int i =0;i<n;i++)
			dp[i][0] = 1;
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<=total;j++) {
				int sum1 = 0, sum2 = 0;
				if(denominations[i] <= j)
					sum1 = dp[i][j-denominations[i]];
				if(i>0)
					sum2 = dp[i-1][j];
				
				dp[i][j] = sum1 + sum2;
			}
		}
		return dp[n-1][total];
	}	
	
	// Using Recursion
	protected int getMinCoinChange(int[] denominations, int total) {
	    int result = getMinCoinChangeUtil(denominations, total, 0);
	    return (result == Integer.MAX_VALUE ? -1 : result);
	}
	
	public int getMinCoinChangeUtil(int[] denominations, int total, int index) {
		
		if(total == 0)
			return 0;
		
		if(denominations.length ==0 || index >= denominations.length)
			return Integer.MAX_VALUE;
		
		int countOne = Integer.MAX_VALUE;
		if(denominations[index] <= total) {
			int res = getMinCoinChangeUtil(denominations,total - denominations[index],index);
			if(res != Integer.MAX_VALUE)
				countOne = res  + 1 ;
		}
		
		int countTwo = getMinCoinChangeUtil(denominations, total, index+1);
		
		return Math.min(countOne, countTwo);	
	}
	
	// Using Top-down
	protected int getMinCoinChange_TD(int[] denominations, int total) {
		Integer [][]dp = new Integer[denominations.length][total+1];
	    int result = getMinCoinChangeUtil_TD(dp, denominations, total, 0);
	    return (result == Integer.MAX_VALUE ? -1 : result);
	}
	
	private int getMinCoinChangeUtil_TD(Integer[][]dp, int[] denominations, int total, int index) {
		
		if(total == 0)
			return 0;
		
		if(denominations.length ==0 || index >= denominations.length)
			return Integer.MAX_VALUE;
		
		if(dp[index][total] == null) {
			int countOne = Integer.MAX_VALUE;
			if(denominations[index] <= total) {
				int res = getMinCoinChangeUtil(denominations,total - denominations[index],index);
				if(res != Integer.MAX_VALUE)
					countOne = res  + 1 ;
			}
			
			int countTwo = getMinCoinChangeUtil(denominations, total, index+1);
			dp[index][total] = Math.min(countOne, countTwo);
		}
		
		return dp[index][total];
	}
	
	// Using recursion
	protected int getMinTicketCost(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int day : days) {
            set.add(day);
        }
		return getMinTicketCostUtil(set,costs,365);
	}
	
	protected int getMinTicketCostUtil(Set<Integer> days, int[] costs, int day) {
		
		// Base conditions
		if(day < 0)
			return 0;
		
		int profitOne = 0;
		
		if(days.contains(day)) {
			int one = costs[0] + getMinTicketCostUtil(days, costs, day-1);
			int two = costs[1] + getMinTicketCostUtil(days, costs, day-7);
			int three = costs[2] + getMinTicketCostUtil(days, costs, day-30);
			profitOne = Math.min(one, Math.min(two, three));
		} 
			
		int profitTwo = getMinTicketCostUtil(days, costs, day-1);
		
		return Math.max(profitOne, profitTwo);
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
	    System.out.println(ks.countCoinChange_BU(denominations, 5));
	    System.out.println(ks.getMinCoinChange(denominations, 5));
	    System.out.println(ks.getMinCoinChange_TD(denominations, 5));
	    
	    
	    int []days = {1,2,3,4,5,6,7,8,9,10,30,31};
	    denominations = new int[]{2,7,15};
	    System.out.println(ks.getMinTicketCost(days,denominations));

	}
}
