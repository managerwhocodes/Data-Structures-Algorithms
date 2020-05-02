package dc;

public class NumberFactor {

	// Numbers of ways to express number as a sum of 1,3,4
	protected int waysToGetN(int num) {
		
		if((num==0)||(num==1)||(num==2)) 
			return 1;
		if(num==3)
			return 2;
	
		return waysToGetN(num-1) + waysToGetN(num-3) + waysToGetN(num-4);
	}
	
	public static void main(String[] args) {
		NumberFactor nc = new NumberFactor();
		int input = 6;
		System.out.println("Numbers of ways to express "+input+" as a sum of 1,3,4 : "+ nc.waysToGetN(input));

	}
}
