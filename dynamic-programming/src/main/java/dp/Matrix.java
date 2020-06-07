package dp;

public class Matrix {
	
	class Point{
		private int first, second;

		public Point(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
		
	protected Point findMaxSumSubMatrix(int mat[][], int k)
	{

		int M = mat.length;
		int N = mat[0].length;
		int[][] sum = new int[M][N];
		int total, max = Integer.MIN_VALUE;
		
		Point p = null;
		
		sum[0][0] = mat[0][0];


		for (int j = 1; j < N; j++) {
			sum[0][j] = mat[0][j] + sum[0][j - 1];
		}


		for (int i = 1; i < M; i++) {
			sum[i][0] = mat[i][0] + sum[i - 1][0];
		}


		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				sum[i][j] = mat[i][j] + sum[i - 1][j] + sum[i][j - 1]
							- sum[i - 1][j - 1];
			}
		}

		for (int i = k - 1; i < M; i++)	{
			for (int j = k - 1; j < N; j++)	{
				total = sum[i][j];
				if (i - k >= 0) {
					total = total - sum[i - k][j];
				}

				if (j - k >= 0) {
					total = total - sum[i][j - k];
				}

				if (i - k >= 0 && j - k >= 0) {
					total = total + sum[i - k][j - k];
				}

				if (total > max) {
					max = total;
					p = new Point(i, j);
				}
			}
		}

		return p;
	}

	public static void main(String[] args) {

		int[][] mat = {{ 3, -4, 6, -5, 1 },
						{ 1, -2, 8, -4, -2 },
						{ 3, -8, 9, 3, 1 },
						{ -7, 3, 4, 2, 7 },
						{ -3, 7, -5, 7, -6 }};

		int k = 3;
		
		Matrix matrix = new Matrix();
		
		Point p = matrix.findMaxSumSubMatrix(mat, k);

		// print maximum sum sub-matrix
		for (int i = 0; i < k; i++)
		{
			for (int j = 0; j < k; j++)
			{
				int r = i + p.first - k + 1;
				int c = j + p.second - k + 1;
				System.out.printf("%3d", mat[r][c]);
			}

			System.out.println();
		}

	}
}
