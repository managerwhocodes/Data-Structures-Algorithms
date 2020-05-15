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
	public int maxProfitMultipleTrasaction(int[] prices) {

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
    
	public static void main(String []args) {
		BestTimeBuySellStock solution = new BestTimeBuySellStock();
		int [] input = {7,1,5,3,6,4};
		int output = solution.maxProfitOneTrasaction(input);
		int index = 1;
		for(int price : input)
			System.out.println("Price of stock on Day "+index+++" : "+price);
		System.out.println("Maximum profit that can be made by buying and selling stocks with one transaction allowed : "+output);
		output = solution.maxProfitMultipleTrasaction(input);
		System.out.println("Maximum profit that can be made by buying and selling stocks with multiple transaction allowed : "+output);
	}
}
