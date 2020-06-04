package dp;

public class CoinChange {

	protected int getCount(int[] S, int N)
	{
		if (N == 0) {
			return 1;
		}

		if (N < 0) {
			return 0;
		}

		int res = 0;

		for (int i = 0; i < S.length; i++)
		{
			res += getCount(S, N - S[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		
		CoinChange cc = new CoinChange();
		
		int[] S = { 1, 2, 3 };
		int N = 4;

		System.out.println("Total number of ways to get desired change is "
						+ cc.getCount(S, N));
	}
}
