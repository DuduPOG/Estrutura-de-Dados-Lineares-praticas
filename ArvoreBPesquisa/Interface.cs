interface Arvore
{
    int size();

    int height();

    bool isEmpty();

    iterator elements();

    iterator nos();

    No root();

    No parent(No no);

    iterator children(No no);

    bool isInternal();

    bool isExternal();

    bool isRoot();

    int depth(No no);

    object replace(No no, object o);
}