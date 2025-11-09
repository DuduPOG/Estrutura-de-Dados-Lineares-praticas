public interface Lista_Interface {

    public int size();
    
    public boolean isEmpty();

    public boolean isFirst(Object n);

    public boolean isLast(Object n);

    public Object first();

    public Object last();

    public Object before(Object p) throws EListaIndice;

    public Object after(Object p) throws EListaIndice;
    
    public Object swapElements(Object n, Object q) throws EVetorIndice, EVetorVazio;
    
    public Object remove(Object n) throws EListaVazia;
    
    public void insertFirst(Object o);

    public void insertLast(Object o);

    public void insertBefore(Object n, Object o);

    public void insertAfter(Object n, Object o);

    public Object replaceElement(int n, Object o) throws EListaIndice, EListaVazia;

}
