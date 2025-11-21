public interface IArvore {

    public abstract int size();

    public abstract int height();

    public abstract boolean isEmpty();

    public abstract Iterator elements();

    public abstract Iterator nos();

    public abstract Node root();

    public abstract Node parent(Node no);

    public abstract iterator children(Node no);

    public abstract boolean isInternal();

    public abstract boolean isExternal();

    public abstract boolean isRoot();

    public abstract int depth(Node no);

    public abstract Object replace(Node no, Object o);
}