package string;


public class StringReverse {

	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}


	public void reverse(char[] chars, int begin, int end) {
		while (begin < end) {
			swap(chars, begin++, end--);
		}
	}


	protected  void reverse(char[] chars) {

		int low = 0, high = 0;


		for (int i = 0; i < chars.length; i++) {
			
			if (chars[i] == ' ') {
				reverse(chars, low, high);
				low = high = i + 1;
			}
			else {
				high = i;
			}
		}

		reverse(chars, low, high);
		reverse(chars, 0, chars.length - 1);
	}
	
	
	public static void main(String[] args) {
		
		StringReverse strReverse = new StringReverse();
		
		String string = "Test is testing how we can test a test ";
	
		char[] chars = string.toCharArray();
		strReverse.reverse(chars);
		
		System.out.println(chars);
	}
}
