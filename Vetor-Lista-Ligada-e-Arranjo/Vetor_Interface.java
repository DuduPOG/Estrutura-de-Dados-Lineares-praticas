public interface Vetor_Interface {

    public int size();
    
    public boolean isEmpty();
    
    public Object elemAtRank(int index) throws EVetorIndice, EVetorVazio;
    
    public Object removeAtRank(int index) throws EVetorIndice, EVetorVazio;
    
    public void insertAtRank(int index, Object o) throws EVetorIndice;

    public Object replaceAtRank(int index, Object o) throws EVetorIndice, EVetorVazio;
}
