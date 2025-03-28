package Classwork3;
import java.security.Key;
import java.util.ArrayList;
@SuppressWarnings("unchecked")

public class OpenAddressHashMap<K,V> {
    final int CAPACITY = 5;
    Pair<K,V> [] bucket;
    int size;

    public OpenAddressHashMap() {
        bucket = (Pair<K,V> []) new Pair[CAPACITY];
        size = 0;
    }

    public void put(Pair<K,V> pair) {
        int index = pair.key.hashCode() % CAPACITY;
        if (bucket[index] == null){
            bucket[index] = pair;
        }
        else if (size == CAPACITY) {
            throw new IllegalArgumentException("Hashmap at Capacity");
        }
        else {
            int i = 0;
            while (bucket[i] == null){
                i++;
            }
            bucket[i] = pair;
        }
        size++;
    }

    public Pair<K,V> get(Key k) {
        int index = k.hashCode() % CAPACITY;
        return bucket[index];
    }

    public Pair<K,V> remove(Key k) {
        int index = k.hashCode() % CAPACITY;
        Pair<K,V> removed = bucket[index];
        bucket[index] = null;
        size--;
        return removed;
    }

    public K[] keySet() {
        ArrayList<K> keys = new ArrayList<K>();
        for (int i = 0; i < CAPACITY; i++){
            if (bucket[i] != null) {
                keys.add(bucket[i].key);
            }
        }
        return (K[]) keys.toArray();
    }

    public Pair<K,V>[] entrySet() {
        Pair<K,V> [] entries = (Pair<K,V>[]) new Pair[size];
        int j = 0;
        for (int i = 0; i < CAPACITY; i++){
            if (bucket[i] != null) {
                entries[j++] = bucket[i];
            }
        }
        return entries;
    }

}