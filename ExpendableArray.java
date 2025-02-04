public class ExpendableArray {
	private int size;
	private int capacity;
	private String[] array;
	
	public ExpendableArray(){//default constructor
		size = 0;
		capacity = 5;
		array = new String[capacity];
		fillArray();
	}
	
	public ExpendableArray(int cap){
		size = 0;
		capacity = cap;
		array = new String[capacity];
		fillArray();
	}
	
	private void fillArray() {
		for (int i = 0; i < capacity; i++) {
			array[i] = null;
		}
	}

	private void isAlmostFull() {
		if ((100 * size) / capacity >= 70) {
			doubleCapacity();
		}
	}
	
	private void isAlmostEmpty() {
		if ((100 * size) / capacity <= 25) {
			halveCapacity();
		}
	}
	
	private void doubleCapacity() {
		capacity *= 2;
		copyArray();
	}
	
	private void halveCapacity() {
		capacity = capacity / 2;
		copyArray();
	}
	
	private void copyArray() {
		String[] temp = new String[capacity];
		for (int i = 0; i <= size; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}
	
	public String get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Illegal index value.");
		}
		return array[index];
	}
	
	public void add(String e) {
		array[size] = e;
		size++;
		isAlmostFull();
	}

	public void insert(String e, int index) {
		for (int i = size-1; i <= index; i++) {
			array[i+1] = array[i];
		}
		array[index] = e;
		size++;
		isAlmostFull();
	}
	
	public void remove() {
		array[size-1] = null;
		size--;
		isAlmostEmpty();
	}
	
	public void remove(int index) {
		for (int i = index; i <= size; i++){ 
			array[i] = array[i+1];
		}
		size--;
		isAlmostEmpty();
	}
	
	public boolean isEmpty() {
		for (int i = 0; i<=size; i++) {
			if (array[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		String ans = "[";
		for (int i = 0; i < size; i++) {
			if (i == size-1) {
				ans += array[i] + "]";
			}
			else {
				ans += array[i] + ",";
			}
		}
			return ans;
	}
	
	public int getSize() { return this.size; }
	public int getCapacity() { return this.capacity; }
}
