package Classwork6;

public class MinHeap {
	int[] heapArray;
	int size; //also last element
	int capacity;
	
	public MinHeap() {
		capacity = 1000;
		heapArray = new int[capacity];
		size = 0;
	}
	
	public MinHeap(int cap) {
		capacity = cap;
		heapArray = new int[capacity];
	}
	
	/**
	 * Insert in the min-heap array and heapify-up
	 * @param num
	 */
	public void insertMinHeap(int num) {
		if(size == capacity-1) {
			throw new IllegalStateException("Heap is full, cannot insert "+num);
		}
		size++;
		heapArray[++size] = num;
		heapifyUp(size);
	}
	
	/**
	 * Remove the min value from the min-heap
	 * and heapify-down
	 * @return
	 */
	public int removeMinHeap() {
		if (size == 0) {
			throw new IllegalStateException("No elements to remove from heap");
		}
		int save = heapArray[1];
		heapArray[1] = heapArray[size--];
		heapifyDown();
		return save;
	}
	
	/**
	 * Once a value is inserted, make sure it's on the right spot.
	 * Move it up in necessary.
	 * @param index
	 */
	public void heapifyUp(int index) {
		int i = index;
		while (i > 1 && heapArray[i/2] > heapArray[i] ){
			swap(heapArray[i], heapArray[i/2]);
			i /= 2;
		}
	}
	
	/**
	 * Once the min (root) is removed, replace the root with the last node.
	 * Move root down if necessary.
	 * @param index
	 */
	public void heapifyDown() {
		int i = 1;
		while (i*2 <= size || (i*2 + 1) <= size) {
			if (heapArray[i] )
			if (heapArray[i] > heapArray[i*2] || heapArray[i] > heapArray[(i*2)+1]) {
				if (heapArray[i*2] < heapArray[(i*2)+1]) {
					swap(heapArray[i], heapArray[i*2]);
					i *= 2;
				}
				else {

				}
			}
		}
	}
	
	/**
	 * Helper method two swap two nodes in the heap array.
	 * @param i
	 * @param j
	 */
	public void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
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
