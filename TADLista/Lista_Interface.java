public interface Lista_Interface {

    public int size();
    
    public boolean isEmpty();

    public boolean isFirst(Object n) throws ElementoInexistente;

    public boolean isLast(Object n) throws ElementoInexistente;

    public Object first() throws EListaVazia;

    public Object last() throws EListaVazia;

    public Object before(Object p) throws EListaIndice, ElementoInexistente;

    public Object after(Object p) throws EListaIndice, ElementoInexistente;
    
    public Object swapElements(Object n, Object q) throws ElementoInexistente, EListaVazia;
    
    public Object remove(Object n) throws EListaVazia, ElementoInexistente;
    
    public void insertFirst(Object o);

    public void insertLast(Object o);

    public void insertBefore(Object n, Object o) throws ElementoInexistente;

    public void insertAfter(Object n, Object o) throws ElementoInexistente;

    public Object replaceElement(int index, Object o) throws EListaIndice, EListaVazia;

}
