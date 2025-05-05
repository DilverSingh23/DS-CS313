package day_10_heaps;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		MinHeap minheap = new MinHeap();
		minheap.insertMinHeap(8);
		minheap.insertMinHeap(2);
		minheap.insertMinHeap(6);
		minheap.insertMinHeap(18);
		minheap.insertMinHeap(3);
		minheap.insertMinHeap(0);
		minheap.insertMinHeap(-1);
		minheap.insertMinHeap(5);
		
		System.out.println(minheap.toString());
		
		
		System.out.println(minheap.removeMinHeap()); //-1
		System.out.println(minheap.toString());
		System.out.println(minheap.removeMinHeap()); //0
		System.out.println(minheap.toString());
		System.out.println(minheap.removeMinHeap()); //2
		
		System.out.println(minheap.toString());
		
	}

}
