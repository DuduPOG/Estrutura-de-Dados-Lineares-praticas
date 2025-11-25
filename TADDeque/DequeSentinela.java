public class DequeSentinela implements DequeInterface{
    private No head;
    private No tail;
    private int size;
    
    public DequeSentinela() {
        this.head = new No();
        this.tail = new No();
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object first() throws DequeVazioExcecao {
        if (isEmpty()) {
            throw new DequeVazioExcecao("O Deque está vazio");
        }
        return this.head.getNext().getValue();
    }

    @Override
    public Object last() throws DequeVazioExcecao {
        if (isEmpty()) {
            throw new DequeVazioExcecao("O Deque está vazio");
        }
        return this.tail.getPrev().getValue();
    }

    @Override
    public void push_front(Object o) {
        No novo_no = new No();
        novo_no.setPrev(this.head);
        novo_no.setNext(this.head.getNext().getNext());
        novo_no.setValue(o);
        this.head.getNext().setPrev(novo_no);
        this.head.setNext(novo_no);
        ++this.size;
    }

    @Override
    public void push_back(Object o) {
        No novo_no = new No();
        novo_no.setPrev(this.tail.getPrev());
        novo_no.setNext(this.tail);
        novo_no.setValue(o);
        this.tail.getPrev().setNext(novo_no);
        this.tail.setPrev(novo_no);
        ++this.size;
    }

    @Override
    public Object pop_front() throws DequeVazioExcecao {
        if (isEmpty()) {
            throw new DequeVazioExcecao("O Deque está vazio");
        }
        Object to_remove = this.head.getNext().getValue();
        this.head.setNext(this.head.getNext().getNext());
        this.head.getNext().setPrev(this.head);
        this.size--;
        return to_remove;
    }

    @Override
    public Object pop_back() throws DequeVazioExcecao {
        if (isEmpty()) {
            throw new DequeVazioExcecao("O Deque está vazio");
        }
        Object to_remove = this.tail.getPrev().getValue();
        this.tail.setPrev(this.tail.getPrev().getPrev());
        this.tail.getPrev().setNext(this.tail);
        this.size--;
        return to_remove;
    }
}
