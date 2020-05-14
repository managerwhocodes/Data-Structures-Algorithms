package dp;

public class BestTimeBuySellStock {
	
	private int maxProfit(int[] prices) {

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
    
	public static void main(String []args) {
		BestTimeBuySellStock solution = new BestTimeBuySellStock();
		int [] input = {7,1,5,3,6,4};
		int output = solution.maxProfit(input);
		int index = 1;
		for(int price : input)
			System.out.println("Price of stock on Day "+index+++" : "+price);
		System.out.println("Maximum profit that can be made by buying and selling stocks : "+output);
	}
}
