package dp;

public class BestTimeBuySellStock {
	
	// Allowed to complete at most one transaction 
	private int maxProfitOneTrasaction(int[] prices) {

		if(prices.length == 0) 
			return 0;

		int[] profit = new int[prices.length];
		int min = prices[0];

		for(int i=1; i< prices.length; i++){
			if(prices[i] < min) 
				min = prices[i];

			profit[i] = Math.max(profit[i-1], prices[i]-min);
		}
		return profit[prices.length-1];  
    }
	
	// Allowed to complete multiple transactions
	private int maxProfitMultipleTrasaction(int[] prices) {

		if(prices.length == 0) 
			return 0;

		int profit = 0;

		for(int i=1; i< prices.length;i++){
			if(prices[i-1] < prices[i]) {
				profit = profit + prices[i] - prices[i-1];
			}		
		}
		return profit;
    }
	
	// Allowed at most two transaction
	private int maxProfitTwoTransaction(int[] prices) {
		
		if(prices.length == 0)
			return 0;

		int currentProfit[] = new int[prices.length];
    	int previousProfit[] = new int[prices.length];
    		
    	for(int i=1;i<3;i++) {
    		int maxSoFar = -prices[0]; 		
    		
    		for(int j=1;j<prices.length;j++) {
    			maxSoFar = Math.max(maxSoFar, previousProfit[j-1]-prices[j-1]);
    			currentProfit[j] = Math.max(currentProfit[j-1], prices[j] + maxSoFar);
    		}
    		
    		for(int j=1;j<prices.length;j++) {
    			previousProfit[j] = currentProfit[j];
    		}
    	}
    	
    	return currentProfit[prices.length-1];
      
    }
     	
	public static void main(String []args) {
		BestTimeBuySellStock solution = new BestTimeBuySellStock();
		int [] input = {3,3,5,0,0,3,1,4};
		int output = solution.maxProfitOneTrasaction(input);
		int index = 1;
		for(int price : input)
			System.out.println("Price of stock on Day "+index+++" : "+price);
		System.out.println("Maximum profit that can be made by buying and selling stocks with atmost one transaction : "+output);
		output = solution.maxProfitTwoTransaction(input);
		System.out.println("Maximum profit that can be made by buying and selling stocks with atmost two transactions : "+output);
		output = solution.maxProfitMultipleTrasaction(input);
		System.out.println("Maximum profit that can be made by buying and selling stocks with multiple transactions : "+output);
	}
}
