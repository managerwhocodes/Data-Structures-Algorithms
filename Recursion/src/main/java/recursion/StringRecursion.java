package recursion;

public class StringRecursion {

	public String reverseString(String string) {
	    
        if(string.isEmpty()){
            return string;
        }
    
        return reverseString(string.substring(1)) + string.charAt(0);
    
        //return string.charAt(string.length()-1) + reverseString(string.substring(0,string.length()-1));  
    }
	
	public static void main(String[] args) {
		
		StringRecursion strRec = new StringRecursion();
        
		String inputStr = "This is test";
        System.out.println("The reverse of "+inputStr+" = "+strRec.reverseString(inputStr));

	}

}
