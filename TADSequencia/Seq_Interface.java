public interface Seq_Interface {

    public int size();
    
    public boolean isEmpty();

    public boolean isFirst(Object n);

    public boolean isLast(Object n);

    public Object first() throws ESeqVazia;

    public Object last() throws ESeqVazia;

    public Object before(int p) throws ESeqIndice, ESeqVazia;

    public Object after(int p) throws ESeqIndice, ESeqVazia;
    
    public void swapElements(Object n, Object q) throws ElementoInexistente, ESeqVazia;
    
    public Object remove(Object n) throws ESeqVazia, ElementoInexistente;

    public Object elemAtRank(int index) throws ESeqIndice, ESeqVazia;

    public void insertAtRank(int index, Object o) throws ESeqIndice;

    public Object removeAtRank(int index) throws ESeqIndice, ESeqVazia;

    public Object replaceAtRank(int index, Object o) throws ESeqIndice, ESeqVazia;
    
    public void insertFirst(Object o);

    public void insertLast(Object o);

    public void insertBefore(Object n, Object o) throws ElementoInexistente, ESeqVazia;

    public void insertAfter(Object n, Object o) throws ElementoInexistente, ESeqVazia;

    public Object replaceElement(Object n, Object o) throws ESeqIndice, ESeqVazia;

}
