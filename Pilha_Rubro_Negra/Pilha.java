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

    public int size();

    public int size_vermelho();

    public int size_preto();

    public boolean isEmpty();

    public boolean isEmpty_vermelho();

    public boolean isEmpty_preto();

    public Object top_vermelho() throws PilhaVaziaExcecao;

    public Object top_preto() throws PilhaVaziaExcecao;

    public void push_vermelho(Object o);

    public void push_preto(Object o);

    public Object pop_vermelho() throws PilhaVaziaExcecao;

    public Object pop_preto() throws PilhaVaziaExcecao;

}
