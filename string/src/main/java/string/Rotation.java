package string;

import java.util.ArrayList;
import java.util.List;

public class Rotation {

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
	
	public static void main(String[] args) {
		
		Rotation strRotate = new Rotation();
		String input = "tests";
		
		System.out.println("All the rotations for the input string - "+input + " : ");
		for(String output : strRotate.getAllRotationUsingConcat(input))
			System.out.println(output);

	}
}
