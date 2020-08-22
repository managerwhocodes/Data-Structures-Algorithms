package dp;

public class HouseThief {
	
	// Using Recursion
	public int maxMoney(int[] wealth) {
		return maxMoneyUtil(wealth, 0);
	}

	private int maxMoneyUtil(int[] wealth, int index) {
		  
	    if( index >= wealth.length)
	      return 0;
	
	    // steal from current house and skip one to steal from the next house
	    int stealCurrent = wealth[index] + maxMoneyUtil(wealth, index + 2);
	    
	    // skip current house to steel from the adjacent house
	    int skipCurrent = maxMoneyUtil(wealth, index + 1);
	
	    return Math.max(stealCurrent, skipCurrent);
	}
	
	// Top-Down Approach
	protected int maxMoney_TD(int []totalHouseMoney , int index) {
		
		int dp[]  = new int[totalHouseMoney.length];	
		return maxMoneyUtil_TD(dp, totalHouseMoney, index);
	}

	private int maxMoneyUtil_TD(int []dp, 	int []totalHouseMoney , int index) {
		
		if(index >= totalHouseMoney.length)
			return 0;
		
		if(dp[index] == 0) {
			int stealCurrentHouse = totalHouseMoney[index] + maxMoneyUtil_TD(dp,totalHouseMoney, index+2);
			int skipCurrentHouse = maxMoneyUtil_TD(dp,totalHouseMoney, index+1);
			dp[index] = Math.max(stealCurrentHouse, skipCurrentHouse);
		}
		
		return dp[index];
	}
	
	// Bottom-Up Approach
	protected int maxMoney_BU(int []totalHouseMoney) {
		
		int dp[]  = new int[totalHouseMoney.length+2];	
		dp[totalHouseMoney.length] = 0;
		
		for(int i=totalHouseMoney.length -1 ;i>=0;i--)
			dp[i] = Math.max(totalHouseMoney[i] + dp[i+2], dp[i+1]);
		
		return dp[0];
	}
	
	// Using Recursion
	protected int maxMoneyCircular(int[] wealth) {
		
        if(wealth.length == 0 )
            return 0;
        
        if(wealth.length == 1 )
            return wealth[0];
		
		int arr1[] = new int[wealth.length-1];
		int arr2[] = new int[wealth.length-1];
		
		for(int i=0;i<wealth.length-1;i++)
			arr1[i] = wealth[i];
		
		for(int i=0;i<wealth.length-1;i++)
			arr2[i] = wealth[i+1];
		
		int sum1 = maxMoneyCircularUtil(arr1, 0);
		int sum2 = maxMoneyCircularUtil(arr2, 0);
		
		return Math.max(sum1, sum2);
	}

	private int maxMoneyCircularUtil(int[] wealth, int index) {
		  
	    if( index >= wealth.length)
	      return 0;
	
	    // steal from current house and skip one to steal from the next house
	    int stealCurrent = wealth[index] + maxMoneyCircularUtil(wealth, index + 2);
	    
	    // skip current house to steel from the adjacent house
	    int skipCurrent = maxMoneyCircularUtil(wealth, index + 1);
	
	    return Math.max(stealCurrent, skipCurrent);
	}
	
	protected int maxMoneyCircular_TD(int[] wealth) {
		
        if(wealth.length == 0 )
            return 0;
        
        if(wealth.length == 1 )
            return wealth[0];
		
		int arr1[] = new int[wealth.length-1];
		int arr2[] = new int[wealth.length-1];
		
		for(int i=0;i<wealth.length-1;i++)
			arr1[i] = wealth[i];
		
		for(int i=0;i<wealth.length-1;i++)
			arr2[i] = wealth[i+1];
		
		Integer dp1[]  = new Integer[wealth.length-1];
		Integer dp2[]  = new Integer[wealth.length-1];
		
		int sum1 = maxMoneyCircularUtil_TD(dp1, arr1, 0);
		int sum2 = maxMoneyCircularUtil_TD(dp2, arr2, 0);
		
		return Math.max(sum1, sum2);
	}
	
	private int maxMoneyCircularUtil_TD(Integer []dp, 	int []totalHouseMoney , int index) {
		
		if(index >= totalHouseMoney.length)
			return 0;
		
		if(dp[index] == null) {
			int stealCurrentHouse = totalHouseMoney[index] + maxMoneyCircularUtil_TD(dp,totalHouseMoney, index+2);
			int skipCurrentHouse = maxMoneyCircularUtil_TD(dp,totalHouseMoney, index+1);
			dp[index] = Math.max(stealCurrentHouse, skipCurrentHouse);
		}
		
		return dp[index];
	}

	public static void main(String[] args) {
		HouseThief ht = new HouseThief();
		
		int []totalHouseMoney = {5,7,1,30,8,2,4}; 
		System.out.println("Total Number of Houses : "+totalHouseMoney.length);
		System.out.print("Money thief can steal from each house : ");
		for(int cost :totalHouseMoney) {
			System.out.print(cost+ " , ");
		}
		
		System.out.println("\nMaximum money the thief can steal using Recursion : "+ ht.maxMoney(totalHouseMoney));
		System.out.println("Maximum money the thief can steal using Top Down Approach : "+ht.maxMoney_TD(totalHouseMoney, 0));
		System.out.println("Maximum money the thief can steal using Bottom up Approach : "+ht.maxMoney_BU(totalHouseMoney));
		
		totalHouseMoney = new int[] {1,2,3,1};
		
		System.out.println("Maximum money the thief can steal in circular house using Recursion : "+ ht.maxMoneyCircular(totalHouseMoney));
		System.out.println("Maximum money the thief can steal in circular house using Recursion : "+ ht.maxMoneyCircular_TD(totalHouseMoney));
		
	}
}
