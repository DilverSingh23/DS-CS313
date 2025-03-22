package Classwork3;

@SuppressWarnings("unchecked")
// read hashmap chapter in textbook until it talks about linear probing
public class ChainHashMap<K,V> {
	final int CAPACITY = 101;
	LinkedList<Pair<K,V>>[] bucket;
	int size;
	
	public ChainHashMap() {
		bucket = (LinkedList<Pair<K,V>>[]) new LinkedList[CAPACITY];
		for (int i = 0; i < CAPACITY; i++) {
			bucket[i] = new LinkedList<Pair<K,V>>();
		}
		size = 0;		
	}
	public int getIndex(K key) {
		// hash function
		int hash = 0;
		char[] keyChars = key.toString().toCharArray();
		for (int i = 0; i < keyChars.length; i++){
			int ascii = keyChars[i];
			hash += ascii * 23;
		}
		// compression function
		hash = hash % bucket.length;
		return hash;
	}
	public void put(Pair<K,V> pair) {
		int index = getIndex(pair.key);
		Node<Pair<K,V>> cur = bucket[index].getFirst();
		while (cur != null) {
			if (cur.getNodeData().getKey() == pair.getKey()){
				cur.data = pair;
				return;
			}
			cur = cur.next;
		}
		bucket[index].insertLast(pair);
		size++;
	}
	
	public Pair<K,V> get(K key){
		Node<Pair<K,V>> cur = bucket[getIndex(key)].getFirst();
		while (cur != null) {
			if (cur.getNodeData().getKey().equals(key)) {
				return cur.data;
			}
			cur = cur.next;
		}
		return null;
	}

	
	public Pair<K,V> remove(K key){
		Pair<K,V> first = bucket[getIndex(key)].getFirst().getNodeData();;
		bucket[getIndex(key)].removeFirst();
		size--;
		return first;
	}
	
	public LinkedList<K> keySet() {
		LinkedList<K> keys = new LinkedList<>();
		for (int i = 0; i < bucket.length; i++){
			Node<Pair<K,V>> cur = bucket[i].getFirst();
			while (cur != null) {
				keys.insertLast(cur.data.key);
				cur = cur.next;
			}
		}
		return keys;
	}
	
	public LinkedList<Pair<K,V>> entrySet(){
		LinkedList<Pair<K,V>> entries = new LinkedList<>();
		for (int i = 0; i < bucket.length; i++){
			Node<Pair<K,V>> cur = bucket[i].getFirst();
			while (cur.next != null) {
				entries.insertLast(cur.data);
				cur = cur.next;
			}
		}
		return entries;
	}	
}
