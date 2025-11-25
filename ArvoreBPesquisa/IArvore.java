import java.util.Iterator;

public interface IArvore {

    int size();

    int altura(No n);

    boolean isEmpty();

    Iterator elements();

    Iterator nos();

    No raiz();

    No pai(No no);

    Iterator children(No no);

    boolean EInterno(No n);

    boolean EExterno(No n);

    boolean ERaiz(No n);

    int profundidade(No no);

    Object replace(No no, Object o);
}