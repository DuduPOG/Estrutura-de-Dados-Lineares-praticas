public interface Vetor_Interface {

    public int size();
    
    public boolean isEmpty();

    public boolean estaCheia();
    
    public int elemAtRank(Object o) throws EVetorIndice;
    
    public void removeAtRank(Object o) throws EVetorIndice;
    
    public void insertAtRank(Object o) throws EVetorIndice;

    public void replaceAtRank(Object o, Object p) throws EVetorIndice;
}
