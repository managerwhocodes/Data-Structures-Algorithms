package dc;

public class KnapsackZeroOne {
	
	protected int getMaxProfit(int []profit, int []weight, int capacity) {
		
		return getMaxProfitUtil(profit, weight, capacity, 0);		
	}

	private int getMaxProfitUtil(int []profit, int []weight, int capacity, int index) {
		
		if(capacity <=0 || index < 0 || index >= profit.length)
			return 0;
		
		int profitOne = 0;
		if(weight[index] <= capacity)
			profitOne = profit[index] + getMaxProfitUtil(profit, weight, capacity - weight[index], index+1);
		
		int profitTwo = getMaxProfitUtil(profit, weight, capacity, index+1);
		
		return Math.max(profitOne, profitTwo);
	}
	
	public static void main(String[] args) {
		
		KnapsackZeroOne ks = new KnapsackZeroOne();
		int[] profit = { 31, 26, 72, 17 };
		int[] weight = { 3, 1, 5, 2 };
		int knapsackCapacity = 7;
		
		int maxProfit = ks.getMaxProfit(profit,weight,knapsackCapacity);
		
		System.out.print("Profit : ");
		for(int p : profit)
			System.out.print(p + "  ");
		
		System.out.print("\nWeight : ");
		for(int w : weight)
			System.out.print(w + "  ");
		
		System.out.println("\nCapacity of Knapsack : "+knapsackCapacity);
		
		System.out.println("Maxium profit : "+maxProfit);
		
		
	}
}
