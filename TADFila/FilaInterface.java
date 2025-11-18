public interface FilaInterface {

    public abstract int tamanho();

    public abstract boolean estaVazia();
    
    public abstract Object inicio() throws EFilaVazia;
    
    public abstract void enfileirar(Object o);
    
    public abstract Object desenfileirar() throws EFilaVazia;
}
