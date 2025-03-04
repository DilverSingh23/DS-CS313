package LeetcodeExercises;

public class ArrayStack {
	String[] stack;
	final int CAPACITY = 5;
	int top;
	int size;
	
	public ArrayStack() {
		stack = new String[CAPACITY];
		top = -1;
		size = 0;
	}
	
	/**
	 * Places an element at the top of the stack.
	 * What is the runtime? Ans: O(1)
	 * @param element
	 */
	public void push(String element) {
		if (size == CAPACITY) {
			throw new IllegalArgumentException("The stack has reached capacity.");
		}
		stack[++top] = element;
		size++;
	}
	
	/**
	 * Removes the element at the top of the stack.
	 * If stack is empty, it returns null.
	 * What is the runtime? Ans: O(1)
	 * @return String
	 */
	public String pop() {
		if (size == 0){
			return null;
		}
		String save = stack[top--];
		size--;
		return save;
	}
	
	/**
	 * Returns but does not remove the element at the top of the stack.
	 * If stack is empty, it returns null.
	 * What is the runtime? Ans: O(1)
	 * @return String
	 */
	public String peek() {
		if (isEmpty()) {
			return null;
		}
		return stack[top];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
