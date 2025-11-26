public class PilhaArranjo implements PilhaInterface {
    private int size;
    private int capacity;
    private Object[] pilha;
    private int topo;

    public PilhaArranjo() {
        this.size = 0;
        this.capacity = 8;
        this.pilha = new Object[this.capacity];
        this.topo = -1;
    }

    public void increaseCapacity(){
        Object[] novaPilha = new Object[this.capacity *= 2];
        for (int i = 0; i < this.size; i++){
            novaPilha[i] = pilha[i];
        }
        pilha = novaPilha;
    }

    public void decreaseCapacity(){
        Object[] novaPilha = new Object[this.capacity /= 2];
        for (int i = 0; i < this.size; i++){
            novaPilha[i] = this.pilha[i];
        }
        this.pilha = novaPilha;
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public Object top() throws EPilhaVazia {
        if (isEmpty()){
            throw new EPilhaVazia("Pilha vazia");
        }
        return this.pilha[topo];
    }

    @Override
    public void stackUp(Object o){
        if (this.size == this.capacity){
            increaseCapacity();
        }
        this.pilha[this.size] = o;
        this.size++;
        this.topo++;
    }

    @Override
    public Object unStack() throws EPilhaVazia {
        if (isEmpty()){
            throw new EPilhaVazia("Pilha vazia");
        }
        Object toRemove = this.pilha[this.size--];
        if (this.size * 1.0 / this.capacity * 1.0 <= 1.0 / 3.0){
            decreaseCapacity();
        }
        this.size--;
        return this.pilha[this.topo--];
    }
}