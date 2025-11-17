public interface Seq_Interface{

    public int size();
    
    public boolean isEmpty();

    public boolean isFirst(No no);

    public boolean isLast(No no);

    public Object first() throws ESeqVazia;

    public Object last() throws ESeqVazia;

    public Object before(int index) throws ESeqIndice, ESeqVazia;

    public Object after(int index) throws ESeqIndice, ESeqVazia;
    
    public void swapElements(No n, No q) throws NoInexistente, ESeqVazia;
    
    public Object remove(No no) throws ESeqVazia, NoInexistente;

    public Object elemAtRank(int index) throws ESeqIndice, ESeqVazia;

    public void insertAtRank(int index, Object o) throws ESeqIndice;

    public Object removeAtRank(int index) throws ESeqIndice, ESeqVazia;

    public Object replaceAtRank(int index, Object o) throws ESeqIndice, ESeqVazia;
    
    public void insertFirst(Object o);

    public void insertLast(Object o);

    public void insertBefore(No no, Object o) throws NoInexistente, ESeqVazia;

    public void insertAfter(No no, Object o) throws NoInexistente, ESeqVazia;

    public Object replaceElement(No no, Object o) throws ESeqIndice, ESeqVazia;

}
 