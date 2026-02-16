public class HeapArray {
    private int[] heap;
    private Object raiz;
    private int size;
    private int capacity;

    public HeapArray(){
        this.size = 0;
        this.raiz = null;
        this.capacity = 16;
        this.heap = new int[this.capacity];
    }
/* 
    public void increase_capacity(){
        int novaCapacidade = this.capacity * 2;
        int[] novaHeap = new int[novaCapacidade];
        for (int i = 0; i < this.size; ++i){
            novaHeap[i] = this.heap[i];
        }
        this.capacity = novaCapacidade;
    }
*/
    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }
    public int capacity(){
        return this.capacity;
    }

    public void insert(Object key){
        if (this.raiz == null){
            this.raiz = key;
        }
        for (int i = 1; i < this.capacity; i ){
            
        }
    }

    
}
