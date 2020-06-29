package dp;

public class GoldPots {
	
	protected int optimalStrategy(int[] coin, int i, int j) {

		if (i == j) {
			return coin[i];
		}

		if (i + 1 == j) {
			return Integer.max(coin[i], coin[j]);
		}

		int start = coin[i] + Integer.min(optimalStrategy(coin, i + 2, j),
										optimalStrategy(coin, i + 1, j - 1));

		int end = coin[j] + Integer.min(optimalStrategy(coin, i + 1, j - 1),
										optimalStrategy(coin, i, j - 2));
		
		return Integer.max(start, end);
	}
	
	protected int optimalStrategyTopDown(int[] coin, int i, int j, int[][] lookup) {

		if (i == j) {
			return coin[i];
		}
	
		if (i + 1 == j) {
			return Integer.max(coin[i], coin[j]);
		}

		if (lookup[i][j] == 0) {
			
			int start = coin[i] + Integer.min(optimalStrategyTopDown(coin, i + 2, j, lookup),
												optimalStrategyTopDown(coin, i + 1, j - 1, lookup));

			int end = coin[j] + Integer.min(optimalStrategyTopDown(coin, i + 1, j - 1, lookup), 
											optimalStrategyTopDown(coin, i, j - 2, lookup));
	
			lookup[i][j] = Integer.max(start, end);
		}
		return lookup[i][j];
	}
	
	protected int optimalStrategyBottomUp(int[] coin) {
		
		int n = coin.length;

		if (n == 1) {
			return coin[0];
		}

		if (n  == 2) {
			return Integer.max(coin[0], coin[1]);
		}

		int[][] T = new int[n][n];

		for (int iteration = 0; iteration < n ; iteration++) {
			for (int i = 0, j = iteration; j < n ; i++, j++) {
				
				int start = coin[i] + Integer.min(calculate(T, i + 2, j),
											calculate(T, i + 1, j - 1));

				int end = coin[j] + Integer.min(calculate(T, i + 1, j - 1),
											calculate(T, i, j - 2));

				T[i][j] = Integer.max(start, end);
			}
		}
		return T[0][n - 1];
	}
	
	private int calculate(int[][] T, int i, int j) {
		if (i <= j) {
			return T[i][j];
		}
		return 0;
	}

	public static void main(String[] args) {
		
		GoldPots gp = new GoldPots();
		
		int[] coin = { 4, 6, 2, 3 };

		System.out.println("Maximum coins collected by player is "
						+ gp.optimalStrategy(coin, 0, coin.length - 1));
		
		int[][] lookup = new int[coin.length][coin.length];
		
		System.out.println("Maximum coins collected by player is "
				+ gp.optimalStrategyTopDown(coin, 0, coin.length - 1, lookup));
		
		System.out.println("Maximum coins collected by player is "
				+ gp.optimalStrategyBottomUp(coin));

	}
}
