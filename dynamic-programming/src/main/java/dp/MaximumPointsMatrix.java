package dp;

public class MaximumPointsMatrix {

	protected boolean isSafe(int[][] mat, int i, int j) {
		
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == -1) {
			return false;
		}
		return true;
	}
	
	protected int findMaximum(int[][] mat, int i, int j)
	{

		if (!isSafe(mat, i, j)) {
			return 0;
		}

		if ((i & 1) == 1) {
			return mat[i][j] + Integer.max(findMaximum(mat, i, j - 1), findMaximum(mat, i + 1, j));
		}

		else {
			return mat[i][j] + Integer.max(findMaximum(mat, i, j + 1), findMaximum(mat, i + 1, j));
		}
	}

	public static void main(String[] args) {
		
		MaximumPointsMatrix mp = new MaximumPointsMatrix();
		
		int[][] mat =
			{
				{  1,  1, -1,  1,  1 },
				{  1,  0,  0, -1,  1 },
				{  1,  1,  1,  1, -1 },
				{ -1, -1,  1,  1,  1 },
				{  1,  1, -1, -1,  1 }
			};

			System.out.println("Maximum value collected is "
					+ mp.findMaximum(mat, 0, 0));

	}

}
