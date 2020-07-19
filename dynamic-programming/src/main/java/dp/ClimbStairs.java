package dp;

public class ClimbStairs {
	
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
		int [] cost  = {100 , 15, 30, 25, 5, 30, 2, 90, 6, 1, 1 ,1};
		ClimbStairs sol = new ClimbStairs();
		System.out.println(sol.minCostClimbingStairs(cost));	
		
		System.out.println(sol.minCostClimbingStairs(cost,0,0));
	}
}
