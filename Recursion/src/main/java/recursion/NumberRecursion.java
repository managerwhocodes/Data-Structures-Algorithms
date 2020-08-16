package recursion;

public class NumberRecursion {

	private int getPower(int number, int power){
        
        if(power==1)
            return number;
            
        return number * getPower(number,power-1);

    }
	
	public static void main(String[] args) {
		
		NumberRecursion recursion = new NumberRecursion(); 
		
		System.out.println("4 power 3 = "+recursion.getPower(4,3));

	}

}
