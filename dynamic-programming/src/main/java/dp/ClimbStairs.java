package dp;

public class ClimbStairs {
	 
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
		int [] cost  = {100 , 15, 30, 25, 5, 30};
		ClimbStairs sol = new ClimbStairs();
		System.out.println(sol.minCostClimbingStairs(cost));		
	}
}
