public class PilhaLista  extends No implements PilhaInterface{
    private No head;
    private No tail;
    private int size;

    public PilhaLista(){
        this.head = new No();
        this.tail = new No();
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.size = 0;
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
        return this.tail.getPrev().getValue();
    }

    @Override
    public void stackUp(Object o){
        No novoTopo = new No();
        novoTopo.setPrev(this.tail.getPrev());
        novoTopo.setNext(this.tail);
        novoTopo.setValue(o);
        this.tail.getPrev().setNext(novoTopo);
        this.tail.setPrev(novoTopo);
        this.size++;
    }

    @Override
    public Object unStack() throws EPilhaVazia {
        if (isEmpty()){
            throw new EPilhaVazia("Pilha vazia");
        }
        Object toRemove = this.tail.getPrev().getValue();
        this.tail.getPrev().getPrev().setNext(this.tail);
        this.tail.setPrev(this.tail.getPrev().getPrev());
        this.size--;
        return toRemove;
    }
}