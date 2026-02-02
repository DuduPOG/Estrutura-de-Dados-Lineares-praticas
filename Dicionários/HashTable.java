import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Entry<K, V>>[] table;
    private int capacity;
    private int size;

    public HashTable() {
        this.capacity = 8;
        this.size = 0;
        this.table = new ArrayList[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new ArrayList<>();
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public List<K> keys(){
        List<K> keys = new ArrayList<>();

        for (int i = 0; i < this.capacity; ++i){
            for (Entry<K, V> entry : table[i]) {
                keys.add(entry.key);
            }
        }
        return keys;
    }

    private int hash(K key) {
        return 0; // implementar
    }

    public void insert(K key, V value) {
        // implementar
    }

    public V find(K key) {
        return null; // implementar
    }

    public void remove(K key) {
        // implementar
    }

    public int size() {
        return size;
    }
}