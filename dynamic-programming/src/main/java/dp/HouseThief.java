package dp;

public class HouseThief {
	
	// Top-Down Approach
	protected int maxMoney_TD(int []totalHouseMoney , int index) {
		
		int dp[]  = new int[totalHouseMoney.length];	
		return maxMoneyUtil(dp, totalHouseMoney, index);
	}

	private int maxMoneyUtil(int []dp, 	int []totalHouseMoney , int index) {
		
		if(index >= totalHouseMoney.length)
			return 0;
		
		if(dp[index] == 0) {
			int stealCurrentHouse = totalHouseMoney[index] + maxMoneyUtil(dp,totalHouseMoney, index+2);
			int skipCurrentHouse = maxMoneyUtil(dp,totalHouseMoney, index+1);
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

	public static void main(String[] args) {
		HouseThief ht = new HouseThief();
		
		int []totalHouseMoney = {5,7,1,30,8,2,4}; 
		System.out.println("Total Number of Houses : "+totalHouseMoney.length);
		System.out.print("Money thief can steal from each house : ");
		for(int cost :totalHouseMoney) {
			System.out.print(cost+ " , ");
		}
		System.out.println("\nMaximum money the thief can steal using Top Down Approach : "+ht.maxMoney_TD(totalHouseMoney, 0));
		System.out.println("Maximum money the thief can steal using Bottom up Approach : "+ht.maxMoney_BU(totalHouseMoney));
	}
}
