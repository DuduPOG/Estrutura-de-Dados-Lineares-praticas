public interface Vetor_Interface {

    public abstract int size();
    
    public abstract boolean isEmpty();
    
    public abstract Object elemAtRank(int index) throws EVetorIndice, EVetorVazio;
    
    public abstract Object removeAtRank(int index) throws EVetorIndice, EVetorVazio;
    
    public abstract void insertAtRank(int index, Object o) throws EVetorIndice;

    public abstract Object replaceAtRank(int index, Object o) throws EVetorIndice, EVetorVazio;

}
