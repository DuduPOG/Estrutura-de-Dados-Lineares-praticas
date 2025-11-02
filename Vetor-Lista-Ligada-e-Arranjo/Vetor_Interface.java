public interface Vetor_Interface {

    public int size();
    
    public boolean isEmpty();
    
    public int elemAtRank(int index) throws EVetorIndice, EVetorVazio;
    
    public void removeAtRank(Object o) throws EVetorIndice, EVetorVazio;
    
    public void insertAtRank(Object o) throws EVetorIndice, EVetorVazio;

    public void replaceAtRank(Object o, Object index) throws EVetorIndice, EVetorVazio;
}
