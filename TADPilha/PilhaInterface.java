public interface PilhaInterface {
    
    int size();

    boolean isEmpty();

    Object top() throws EPilhaVazia;

    void stackUp(Object o);

    Object unStack() throws EPilhaVazia;

}
 