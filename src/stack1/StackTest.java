package stack1;

import java.util.Stack;

public class StackTest {
	public static int[] stack = new int[100];
	public static int top = -1;
	
	public static boolean push(int value) {
		if(top >= stack.length) 
			return false;
		
		stack[++top] = value;
		return true;
	}
	
	public static int pop() {
		if(top == -1)
			return -1;
		
		return stack[top--];
	}
	
	public static int peek() {
		if(top == -1)
			return -1;
		
		return stack[top];
	}
	
	public static boolean isEmpty() {
	
		return top == -1;
	}
	
	public static void main(String[] args) {
		push(1);
		System.out.println(isEmpty());
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(peek());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println();
		
		
		
		
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		System.out.println(stack.empty());
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
