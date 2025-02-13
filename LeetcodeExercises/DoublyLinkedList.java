package LeetcodeExercises;

public class DoublyLinkedList<T> {
	//---------------------Nested Node Class---------------------//
	public class Node {
		T data;
		Node prev;
		Node next;
		
		public Node(T data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	//-----------------------------------------------------------//
	
	Node dummyhead;
	Node tail;
	int length;
	
	public DoublyLinkedList() {
		dummyhead = new Node(null);
		tail = dummyhead;
		length = 0;
	}
	
	public void insertFirst(T data) {
		Node input = new Node(data);
		if (length == 0) {
			dummyhead.next = input;
			input.prev = dummyhead;
			tail = input;
		}
		else {
			input.next = dummyhead.next;
			dummyhead.next = input;
			input.next.prev = input;
		}
        length++;
	}
	
	public void insertLast(T data) {
		Node input = new Node(data);
		tail.next = input;
		input.prev = tail;
		tail = input;
		length++;
	}
	
	public void insertAtPosition(T data, int pos) {
		if (pos < 0 || pos > length) {
			return;
		}
		Node input = new Node(data);
		Node find = dummyhead.next;
		if (pos == 0) {
			insertFirst(data);
		}
		else if (pos == length) {
			insertLast(data);
		}
        else {
            int i = 0;
            while (i != pos-1) {
                find = find.next;
                i++;
            }
            input.next = find.next;
            input.prev = find;
            find.next.prev = input;
            find.next = input;
            length++;
        }
	}
	
	public void removeFirst() {
		if (length == 0) {
			return;
		}
		else if (length == 1) {
			dummyhead.next = null;  
			tail = dummyhead;
		}
		else {
			dummyhead.next = dummyhead.next.next;  
			dummyhead.next.prev = dummyhead;
		}
		length--;
	}
	
	public void removeLast() {
		if (length == 0) {
			return;
		}
		else if (length == 1) {
			dummyhead.next = null;
			tail = dummyhead;
		}
		else {
			tail.prev.next = null;
			tail = tail.prev;
		}
		length--;
	}
	
	public void removeAtPosition(int pos) {
		if (pos < 0 || pos >= length) {
			return;
		}
		else if (pos == 0) {
			removeFirst();
		}
		else if (pos == length - 1) {
			removeLast();
		}
		else {
			Node find = dummyhead.next;
			int i = 0;     
			while (i != pos){
				find = find.next;    
				i++;
			}
			find.prev.next = find.next;
			find.next.prev = find.prev;
			length--;
		}
	}
	
	public boolean isPresent(Node n) {
		Node curr = dummyhead.next;
		while (curr != null) {
			if (curr == n) {
				return true;
			}
			curr = curr.next;
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
		if (length > 0) {
			return dummyhead.next;
		}
		return null;
	}
	
	public Node getLast() {
		if (length == 0) {
			return null;
		}
		return tail;
	}
	
	public int getLength() {
		return length;
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		if (length == 0) {
			return null;
		}
		T[] arr = (T[]) new Object[length];
		Node curr = dummyhead.next;
		int i = 0;
		while (curr != null) {
			arr[i] = curr.data;
			curr = curr.next;
			i++;
		}
		return arr;
	}

	@SuppressWarnings("unchecked")
	public T[] toArrayInverse() {
		if (length == 0) {
			return null;
		}
		T[] arr = (T[]) new Object[length];
		Node curr = tail;
		int i = 0;
		while (curr != dummyhead) {
			arr[i] = curr.data;
			curr = curr.prev;
			i++;
		}
		return arr;
	}
	
}
