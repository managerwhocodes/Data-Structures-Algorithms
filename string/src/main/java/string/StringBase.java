package string;

public class StringBase {

	protected void findNdigitNums(String res, int n, int sum) {

		if (n > 0 && sum >= 0) {
			char d = '0';
			if (res.equals("")) {	
				d = '1';
			}

			while (d <= '9') {
				findNdigitNums(res + d, n - 1, sum - (d - '0'));
				d++;
			}
		}

		else if (n == 0 && sum == 0) {
			System.out.print(res + " ");
		}
	}
	
	public static void main(String[] args) {

		StringBase sb = new StringBase();
		
		int n = 3;
		int sum = 6;

		String res = "";
		sb.findNdigitNums(res, n, sum);
	}

}
