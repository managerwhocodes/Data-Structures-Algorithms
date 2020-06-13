package dp;

public class OptimalRodCut {

	public static int rodCut(int[] price, int n) {

		int[] T = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				T[i] = Integer.max(T[i], price[j - 1] + T[i - j]);
			}
		}
		return T[n];
	}

	public static void main(String[] args) {
		// int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = 4;		// rod length

		System.out.print("Profit is " + rodCut(price, n));
	}
}
