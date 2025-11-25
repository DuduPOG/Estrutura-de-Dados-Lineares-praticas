import java.util.Iterator;

public interface IArvore{
    int size();

    int altura(No no);

    boolean isEmpty();

    Iterator elements();

    Iterator nos();

    No raiz();

    No pai(No no);

    Iterator Filhos(No no);

    boolean EInterno(No no);

    boolean EExterno(No no);

    boolean ERaiz(No no);

    int profundidade(No no);

    Object replace(No no, Object o);
}