public interface Array_Interface {
    public int size();
    
    public boolean isEmpty();

    public boolean isFirst(Object n);

    public boolean isLast(Object n);

    public Object first() throws EListaVazia;

    public Object last() throws EListaVazia;

    public Object before(int p) throws EListaIndice, EListaVazia;

    public Object after(int p) throws EListaIndice, EListaVazia;
    
    public void swapElements(Object n, Object q) throws EListaVazia;
    
    public Object remove(Object n) throws EListaVazia, ElementoInexistente;
    
    public void insertFirst(Object o);

    public void insertLast(Object o);

    public int insertBefore(Object n, Object o) throws EListaVazia;

    public int insertAfter(Object n, Object o) throws EListaVazia;

    public Object replaceElement(Object n, Object o) throws EListaIndice, EListaVazia;
}
