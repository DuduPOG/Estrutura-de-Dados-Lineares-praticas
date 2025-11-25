public interface DequeInterface {

    int size();

    boolean isEmpty();

    Object first() throws DequeVazioExcecao;

    Object last() throws DequeVazioExcecao;

    void push_front(Object o);

    void push_back(Object o);

    Object pop_front() throws DequeVazioExcecao;

    Object pop_back() throws DequeVazioExcecao;
}
