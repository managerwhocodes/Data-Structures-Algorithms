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

	public static void main(String[] args) {
		
		GoldPots gp = new GoldPots();
		
		int[] coin = { 4, 6, 2, 3 };

		System.out.println("Maximum coins collected by player is "
						+ gp.optimalStrategy(coin, 0, coin.length - 1));
		
		int[][] lookup = new int[coin.length][coin.length];
		
		System.out.println("Maximum coins collected by player is "
				+ gp.optimalStrategyTopDown(coin, 0, coin.length - 1, lookup));

	}
}
