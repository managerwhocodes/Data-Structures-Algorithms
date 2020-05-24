package string;

import java.util.ArrayList;
import java.util.List;

public class StringRotation {

	protected List<String> getAllRotation(String str) {
		List<String> rotated = new ArrayList<String>();
		
		for(int i=1;i<str.length();i++) {
			rotated.add(str.substring(i) + str.substring(0,i));			
		}		
		return rotated;
	}
	
	protected List<String> getAllRotationUsingConcat(String str) {
		List<String> rotated = new ArrayList<String>();
		String concatString = str+str;
		for(int i=1,j=str.length()+1;i<str.length()&&j<concatString.length();i++,j++) {
			rotated.add(concatString.substring(i,j));			
		}		
		return rotated;
	}
	
	protected boolean isRotation(String strOne, String strTwo) {
		boolean check = false;
		String concatString = strOne+strOne;
		
		for(int i=1,j=strOne.length()+1;i<strOne.length()&&j<concatString.length();i++,j++) {
			if(strTwo.equals(concatString.substring(i,j)))
				check = true;
		}
		
		return check;
	}
	
	public static void main(String[] args) {
		
		StringRotation strRotate = new StringRotation();
		String input = "tests";
		String inputForRotOne = "geeks";
		String inputForRotTwo = "eeksg";
		
		System.out.println("All the rotations for the input string - "+input + " : ");
		for(String output : strRotate.getAllRotation(input))
			System.out.println(output);
		
		System.out.println("\nAll the rotations for the input string - "+input + " using concat : ");
		for(String output : strRotate.getAllRotationUsingConcat(input))
			System.out.println(output);
		
		System.out.println("\nIs "+inputForRotTwo+ " rotation of "+inputForRotOne+ " : "
								+strRotate.isRotation(inputForRotOne, inputForRotTwo));

	}
}
