public interface Lista_Interface {

    public int size();
    
    public boolean isEmpty();

    public boolean isFirst(No no);

    public boolean isLast(No no);

    public No first() throws EListaVazia;

    public No last() throws EListaVazia;

    public No before(int index) throws EListaIndice, EListaVazia;

    public No after(int index) throws EListaIndice, EListaVazia;
    
    public void swapElements(No n, No q) throws ElementoInexistente, EListaVazia;
    
    public Object remove(No n) throws EListaVazia, ElementoInexistente;
    
    public void insertFirst(Object o);

    public void insertLast(Object o);

    public No insertBefore(No n, Object o) throws EListaVazia;

    public No insertAfter(No n, Object o) throws EListaVazia;

    public Object replaceElement(No n, Object o) throws EListaIndice, EListaVazia;

}
