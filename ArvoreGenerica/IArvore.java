import java.util.Iterator;

public interface IArvore{
    int size();

    int height();

    boolean isEmpty();

    Iterator elements();

    Iterator nos();

    No root();

    No parent(No no);

    Iterator children(No no);

    boolean isInternal();

    boolean isExternal();

    boolean isRoot();

    int depth(No no);

    Object replace(No no, Object o);
}