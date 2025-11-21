using System;

Math

public class No
{
    private No pai;
    private int element;
    private No Filhos;

    public No()
    {
        this.pai = null;
        this.value = null;
        this.Filhos = null;
    }

    public setPai(No n)
    {
        this.pai = n;
    }

    public setElement(No n)
    {
        this.element = n;
    }

    public setFilhos(No n)
    {
        this.Filhos = n;
    }

    public getPai()
    {
        return this.pai;
    }

    public getElement()
    {
        return this.element;
    }

    public getFilhos()
    {
        return this.Filhos;
    }
}

public class Arvore : No
{
    private No pai;
    private int tamanho;
    private object elemento;
    private object filhos;

    public Arvore()
    {
        this.pai = null;
        this.tamanho = 0;
        this.elemento = null;
        this.filhos = null;
    }

    public int tamanho()
    {
        return this.tamanho;
    }

    public bool EInterno()
    {
        if (this.filhos != null)
        {
            return true;
        }
        return false;
    }

    public bool EExterno()
    {
        if (this.filhos == null)
        {
            return true;
        }
        return false;
    }

    public bool ERaiz()
    {
        if (this.pai == null)
        {
            return true;
        }
        return false;
    }

    public No pai(No no)
    {
        return no.getPai();
    }

    public object filhos(No no)
    {
        return no.getFilhos();
    }

    public profundidade(No no)
    {
        if (ERaiz())
        {
            return 0;
        }
        return 1 + pai(no);
    }

    public altura(No no)
    {
        if (EExterno())
        {
            return 0;
        }
        int h = 0;
        foreach (object elements in filhos(no))
        {
            h = System.Math.Max(h, altura(no));
        }
        return 1 + h;
    }
}