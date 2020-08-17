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
    
    protected int getGCD(int nummberOne, int nummberTwo){
        
        if(nummberOne == nummberTwo){
            return nummberOne;
        }
        
        if(nummberOne  <  nummberTwo)
            return getGCD(nummberOne, nummberTwo-nummberOne);
        else
            return getGCD(nummberOne-nummberTwo, nummberTwo);
        
    }
    
    protected boolean isPrime(int num, int i) {
        
        if(num==i)
            return true;
            
        if(num%i==0)
            return false;
        else
            return isPrime(num,i+1);
        
    }
	
	public static void main(String[] args) {
		
		NumberRecursion recursion = new NumberRecursion(); 
		
		System.out.println(" 4  power 3 = "+recursion.getPower(4,3));
		
		System.out.println(" 17  mod  3 = "+recursion.getMod(17,3));
		
		System.out.println(" GCD(72,36) = "+recursion.getGCD(72,36));
		
		System.out.println("Is 27 a prime number ? "+recursion.isPrime(27,2));

	}
}
