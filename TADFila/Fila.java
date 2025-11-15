public interface Fila {

    public int tamanho();
    
    public boolean estaVazia();

    public boolean estaCheia();
    
    public Object inicio() throws EFilaVazia;
    
    public void enfileirar(Object o);
    
    public Object desenfileirar() throws EFilaVazia;
}
