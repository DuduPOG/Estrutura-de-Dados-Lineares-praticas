public interface Deque {
    public abstract int size();

    public abstract boolean isEmpty();

    public abstract Object first() throws DequeVazioExcecao;

    public abstract Object last() throws DequeVazioExcecao;

    public abstract void push_front(Object o);

    public abstract void push_back(Object o);

    public abstract Object pop_front() throws DequeVazioExcecao;

    public abstract Object pop_back() throws DequeVazioExcecao;
}
