package LeetcodeExercises;
public class LinkedList {
	//---------------------Nested Node Class---------------------//
	public class Node {
		String data;
		Node next;
				
		public Node(String data) {
			this.data = data;
			this.next = null;
		}

	}
	//-----------------------------------------------------------//
	
	Node dummyHead;
	Node tail;
	int length;
	
	public LinkedList() {
		dummyHead = new Node(null);
		tail = dummyHead;
		length = 0;
	}
	
	public void insertFirst(String data) {
		Node input = new Node(data);
		input.next = dummyHead.next;
		dummyHead.next = input;
		if (length == 0) {
			tail = input;
		}
		length++;
	}
	
	public void insertLast(String data) {
		Node input = new Node(data);
		tail.next = input;
		tail = input;
		length++;
	}
	
	public void insertAtPosition(String data, int pos) {
		if (pos <= 0 || pos > length+1) {
			return;
		}
		Node input = new Node(data);
		Node start = dummyHead;        
		int i = 0;                                         
		while (i < pos-1) {                                     
			start = start.next;
			i++;
		}
		input.next = start.next;
		start.next = input;
		length++;
	}
	
	public void removeFirst() {
		if (dummyHead.next == null) {
			return;
		}
		else if (dummyHead.next.next == null) {   
			dummyHead.next = null;	
			tail = dummyHead;	
		}
		else {
			dummyHead.next = dummyHead.next.next;		
			dummyHead.next.next = null; //* */
		}
	}
	
	public void removeLast() {
		if (length == 0) {
			return;
		}
		else if (length == 1) {
			dummyHead.next = null;
			tail = dummyHead;
		}
		else {
			Node trail = dummyHead.next;
			Node find = dummyHead.next.next;
			while (find != null) {
				find = find.next;
				trail = trail.next;
			}
			trail.next = null;
			tail = trail;
		}
		length--;
	}
	
	public void removeAtPosition(int pos) {
		if (pos <= 0 || pos > length) {
			return;
		}
		int i = 0;
		Node start = dummyHead;
		while (i < pos - 1) {
			start = start.next;
			i++;
		}
		start.next = start.next.next;
		length--;
	}
	
	public boolean isPresent(Node n) {
		Node curr = dummyHead.next;
		while (curr != null) {
			if (curr == n){
				return true;
			}
			else {
				curr = curr.next;
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		if (length == 0) {
			return true;
		}
		return false;
	}
	
	public Node getFirst() {
		return dummyHead.next;
	}
	
	public Node getLast() {
		return tail;
	}
	
	public int getLength() {
		return length;
	}
	
	public void print() {
		Node curr = this.dummyHead.next;
		while(curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println(this.length);
	}
	
}