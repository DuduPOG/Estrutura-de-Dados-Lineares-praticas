public interface Seq_Interface{

    public abstract int size();
    
    public abstract boolean isEmpty();

    public abstract boolean isFirst(No no);

    public abstract boolean isLast(No no);

    public abstract No first() throws ESeqVazia;

    public abstract No last() throws ESeqVazia;

    public abstract No before(No no) throws ESeqIndice, ESeqVazia;

    public abstract No after(No no) throws ESeqIndice, ESeqVazia;
    
    public abstract void swapElements(No n, No q) throws ESeqVazia;
    
    public abstract Object remove(No no) throws ESeqVazia;

    public abstract Object elemAtRank(int index) throws ESeqIndice, ESeqVazia;

    public abstract void insertAtRank(int index, Object o) throws ESeqIndice;

    public abstract Object removeAtRank(int index) throws ESeqIndice, ESeqVazia;

    public abstract Object replaceAtRank(int index, Object o) throws ESeqIndice, ESeqVazia;
    
    public abstract void insertFirst(Object o);

    public abstract void insertLast(Object o);

    public abstract No insertBefore(No no, Object o) throws ESeqVazia;

    public abstract No insertAfter(No no, Object o) throws ESeqVazia;

    public abstract Object replaceElement(No no, Object o) throws ESeqVazia;

}
 