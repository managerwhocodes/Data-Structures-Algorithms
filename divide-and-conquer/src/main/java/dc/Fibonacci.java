package dc;

public class Fibonacci {

	protected int calculateFibonacci(int num) {
				
		if(num == 1)
			return 0;
		else if(num == 2)
			return 1;
		else
			return calculateFibonacci(num-1) + calculateFibonacci(num-2);		
	}
	
	public static void main(String[] args) {
		
		Fibonacci fib = new Fibonacci();
		int count = 12;
		
		System.out.print("Fibonacci series for "+count+" numbers : ");
		for(int i=1;i<=count;i++)
			System.out.print(fib.calculateFibonacci(i)+" ");
	}
}
