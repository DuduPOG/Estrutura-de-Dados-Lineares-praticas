public interface Seq_Interface{

    public int size();
    
    public boolean isEmpty();

    public boolean isFirst(No no);

    public boolean isLast(No no);

    public No first() throws ESeqVazia;

    public No last() throws ESeqVazia;

    public No before(No no) throws ESeqIndice, ESeqVazia;

    public No after(No no) throws ESeqIndice, ESeqVazia;
    
    public void swapElements(No n, No q) throws ESeqVazia;
    
    public Object remove(No no) throws ESeqVazia;

    public Object elemAtRank(int index) throws ESeqIndice, ESeqVazia;

    public void insertAtRank(int index, Object o) throws ESeqIndice;

    public Object removeAtRank(int index) throws ESeqIndice, ESeqVazia;

    public Object replaceAtRank(int index, Object o) throws ESeqIndice, ESeqVazia;
    
    public void insertFirst(Object o);

    public void insertLast(Object o);

    public No insertBefore(No no, Object o) throws ESeqVazia;

    public No insertAfter(No no, Object o) throws ESeqVazia;

    public Object replaceElement(No no, Object o) throws ESeqVazia;

}
 