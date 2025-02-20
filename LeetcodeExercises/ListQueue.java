package LeetcodeExercises;
import java.util.LinkedList;

public class ListQueue {
	LinkedList<String> queue;
	//capacity is not necessary
	//size can be implied by the list's length
	//front and rear can be implied by list's head and tail
	
	public ListQueue() {
		queue = new LinkedList<>();
	}
	
	/**
	 * This methods can also be called "add" or "offer".
	 * Places an element at the end of the queue.
	 * What is the runtime? Ans: O(1)
	 * @param element
	 */
	public void enqueue(String element) {
		queue.addLast(element); 
	}
	
	/**
	 * This methods can also be called "pop" or "remove".
	 * Removes the element at the front of the queue.
	 * If queue is empty, it returns null.
	 * What is the runtime? Ans: O(1)
	 * @return E
	 */
	public String dequeue() {
		if (isEmpty()) {
			return null;
		}
		String save = queue.getFirst();
		queue.removeFirst();
		return save;
	}
	
	/**
	 * This methods can also be called "peek" or "element".
	 * Returns but does not remove the element at the front of the queue.
	 * If queue is empty, it returns null.
	 * What is the runtime? Ans: O(1)
	 * @return E
	 */
	public String front() {
		if (isEmpty()) {
			return null;
		}
		return queue.getFirst();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
		
	public int size() {
		return queue.size();
	}
}
