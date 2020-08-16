package recursion;

public class NumberRecursion {

	protected int getPower(int number, int power){
        
        if(power==1)
            return number;
            
        return number * getPower(number,power-1);

    }
	
    protected int getMod(int dividend, int divisor){
        
        if(divisor == 0){
            System.out.println("Divisor cannot be 0");
            return -1;
        }

        if(dividend < divisor){
            return dividend;
        }
        
        return getMod(dividend - divisor, divisor);
        
    }
	
	public static void main(String[] args) {
		
		NumberRecursion recursion = new NumberRecursion(); 
		
		System.out.println(" 4  power 3 = "+recursion.getPower(4,3));
		
		System.out.println(" 17  mod  3 = "+recursion.getMod(17,3));

	}
}
