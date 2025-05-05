package day_10_heaps;

public class MinHeap {
	int[] heapArray;
	int size; //also last element
	int capacity;
	
	public MinHeap() {
		
	}
	
	public MinHeap(int cap) {
		
	}
	
	/**
	 * Insert in the min-heap array and heapify-up
	 * @param num
	 */
	public void insertMinHeap(int num) {
		
	}
	
	/**
	 * Remove the min value from the min-heap
	 * and heapify-down
	 * @return
	 */
	public int removeMinHeap() {
		
	}
	
	/**
	 * Once a value is inserted, make sure it's on the right spot.
	 * Move it up in necessary.
	 * @param index
	 */
	public void heapifyUp(int index) {
		
	}
	
	/**
	 * Once the min (root) is removed, replace the root with the last node.
	 * Move root down if necessary.
	 * @param index
	 */
	public void heapifyDown() {
		
	}
	
	/**
	 * Helper method two swap two nodes in the heap array.
	 * @param i
	 * @param j
	 */
	public void swap(int i, int j) {
		
	}
	
	/**
	 * Give a string representation of the heap array
	 * Example: [1,2,3,4,5]
	 */
	public String toString() {
		String ans = "[";
		for(int i = 1; i <= size; i++) {
			ans += heapArray[i];
			if(i != size) ans += ", ";
		}
		ans += "]";
		return ans;
	}
}
