package sorting;

import java.util.Stack;

public class StackSorting {

	protected Stack<Integer> sorting(Stack<Integer> original) {

        if(original.size()>0){
            int x = original.pop();
            sorting(original);
            sortUtil(original, x);
        }

        return original;
    }

    protected void sortUtil(Stack<Integer> stack, int x){

        if(stack.size()==0 || stack.peek()>x){
            stack.push(x);
            return;
        }
        
        int y = stack.pop();
        sortUtil(stack, x);
        stack.push(y);
    }
	
	public static void main(String[] args) {

		StackSorting ss = new StackSorting();
		
        Stack<Integer> originalStack = new Stack<Integer>();
        
        originalStack.add(4);
        originalStack.add(9);
        originalStack.add(6);
        originalStack.add(8);
        originalStack.add(10);
        originalStack.add(5);
        
        System.out.println("Original Stack: " + originalStack);
        Stack<Integer> sortedStack = ss.sorting(originalStack);
        System.out.println("Sorted Stack is:" + sortedStack);
		
	}
}
