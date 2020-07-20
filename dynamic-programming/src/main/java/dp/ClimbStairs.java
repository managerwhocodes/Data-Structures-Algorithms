package dp;

public class ClimbStairs {
	
	
	// Using Recursion
	public int wayToReachTop(int stairs) {
		
		if(stairs <= 0)
			return 1;
		
		return wayToReachTop(stairs-1) + wayToReachTop(stairs-2);
	}
	
	// Using Top Down
	public int wayToReachTopTD(int stairs, int dp[], int i) {
		
		if(stairs <= 0)
			return 1;
		
		if(dp[i] !=0)
			return dp[i];
		
		dp[i] = wayToReachTopTD(stairs-1, dp, i+1) + wayToReachTopTD(stairs-2, dp, i+2);
		
		return dp[i];
	}
	
	// Using Recursion
    public int minCostClimbingStairs(int [] cost, int i,int min) {
    	
    	if(i < 0  || cost.length<=1)
    		return 0;
    	
    	if(i >= cost.length)
    		return 0;

    	if(i+1 == cost.length)
    		return min;
 	
    	if(cost[i]<cost[i+1])  	
   	   		min = cost[i]  + minCostClimbingStairs(cost ,i+1,min);  	   	
    	else
    		min = cost[i+1] + minCostClimbingStairs(cost ,i+2,min);
   	
		return min;
    }
	 
    // Using Top Down - space optimised
    public int minCostClimbingStairs(int [] cost) {
    	
   	   	int stepZero = 0;
   	   	int stepOne = 0;
   	   		   	
   	   	for(int i=0;i<cost.length;i++) { 	
   	   		
   	   		int minCost = Math.min(stepZero , stepOne) + cost[i];
   	   		
   	   		stepZero=stepOne;
   	   		stepOne=minCost;   	   		   	   		   	   		
   	   	}  	   	
		return Math.min(stepZero,stepOne);		
    }

	public static void main(String[] args) {
		
		int stairs = 10;
		int [] cost  = {100, 15, 30, 25, 5, 30, 2, 90, 6, 1};
		
		ClimbStairs sol = new ClimbStairs();
		
		int dp[] = new int[stairs];
		
		System.out.println("Ways to reach top using recussion : "+sol.wayToReachTop(stairs));
		System.out.println("Ways to reach top using Top Down : "+sol.wayToReachTopTD(stairs,dp,0));
		
		System.out.println("Minimum cost to reach top using recussion : "+sol.minCostClimbingStairs(cost,0,0));
		System.out.println("Minimum cost to reach top using top down : "+sol.minCostClimbingStairs(cost));	
		
	}
}
