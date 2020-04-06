package linkedlist;

public class Stack{

    private Node top;

    public Stack(){
        this.top = null;
    }
    
    private int pop(){
        if(top == null){ // implement exception handling
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int data = peek();
        top = top.getNext();
        return data;
    }

    private void push(int data){
        Node node = new Node(data);
        node.setNext(top);
        top = node;
    }

    private int peek(){
        if(!isEmpty()){
            return top.getData();
        } else { // implement exception handling
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
    }

    private boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
