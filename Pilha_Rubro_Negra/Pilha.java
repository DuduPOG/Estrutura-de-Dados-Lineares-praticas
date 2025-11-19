/*
 * Created on 19/09/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Robinson
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public interface Pilha {

    public abstract int size();

    public abstract int size_vermelho();

    public abstract int size_preto();

    public abstract boolean isEmpty();

    public abstract boolean isEmpty_vermelho();

    public abstract boolean isEmpty_preto();

    public abstract Object top_vermelho() throws PilhaVaziaExcecao;

    public abstract Object top_preto() throws PilhaVaziaExcecao;

    public abstract void push_vermelho(Object o);

    public abstract void push_preto(Object o);

    public abstract Object pop_vermelho() throws PilhaVaziaExcecao;

    public abstract Object pop_preto() throws PilhaVaziaExcecao;

}
