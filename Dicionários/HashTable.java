import com.sun.jdi.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HashTable {

    private static class Entry {
        int key;
        Object value;

        Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Entry>[] table;
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
            for (Entry entry : table[i]) {
                keys.add(entry.key);
            }
        }
        return keys;
    }

    private int hash(int key) {
        return 0; // implementar
    }

    public void insert(int key, Object value) {
        // implementar
    }

    public Object find(int key) {
        return null; // implementar
    }

    public Object remove(int key) throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException("Tabela vazia ou chave inválida");
        }
        return this.table[key];
    }

    public int size() {
        return size;
    }
}