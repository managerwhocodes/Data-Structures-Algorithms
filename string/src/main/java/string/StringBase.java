package string;

import java.util.Stack;

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
	
	protected void findNdigitNumsWithEqualSum(String res, int n, int diff) {

		if (n > 0) {
			char ch = '0';

			if (res.equals("")) {
				ch = '1';
			}

			while (ch <= '9') {
				int absdiff;

				if ((n & 1) != 0) {
					absdiff = diff + (ch - '0');
				}
				else {
					absdiff = diff - (ch - '0');
				}

				findNdigitNums(res + ch, n - 1, absdiff);
				ch++;
			}
		}

		else if (n == 0 && Math.abs(diff) == 0) {
			System.out.println(res);
		}
	}
	
	protected String removeAdjDup(String str) {

		char[] chars = str.toCharArray();
		char prev = chars[0];

		int k = 0;
		int i = 1;

		while (i < chars.length) {

			if (prev != chars[i]) {
				chars[++k] = chars[i++];
				prev = chars[k];			
			}
			else {
				while (i < chars.length && prev == chars[i]) {
					i++;
				}
				prev = chars[--k];
			}
		}
		return new String(chars).substring(0, k + 1);
	}
	
	protected int findMaxLenOfBalancedParanthesis(String str) {

		Stack<Integer> stack = new Stack<>();

		stack.push(-1);
		int len = 0;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(') {
				stack.push(i);
			} else {

				stack.pop();

				if (stack.empty()) {
					stack.push(i);
					continue;
				}

				int curr_len = i - stack.peek();

				if (len < curr_len) {
					len = curr_len;
				}
			}
		}
		return len;
	}

	
	public static void main(String[] args) {

		StringBase sb = new StringBase();
		
		int n = 3;
		int sum = 6;

		String res = "";
		sb.findNdigitNums(res, n, sum);
	}

}
