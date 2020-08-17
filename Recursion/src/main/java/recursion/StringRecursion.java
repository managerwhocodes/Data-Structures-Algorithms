package recursion;

public class StringRecursion {

	public String reverseString(String string) {
	    
        if(string.isEmpty()){
            return string;
        }
    
        return reverseString(string.substring(1)) + string.charAt(0);
    
        //return string.charAt(string.length()-1) + reverseString(string.substring(0,string.length()-1));  
    }
	
	protected String removeDuplicates(String text) {
        
        if (text.length() == 1) {
            return text;
        }
    
        if (text.substring(0,1).equals(text.substring(1,2))) {
            return removeDuplicates(text.substring(1));
        }
        else {
            return text.substring(0,1) + removeDuplicates(text.substring(1));
        }
    }
	
	public static void main(String[] args) {
		
		StringRecursion strRec = new StringRecursion();
        
		String inputStr = "This is test";
        System.out.println("The reverse of "+inputStr+" = "+strRec.reverseString(inputStr));
        
        inputStr = "Thiss iiss aa teesstt";
        System.out.println("Remove duplicates from '"+inputStr+"' = "+strRec.removeDuplicates(inputStr));

	}

}
