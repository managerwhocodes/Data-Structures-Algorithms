package dp;

public class NumberFactor {
	
	// Recursive
	protected int waystoGetN(int num) {
		
		// Base conditions
		if(num == 0 || num == 1 || num == 2)
			return 1;
		
		if(num == 3)
			return 2;
		
		int waystoGetSelecting1 = waystoGetN(num-1);
		int waystoGetSelecting3 = waystoGetN(num-3);
		int waystoGetSelecting4 = waystoGetN(num-4);
		
		return (waystoGetSelecting1 + waystoGetSelecting3 + waystoGetSelecting4);
		
	}
	
	
	// Top-Down Approach
	protected int waysToGetN_TD(int num) {
		int dp[] = new int[num+1];
		return waysToGetN_TDUtil(dp,num);
	}
	
	private int waysToGetN_TDUtil(int []dp,int num) {
		
		if((num==0)||(num==1)||(num==2)) 
			return 1;
		if(num==3)
			return 2;
		if(dp[num]==0) {
			dp[num] =  waysToGetN_TDUtil(dp,num-1) + waysToGetN_TDUtil(dp,num-3) + waysToGetN_TDUtil(dp,num-4);
		}
		return dp[num];
	}
	
	// Bottom-Up Approach
	protected int waysToGetN_BU(int num) {
		int []dp = new int[num+1];
		
		dp[0] = dp[1] = dp[2] = 1;
		dp[3] = 2;

		for(int i=4;i<=num;i++)
			dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
	
		return dp[num];
	}
	

	public static void main(String[] args) {
		NumberFactor nc = new NumberFactor();
		int input = 6;
		
		System.out.println("Numbers of ways to express "+input
				+" as a sum of 1,3,4 using Top Down Approach : "+ nc.waystoGetN(input));
		
		System.out.println("Numbers of ways to express "+input
							+" as a sum of 1,3,4 using Top Down Approach : "+ nc.waysToGetN_TD(input));
		
		System.out.println("Numbers of ways to express "+input
							+" as a sum of 1,3,4 using Bottom Up Approach : "+ nc.waysToGetN_BU(input));
	}
}
