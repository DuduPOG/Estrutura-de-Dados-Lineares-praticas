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