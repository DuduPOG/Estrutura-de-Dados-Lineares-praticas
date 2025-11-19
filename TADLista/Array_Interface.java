public interface Array_Interface {
    public abstract int size();
    
    public abstract boolean isEmpty();

    public abstract boolean isFirst(Object n);

    public abstract boolean isLast(Object n);

    public abstract Object first() throws EListaVazia;

    public abstract Object last() throws EListaVazia;

    public abstract Object before(int p) throws EListaIndice, EListaVazia;

    public abstract Object after(int p) throws EListaIndice, EListaVazia;
    
    public abstract void swapElements(Object n, Object q) throws EListaVazia;
    
    public abstract Object remove(Object n) throws EListaVazia, ElementoInexistente;
    
    public abstract void insertFirst(Object o);

    public abstract void insertLast(Object o);

    public abstract int insertBefore(Object n, Object o) throws EListaVazia;

    public abstract int insertAfter(Object n, Object o) throws EListaVazia;

    public abstract Object replaceElement(Object n, Object o) throws EListaIndice, EListaVazia;

}
