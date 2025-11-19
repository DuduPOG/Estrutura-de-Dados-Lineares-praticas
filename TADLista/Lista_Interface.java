public interface Lista_Interface {

    public abstract int size();
    
    public abstract boolean isEmpty();

    public abstract boolean isFirst(No no);

    public abstract boolean isLast(No no);

    public abstract No first() throws EListaVazia;

    public abstract No last() throws EListaVazia;

    public abstract No before(int index) throws EListaIndice, EListaVazia;

    public abstract No after(int index) throws EListaIndice, EListaVazia;
    
    public abstract void swapElements(No n, No q) throws ElementoInexistente, EListaVazia;
    
    public abstract Object remove(No n) throws EListaVazia, ElementoInexistente;
    
    public abstract void insertFirst(Object o);

    public abstract void insertLast(Object o);

    public abstract No insertBefore(No n, Object o) throws EListaVazia;

    public abstract No insertAfter(No n, Object o) throws EListaVazia;

    public abstract Object replaceElement(No n, Object o) throws EListaIndice, EListaVazia;

}
